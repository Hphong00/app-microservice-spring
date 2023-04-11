package com.app.userservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author Vinci
 */
@Getter
@Setter
@MappedSuperclass
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @Column(name = "updated_user")
    private String updatedUser;

//    @PrePersist
//    public void prePersist() {
//        this.setCreatedDate(Instant.now());
//        this.setCreatedUser(StringUtils.isNotEmpty(SecurityUtil.getCurrentUserLogin().get()) ? SecurityUtil.getCurrentUserLogin().get() : "SYSTEM");
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.setUpdatedDate(Instant.now());
//        this.setCreatedUser(StringUtils.isNotEmpty(SecurityUtil.getCurrentUserLogin().get()) ? SecurityUtil.getCurrentUserLogin().get() : "SYSTEM");
//    }

}

