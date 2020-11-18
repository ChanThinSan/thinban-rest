package com.example.thinbanrest.core;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author thinban
 */
public class RequestUtils {
    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        if (RequestContextHolder.getRequestAttributes() == null) {
            return null;
        }
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static String getUrl() {
        String uri = getRequest().getRequestURI();
        int len = getRequest().getContextPath().length();
        return uri.substring(len);
    }
}