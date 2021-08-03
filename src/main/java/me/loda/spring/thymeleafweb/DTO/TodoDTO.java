package me.loda.spring.thymeleafweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long id;

    private String title;
    private String detail;
    private Date datetime;}
