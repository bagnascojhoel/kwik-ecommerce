package com.nocpah.kwik.rulesapi.integration.infrastructure.driving.rest.world;

import com.nocpah.kwik.rulesapi.RestTestConfiguration;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.ErrorDtoFactory;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.RestExceptionHandler;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.PostConstruct;

@WebMvcTest
@ContextConfiguration(classes = {RestExceptionHandler.class, RestTestConfiguration.class})
public abstract class AbstractRestTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ErrorDtoFactory errorDtoFactory;

    @PostConstruct
    public void setup() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }
}
