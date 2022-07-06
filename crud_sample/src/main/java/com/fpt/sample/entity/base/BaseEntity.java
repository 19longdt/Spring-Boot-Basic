package com.fpt.sample.entity.base;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    @Column(name = "create_datetime")
    private LocalDateTime createdAt;

    @Column(name = "update_datetime")
    private LocalDateTime updatedAt;
}
