package com.scalejava.concurrency.arrayblockingqueue;

import java.time.LocalDateTime;

public class Message {

    private String publisherName;
    private LocalDateTime timestamp;

    public Message(String publisherName) {
        this.publisherName = publisherName;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Message(publisherName = %s, timestamp = %s)", publisherName, timestamp);
    }
}
