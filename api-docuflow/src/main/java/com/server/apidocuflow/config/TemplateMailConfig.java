package com.server.apidocuflow.config;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * Configuration class for setting up Thymeleaf template engine for email
 * templates.
 */
@Configuration
public class TemplateMailConfig {

    /**
     * Configures the SpringTemplateEngine with template resolver and message
     * source.
     *
     * @return the configured TemplateEngine
     */
    @Bean
    public TemplateEngine springTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(emailTemplateResolver());
        templateEngine.setTemplateEngineMessageSource(emailMessageSource());
        return templateEngine;
    }

    /**
     * Configures the template resolver for email templates.
     *
     * @return the configured ITemplateResolver
     */
    @Bean
    public ITemplateResolver emailTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        templateResolver.setCacheable(false);

        return templateResolver;
    }

    /**
     * Configures the message source for email templates.
     *
     * @return the configured ResourceBundleMessageSource
     */
    @Bean
    public ResourceBundleMessageSource emailMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("mailMessages");
        return messageSource;
    }

    /**
     * Creates email content by processing the specified template with the given
     * variables.
     *
     * @param template  the name of the template to process
     * @param variables a map of variables to be used in the template
     * @return the processed email content as a String
     */
    public String createContent(String template, Map<String, Object> variables) {
        final Context context = new Context();
        context.setVariables(variables);
        return springTemplateEngine().process(template, context);
    }
}
