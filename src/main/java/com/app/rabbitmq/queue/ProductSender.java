package com.app.rabbitmq.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProductSender {
    private static Logger logger = LogManager.getLogger(ProductSender.class);

    @Autowired
    @Qualifier("product.queue")
    private Queue queue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
        logger.info("Sending Message to the Queue : " + message);
    }

}
