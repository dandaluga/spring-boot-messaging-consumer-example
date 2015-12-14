package com.daluga.messaging.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

// This class is annotated with a JMS listener and as a result will listen for inbound messages
// on the queue. That also means the program will remain running until you cancel out.
// TODO: How do I configure the number of listeners?

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "baseball.request")
    public void receiveQueue(String text) {
        LOGGER.debug("Received message: " + text);
        System.out.println(text);
    }

}
