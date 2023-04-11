package com.app.appbase.config;

import com.app.appbase.utils.AppUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by TungBT - Bui Thanh Tung
 */

public class AppLocaleResolver extends AcceptHeaderLocaleResolver {
    private AppUtils appCoUtils;

    public AppLocaleResolver(AppUtils appCoUtils) {
        this.appCoUtils = appCoUtils;
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        return new Locale(appCoUtils.getLanguage(request));
    }
}
