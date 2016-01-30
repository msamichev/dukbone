package ru.sam.dukbone.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class LogbackConfigLoader {

    private Logger logger = LoggerFactory.getLogger(LogbackConfigLoader.class);

    public LogbackConfigLoader(String configFile) {
        File logbackConfigFile = new File(configFile);
        if (!logbackConfigFile.exists()) {
            logger.debug("Logback external config file does not exists");
        } else {
            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(loggerContext);
            loggerContext.reset();
            try {
                configurator.doConfigure(logbackConfigFile);
            } catch (JoranException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}