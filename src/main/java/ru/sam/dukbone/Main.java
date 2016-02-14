package ru.sam.dukbone;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        byte[] bytes = messageDigest.digest("a1234567".getBytes());
        String s = new String(Base64.getEncoder().encode(bytes));

        System.out.println(bytes);
        System.out.println(s);


        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/spring-app.xml");
        ctx.refresh();
        Contact test = ctx.getBean("test", Contact.class);
        System.out.println("test info: " + test);

        ConversionService conversionService =
                ctx.getBean("conversionService", ConversionService.class);
        System.out.println("Birthdate of contact is : " +
                conversionService.convert(test.getBirthDate(), String.class));

    }
}
