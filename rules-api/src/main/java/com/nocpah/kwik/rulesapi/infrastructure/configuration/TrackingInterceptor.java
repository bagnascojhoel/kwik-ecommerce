package com.nocpah.kwik.rulesapi.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class TrackingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var requestId = UUID.randomUUID().toString();
        var requestAttributes = new ServletRequestAttributes(request, response);
        requestAttributes.setAttribute("request-id", requestId, 0);
        RequestContextHolder.setRequestAttributes(requestAttributes);
        log.info("key=pre-request, request-id={}, method={}, path={}", requestId, request.getMethod(), request.getServletPath());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        var requestId = (String) request.getAttribute("request-id");
        log.info("key=post-request, request-id={}, method={}, path={}", requestId, request.getMethod(), request.getServletPath());
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
