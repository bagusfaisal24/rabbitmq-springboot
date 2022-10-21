package com.app.rabbitmq.service;

import com.app.rabbitmq.domain.DtoProduct;
import com.app.rabbitmq.queue.ProductSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PublisherSvcImpl implements PublisherSvc {

    private final ProductSender productSender;

    @Autowired
    public PublisherSvcImpl(ProductSender productSender) {
        this.productSender = productSender;
    }

    @Override
    public Map<String, Object> sendMessage(DtoProduct dtoProduct) {
        try {
            String message = new ObjectMapper().writeValueAsString(dtoProduct);
            productSender.send(message);
            return mapData(message, false);
        } catch (Exception e) {
            return mapData(e.getMessage(), true);
        }
    }

    private Map<String, Object> mapData(String message, boolean error) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", error);
        map.put("message", message);
        return map;
    }
}
