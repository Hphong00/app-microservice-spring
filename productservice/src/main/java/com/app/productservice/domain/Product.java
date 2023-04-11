package com.app.productservice.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseDomain {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "category_id")
    private String category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "manufacturer_id")
    private String manufacturerId;

    @Column(name = "product_attribute_id")
    private String productAttributeId;

    @Column(name = "brand_id")
    private String brandId;
}
