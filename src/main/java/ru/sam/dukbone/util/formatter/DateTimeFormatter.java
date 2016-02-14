package ru.sam.dukbone.util.formatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;
import ru.sam.dukbone.util.LoggerWrapper;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 *
 */
public class DateTimeFormatter implements Formatter<LocalDateTime> {

    private static final Logger LOG = LoggerFactory.getLogger(DateTimeFormatter.class);

    private String datePattern;

    private java.time.format.DateTimeFormatter dateTimeFormatter;

    public String getDatePattern() {
        return datePattern;
    }

    @Required
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @PostConstruct
    public void init() {
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
    }

    public LocalDateTime parse(final String text, final Locale locale) throws ParseException {
        try {
            LOG.info("parse string " + text);
            return StringUtils.isEmpty(text) ? LocalDateTime.now() : LocalDateTime.parse(text, dateTimeFormatter);
        } catch (DateTimeParseException ex) {
            return LocalDateTime.parse(text, java.time.format.DateTimeFormatter.ISO_DATE_TIME);
        }
    }

    public String print(final LocalDateTime object, final Locale locale) {
        LOG.info("print object " + object);
        return object.format(dateTimeFormatter);
    }

}