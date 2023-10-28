package com.nocpah.kwik.rulesapi.integration.infrastructure.driven.h2_database;


import com.nocpah.kwik.rulesapi.RulesApiApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles(profiles = "integration-test")
@SpringBootTest(classes = {RulesApiApplication.class})
@Transactional
public abstract class AbstractH2DatabaseIntegrationTest {
}
