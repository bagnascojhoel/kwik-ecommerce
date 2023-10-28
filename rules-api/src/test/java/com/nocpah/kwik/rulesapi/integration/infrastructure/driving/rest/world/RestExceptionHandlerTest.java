package com.nocpah.kwik.rulesapi.integration.infrastructure.driving.rest.world;

import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.UrlConstants;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

@WebMvcTest
@ContextConfiguration
public class RestExceptionHandlerTest extends AbstractRestTest {

    @Test
    void shouldBe404WhenRequestsAreMadeToNonExistentEndpoint() {
        RestAssuredMockMvc.given()
                .get(UrlConstants.APPLICATION_PATH + "/my-url")
                .then()
                .status(HttpStatus.NOT_FOUND);
    }
}
