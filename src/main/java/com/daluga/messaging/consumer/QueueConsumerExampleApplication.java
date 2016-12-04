package com.daluga.messaging.consumer;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms
public class QueueConsumerExampleApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueConsumerExampleApplication.class);

    @Value("${queue.name}")
    private String queueName;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(QueueConsumerExampleApplication.class);
        application.setApplicationContextClass(AnnotationConfigApplicationContext.class);
        SpringApplication.run(QueueConsumerExampleApplication.class, args);
    }

    @Bean
    public Queue queue() {
        //return new ActiveMQQueue(queueName);
        return new ActiveMQQueue("baseball.request");
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.debug("Spring Boot messaging producer example  has started....");
        LOGGER.debug("Listening on queue name: " + queueName);
        LOGGER.debug("Spring Boot messaging producer example has ended....");
    }
}
