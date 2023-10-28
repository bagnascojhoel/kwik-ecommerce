plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api("software.amazon.awssdk:s3:2.16.77")
    api("org.mapstruct:mapstruct:1.4.2.Final")
    api("org.springdoc:springdoc-openapi-ui:1.5.9")
    api("org.springdoc:springdoc-openapi-data-rest:1.5.9")
    api("org.springframework.boot:spring-boot-devtools:2.5.4")
    api("org.springframework.boot:spring-boot-starter-data-rest:2.5.4")
    api("org.springframework.boot:spring-boot-starter-web:2.5.4")
    api("org.springframework.boot:spring-boot-starter-validation:2.5.4")
    api("org.springframework.boot:spring-boot-starter-security:2.5.4")
    api("org.springframework.boot:spring-boot-starter-data-jpa:2.5.4")
    api("mysql:mysql-connector-java:8.0.16")
    api("org.liquibase:liquibase-core:4.3.5")
    runtimeOnly("com.h2database:h2:1.4.200")
    testImplementation("org.mockito:mockito-inline:3.11.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.4")
    compileOnly("org.projectlombok:lombok:1.18.20")
}

group = "br.com.kwikecommerce"
version = "1.0.0-SNAPSHOT"
description = "kwik-ecommerce-api"
java.sourceCompatibility = JavaVersion.VERSION_17

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
