package br.com.kwikecommerce.api.application.configuration.interceptor;

import br.com.kwikecommerce.api.application.service.localization.LocalizationService;
import br.com.kwikecommerce.api.application.service.logging.LogService;
import br.com.kwikecommerce.api.application.service.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
@RequiredArgsConstructor
public class DebbuggerInterceptor implements HandlerInterceptor {

    private final LocalizationService localizationService;
    private final LogService logService;
    private final SecurityService securityService;

    @Override
    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    ) throws Exception {
        logService.logInfo(localizationService.fetch("log.debugger-interceptor.pre-handle", securityService.getKeycloakId()));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        Exception ex
    ) throws Exception {
        logService.logInfo(localizationService.fetch("log.debugger-interceptor.after-completion", securityService.getKeycloakId()));
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
