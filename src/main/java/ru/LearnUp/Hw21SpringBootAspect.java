package ru.LearnUp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.LearnUp.event.MyEventPublisher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

@Slf4j
@SpringBootApplication
public class Hw21SpringBootAspect {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(Hw21SpringBootAspect.class, args);

        Locale locale = Locale.getDefault();
        Integer secretNam = (int) (Math.random() * 1000);
        System.out.println(secretNam);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            MyEventPublisher pub = context.getBean(MyEventPublisher.class);
            // System.out.println(context.getMessage("hi", new Object[]{}, locale.ENGLISH));
            //log.info(context.getMessage("hi", new Object[0], locale));
            pub.publisherEvent(context.getMessage("hi", null, locale));
            int read = Integer.parseInt(reader.readLine());

            while (read != secretNam) {
                if (read < secretNam) {
                    //System.out.println(context.getMessage("bigger", null, locale));
                    //log.info(context.getMessage("bigger", null, locale));
                    pub.publisherEvent(context.getMessage("bigger", null, locale));
                }
                if (read > secretNam) {
                    //System.out.println(context.getMessage("less", null, locale));
                    //log.info(context.getMessage("less", null, locale));
                    pub.publisherEvent(context.getMessage("less", null, locale));
                }
                //System.out.println(context.getMessage("try", null, locale));
                //log.info(context.getMessage("try", null, locale));
                pub.publisherEvent(context.getMessage("try", null, locale));
                read = Integer.parseInt(reader.readLine());
            }
            // System.out.println(context.getMessage("guessed", new Object[]{"" + secretNam}, locale) + secretNam);
            //log.info(context.getMessage("guessed", new Object[]{secretNam.toString()}, locale));
            pub.publisherEvent(context.getMessage("guessed", new Object[]{secretNam.toString()}, locale));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
