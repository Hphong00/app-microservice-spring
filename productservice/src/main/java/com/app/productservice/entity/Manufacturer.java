package com.app.productservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "manufacturer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Manufacturer extends BaseDomain {
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "website")
    private String website;
    @Column(name = "description")
    private String description;
    @Column(name = "logo")
    private String logo;
}
