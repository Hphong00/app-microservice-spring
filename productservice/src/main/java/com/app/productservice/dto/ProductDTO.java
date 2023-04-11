package com.app.productservice.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.Instant;
@Data
public class ProductDTO {
    private String id;
    private Instant createdDate;
    private String createdUser;
    private Instant updatedDate;
    private String updatedUser;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String category;
    private String imageUrl;
    private String manufacturerId;
    private String productAttributeId;
    private String brandId;
}
