package br.com.kwikecommerce.kwikecommerceapi.controller;

import br.com.kwikecommerce.kwikecommerceapi.dto.healthcheck.IsAliveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/health-check")
public class HealthCheck {

    @GetMapping("/{number}")
    public IsAliveResponseDto verifyIsAlive(@PathVariable Integer number) {
        return IsAliveResponseDto.builder()
                .value(number * 2)
                .build();
    }
}
