package ru.sam.dukbone.util.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StringToLocalDateTimeConverter
        implements Converter<String, LocalDateTime> {

    private static final Logger LOG = LoggerFactory.getLogger(StringToLocalDateTimeConverter.class);

    private String datePattern;

    private DateTimeFormatter dateTimeFormatter;

    public String getDatePattern() {
        return datePattern;
    }

    @Required
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @PostConstruct
    public void init() {
        dateTimeFormatter = DateTimeFormatter.ofPattern(datePattern);
    }

    @Override
    public LocalDateTime convert(String dateString) {
        LOG.info("convert string " + dateString);
        try {
            return StringUtils.isEmpty(dateString) ? LocalDateTime.now() : LocalDateTime.parse(dateString, dateTimeFormatter);
        } catch (DateTimeParseException ex) {
            return LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
        }
    }
}