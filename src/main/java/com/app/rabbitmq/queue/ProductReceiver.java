package com.app.rabbitmq.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductReceiver {

    private static Logger LOGGER = LogManager.getLogger(ProductReceiver.class);


    @RabbitListener(queues = "product.queue")
    public void listenMessage(String queue){
        LOGGER.info("message receive = " + queue);
    }
}
