package com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world;

import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.dto.AllTalkRegistriesDto;
import com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.dto.SayToTheWorldDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.nocpah.kwik.rulesapi.infrastructure.driving_ports.rest.world.RestWorldApiDefinition.TAG;

@Tag(name = TAG)
public interface RestWorldApiDefinition {
    String TAG = "World";

    @Operation(tags = TAG, description = "A sayer can try to talk with the world. But the world only listens to specific sayers.")
    ResponseEntity<Void> sayToTheWorld(@RequestBody SayToTheWorldDto request);

    @Operation(tags = TAG, description = "Find all talk registries")
    ResponseEntity<List<AllTalkRegistriesDto>> findAllTalkRegistries();
}
