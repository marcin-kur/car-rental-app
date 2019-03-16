package com.carrental.rest_wrappers;

import java.time.LocalDate;

import com.carrental.services.utils.LocalDateDeserializer;
import com.carrental.services.utils.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

public class OrderRequest {

    @Getter
    private Long carId;

    @Getter
    private Long addressId;

    @Getter
    private String clientName;

    @Getter
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @Getter
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;
}
