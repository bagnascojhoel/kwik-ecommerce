package com.nocpah.kwik.rulesapi.application.query.find_all_talk_registries;

import com.nocpah.kwik.rulesapi.common.annotation.Query;
import com.nocpah.kwik.rulesapi.common.query.SqlQueryExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

@Query
@RequiredArgsConstructor
public class FindAllTalkRegistriesQueryImpl implements FindAllTalkRegistriesQuery {
    private final SqlQueryExecutor sqlQueryExecutor;

    @Override
    public void query(@Nullable Void input, FindAllTalkRegistriesPresenter presenter) {
        var statement = """
                SELECT
                    talk_registry_code,
                    sayer_name,
                    world_name,
                    sayer_speech,
                    world_response,
                    talked_at
                FROM
                    talk_registry
                """;
        var result = this.sqlQueryExecutor.queryForList(statement, FindAllTalkRegistriesOutput.class);
        presenter.onSuccess(result);
    }
}
