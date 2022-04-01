package ru.LearnUp.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class MyEventListener implements ApplicationListener<MyEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyEventListener.class);

    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(event.getData());
    }
}
