package com.nocpah.kwik.rulesapi;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.ImportOptions;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

/**
 * On our architecture, there are layers and types of components. The layers are four: Business Logic, Application Logic, Infrastructure, Common. There is an unidirectional flow of access from those layers.
 * <p>
 * Within each layer,
 */
public class ArchitectureTest {
    static String APPLICATION_LOGIC = "Application Logic";
    static String BUSINESS_LOGIC = "Business Logic";
    static String INFRA_CONFIGURATIONS = "Configurations";
    static String INFRA_DRIVING_PORTS = "Driving Ports";
    static String INFRA_DRIVEN_PORTS = "Driven Ports";
    static String PACKAGE_BASE = "com.nocpah.kwik.rulesapi";
    static String PACKAGE_COMMON = PACKAGE_BASE + ".common..";
    static String PACKAGE_APPLICATION = PACKAGE_BASE + ".application..";
    static String PACKAGE_DOMAIN = PACKAGE_BASE + ".domain..";
    static String PACKAGE_INFRA_CONFIGURATION = PACKAGE_BASE + ".infrastructure.configuration..";
    static String PACKAGE_INFRA_DRIVING = PACKAGE_BASE + ".infrastructure.driving_ports..";
    static String PACKAGE_INFRA_DRIVEN = PACKAGE_BASE + ".infrastructure.driven_ports..";

    final JavaClasses projectClasses = new ClassFileImporter(
            new ImportOptions().with(new ImportOption.DoNotIncludeTests())
    ).importPackages(PACKAGE_BASE);

    @Test
    void layersUnidirectionalAccess() {
        Architectures.layeredArchitecture()
                .layer(APPLICATION_LOGIC).definedBy(PACKAGE_APPLICATION)
                .layer(BUSINESS_LOGIC).definedBy(PACKAGE_DOMAIN)
                .layer(INFRA_CONFIGURATIONS).definedBy(PACKAGE_INFRA_CONFIGURATION)
                .layer(INFRA_DRIVING_PORTS).definedBy(PACKAGE_INFRA_DRIVING)
                .layer(INFRA_DRIVEN_PORTS).definedBy(PACKAGE_INFRA_DRIVEN)

                .whereLayer(INFRA_CONFIGURATIONS).mayOnlyBeAccessedByLayers(INFRA_DRIVEN_PORTS, INFRA_DRIVING_PORTS)
                .whereLayer(BUSINESS_LOGIC).mayOnlyBeAccessedByLayers(APPLICATION_LOGIC, INFRA_DRIVEN_PORTS, INFRA_DRIVING_PORTS, INFRA_CONFIGURATIONS)
                .whereLayer(APPLICATION_LOGIC).mayOnlyBeAccessedByLayers(INFRA_CONFIGURATIONS, INFRA_DRIVING_PORTS)
                .whereLayer(INFRA_DRIVEN_PORTS).mayOnlyBeAccessedByLayers(INFRA_CONFIGURATIONS)
                .whereLayer(INFRA_DRIVING_PORTS).mayOnlyBeAccessedByLayers(INFRA_CONFIGURATIONS)

                .check(projectClasses);
    }

    @Test
    void codeCommonToAllLayersShouldNotAccessAnyProjectLayer() {
        String[] projectModules = {
                PACKAGE_DOMAIN,
                PACKAGE_APPLICATION,
                PACKAGE_INFRA_CONFIGURATION,
                PACKAGE_INFRA_DRIVEN,
                PACKAGE_INFRA_DRIVING};
        ArchRuleDefinition
                .noClasses().that().resideInAnyPackage(PACKAGE_COMMON)
                .should().accessClassesThat().resideInAnyPackage(projectModules)
                .check(projectClasses);
    }

    @Test
    void domainShouldOnlyAccessAllowedLibraries() {
        String[] packagesThatDomainCanUse = {
                "java..",
                "javax..",
                PACKAGE_DOMAIN,
                PACKAGE_COMMON,
                "lombok",
                "org.springframework.util",
                "org.apache.commons.lang3"};
        ArchRuleDefinition
                .classes().that().resideInAnyPackage(PACKAGE_DOMAIN)
                .should().onlyAccessClassesThat().resideInAnyPackage(packagesThatDomainCanUse)
                .check(projectClasses);
    }
}
