package com.app.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductReceiver {


    @RabbitListener(queues = "product.queue")
    public void listenMessage(String queue){
        System.out.println("hasilnya " + queue);
    }
}
