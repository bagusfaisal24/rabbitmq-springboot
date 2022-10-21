package com.app.rabbitmq.service;

import com.app.rabbitmq.domain.DtoProduct;

import java.util.Map;

public interface PublisherSvc {

    Map<String, Object> sendMessage(DtoProduct dtoProduct);
}
