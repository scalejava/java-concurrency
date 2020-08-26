package com.scalejava.concurrency.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo {


    public static void main(String[] args) {
        BlockingQueue<Message> messageChannel = new ArrayBlockingQueue<>(1024);

        MessageProducer messageProducer = new MessageProducer("Producer-1", messageChannel);
        MessageConsumer messageConsumer = new MessageConsumer(messageChannel);

        new Thread(messageProducer, "t-producer-1").start();
        new Thread(messageConsumer, "t-consumer-1").start();
    }
}
