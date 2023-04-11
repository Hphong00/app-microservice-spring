package com.app.userservice.utils;

import com.app.userservice.constacts.AppConstant;
import com.app.userservice.dto.respon.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Service
public class AppUtils {
    private final Logger logger = LoggerFactory.getLogger(AppUtils.class);
    @Autowired
    private MessageSource messageSource;

    public <T> AppResponse<T> buildSuccessResponse(T data) {
        AppResponse<T> response = new AppResponse<>();
        response.setCode(AppConstant.APP_SUCCESS_CODE);
        response.setMessage(getMessageI18N(AppConstant.APP_SUCCESS_MESSAGE));
        response.setData(data);
        return response;
    }

    public String getMessageI18N(String messageCode) {
        return getMessageI18N(messageCode, null);
    }

    public String getMessageI18N(String messageCode, Object[] parameter) {
        return getMessageI18N(messageCode, LocaleContextHolder.getLocale(), parameter);
    }

    public String getLanguage(HttpServletRequest request) {
        String lang = request.getHeader("Language");
        if (AppConstant.LANG_EN.equalsIgnoreCase(lang)) {
            return lang;
        }

        return AppConstant.LANG_VI;
    }

    public String getMessageI18N(String messageCode, Locale locale, Object[] parameter) {
        if (messageCode == null) {
            return "";
        }

        try {
            return messageSource.getMessage(messageCode, parameter, locale);
        } catch (Exception ex) {
            logger.debug("SibCoUtils: Cant not find message with code = {}", messageCode);

            return messageCode;
        }
    }
}
