package com.nocpah.kwik.rulesapi.integration.infrastructure.driving.rest.world;

import com.nocpah.kwik.rulesapi.QueryMocker;
import com.nocpah.kwik.rulesapi.application.query.find_all_talk_registries.FindAllTalkRegistriesQuery;
import com.nocpah.kwik.rulesapi.application.usecase.say_to_the_world.SayToTheWorldUseCase;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.UrlConstants;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.RestWorldController;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.nocpah.kwik.rulesapi.fixture.output.FindAllTalkRegistriesOutputFixture.createDouglas;
import static com.nocpah.kwik.rulesapi.fixture.output.FindAllTalkRegistriesOutputFixture.createRodrigo;


@ContextConfiguration(classes = {RestWorldController.class})
public class RestWorldControllerTest extends AbstractRestTest {
    @MockBean
    SayToTheWorldUseCase sayToTheWorldUseCase;
    @MockBean
    FindAllTalkRegistriesQuery findAllTalkRegistriesQuery;

    @Test
    void shouldFetchAllTalkRegistries() {
        var queryResult = List.of(createDouglas(), createRodrigo());

        QueryMocker.when(findAllTalkRegistriesQuery).withoutInput().thenOnSuccess(queryResult);

        List<ExpectedAllTalkRegistriesDto> response = RestAssuredMockMvc.given()
                .get(UrlConstants.APPLICATION_PATH + "/worlds/talks")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .body()
                .jsonPath()
                .getList("$", ExpectedAllTalkRegistriesDto.class);
        Assertions.assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(queryResult);
    }

}
