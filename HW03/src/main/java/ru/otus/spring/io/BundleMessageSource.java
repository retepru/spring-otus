package ru.otus.spring.io;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.spring.config.AppProps;

@Component
public class BundleMessageSource implements Bundle {
    private final MessageSource messageSource;
    private final AppProps appProps;
    private final ConsoleOut consoleOut;

    public BundleMessageSource(MessageSource messageSource, AppProps appProps, ConsoleOut consoleOut) {
        this.messageSource = messageSource;
        this.appProps = appProps;
        this.consoleOut = consoleOut;
    }

    @Override
    public String getString(String bundle, Object ...args) {
        return messageSource.getMessage(bundle, args, appProps.getLocale());
    }

    public String getString(String bundle) {
        return getString(bundle, new String[]{});
    }

}
