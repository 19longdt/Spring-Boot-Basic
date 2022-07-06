package com.fpt.sample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fpt.sample.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "Categories")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories extends BaseEntity {

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "categories")
    List<Products> products;
}
