package ru.LearnUp.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j

public class MyEvent extends ApplicationEvent {
    private final String data;

    public MyEvent(String data) {
        super(data);
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
