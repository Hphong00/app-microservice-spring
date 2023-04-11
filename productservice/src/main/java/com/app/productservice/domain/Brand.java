package com.app.productservice.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "brand")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Brand extends BaseDomain {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "logo")
    private String logo;
    @Column(name = "address")
    private String address;
    @Column(name = "website")
    private String website;
    @Column(name = "established_date")
    private Date establishedDate;
    @Column(name = "contac_information")
    private String contactInformation;
    @Column(name = "product_categories")
    private String productCategories;
}
