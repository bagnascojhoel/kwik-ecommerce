package com.nocpah.kwik.rulesapi.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.regex.Pattern;

// TODO Test
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegExUtil {
    public static boolean matches(@Nullable String pattern, @Nullable CharSequence value) {
        return pattern != null && value != null && Pattern.matches(pattern, value);
    }
}
