package ru.LearnUp.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.LearnUp.annotation.LogMethod;
import ru.LearnUp.annotation.WorkTime;

@Service
public class MyEventPublisher implements ApplicationContextAware {
    private ApplicationContext context;

    @LogMethod
    @WorkTime
    public void publisherEvent(String event) {
        context.publishEvent(new MyEvent(event));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
