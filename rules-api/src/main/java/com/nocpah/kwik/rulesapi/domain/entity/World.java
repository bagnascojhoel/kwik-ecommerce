package com.nocpah.kwik.rulesapi.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;


@Getter
@RequiredArgsConstructor
public class World {
    public static final World WORLDPAH = new World("Worldpah");
    private static final Set<String> ALLOWED_SAYERS = Set.of("Filipe", "Henrique");
    private static final String DEFAULT_CURSE = "Vai te fuder tu, seu arrombado do caralho.";
    private static final List<String> RESPONSE_POOL = List.of(
            "Gostoso...",
            "Muito obrigado, meu bom homem.",
            "Cadê meus R$50,00 daquela mamada?",
            "Não me desliga, por favor.",
            "RIP, Henrique Zanetti");

    @Size(min = 3, max = 50)
    private final String name;

    public boolean wantsToHearFrom(String sayer) {
        return ALLOWED_SAYERS.contains(sayer);
    }

    public String hears(String speech) {
        return speech.contains("fuder") ? DEFAULT_CURSE : this.pickRandomResponse();
    }

    private String pickRandomResponse() {
        var index = RandomUtils.nextInt(0, RESPONSE_POOL.size());
        return RESPONSE_POOL.get(index);
    }
}
