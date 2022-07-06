package com.fpt.sample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fpt.sample.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "Products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status")
    private Integer status;

    @Column(name = "produced")
    private LocalDateTime produced;

    @Column(name = "price")
    private Float price;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private Categories categories;
}
