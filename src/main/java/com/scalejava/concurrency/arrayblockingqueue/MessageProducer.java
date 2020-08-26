package com.scalejava.concurrency.arrayblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MessageProducer implements Runnable {

    private String name;
    private BlockingQueue<Message> messageChannel;
    private boolean keepAlive;

    public MessageProducer(String name, BlockingQueue<Message> messageChannel) {
        this.name = name;
        this.messageChannel = messageChannel;
        this.keepAlive = true;
    }

    @Override
    public void run() {
        while (keepAlive) {
            try {
                Message message = new Message(name);
                messageChannel.put(message);
                System.out.println(String.format("[%s] [%s] Produced message %s", Thread.currentThread().getName(), name, message));
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(100, 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}