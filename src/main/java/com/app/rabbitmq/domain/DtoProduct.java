package com.app.rabbitmq.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class DtoProduct {

    private String id;
    private String name;
    private Integer qty;
    private Float price;
    private String typeMessage;
}