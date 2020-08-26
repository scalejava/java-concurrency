package com.scalejava.concurrency.arrayblockingqueue;

import java.util.concurrent.BlockingQueue;

public class MessageConsumer implements Runnable {

    private BlockingQueue<Message> messageChannel;

    public MessageConsumer(BlockingQueue<Message> messageChannel) {
        this.messageChannel = messageChannel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messageChannel.take();
                System.out.println(String.format("[%s] [Consumer] Consumed message %s", Thread.currentThread().getName(), message));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
