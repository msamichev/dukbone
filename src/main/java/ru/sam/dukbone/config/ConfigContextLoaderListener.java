package ru.sam.dukbone.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigContextLoaderListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String logbackConfigFile = servletContextEvent.getServletContext().getInitParameter("logback.configurationFile");
        if (logbackConfigFile != null) {
            Pattern pattern = Pattern.compile("\\$\\{(?<env>.*)\\}");
            Matcher matcher = pattern.matcher(logbackConfigFile);
            if (matcher.find()) {
                String envValue = System.getenv(matcher.group("env"));
                if (envValue != null) {
                    logbackConfigFile = matcher.replaceAll(envValue.replaceAll("\\\\", "/"));
                }
            }
            new LogbackConfigLoader(logbackConfigFile);
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}