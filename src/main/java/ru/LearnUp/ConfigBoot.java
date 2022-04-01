package ru.LearnUp;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class ConfigBoot {
    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("text");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
