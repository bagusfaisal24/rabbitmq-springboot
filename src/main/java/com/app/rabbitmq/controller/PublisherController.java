package com.app.rabbitmq.controller;

import com.app.rabbitmq.domain.DtoProduct;
import com.app.rabbitmq.service.PublisherSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/v1/send")
public class PublisherController {

    private final PublisherSvc publisherSvc;

    @Autowired
    public PublisherController(PublisherSvc publisherSvc) {
        this.publisherSvc = publisherSvc;
    }

    @PostMapping
    public Map<String, Object> send(@RequestBody DtoProduct dtoProduct){
        return publisherSvc.sendMessage(dtoProduct);
    }
}
