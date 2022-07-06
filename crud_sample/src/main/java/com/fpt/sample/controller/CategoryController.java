package com.fpt.sample.controller;

import com.fpt.sample.constant.CommonConstant;
import com.fpt.sample.entity.Categories;
import com.fpt.sample.model.CategoryDTO;
import com.fpt.sample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(CommonConstant.CATEGORY_URL)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(CommonConstant.CATEGORY_LIST_URL)
    public ResponseEntity<Map<String, Object>> getAllCategories(){
        Map<String, Object> response = Map.ofEntries(Map.entry("categories", categoryService.getAllCategory()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
