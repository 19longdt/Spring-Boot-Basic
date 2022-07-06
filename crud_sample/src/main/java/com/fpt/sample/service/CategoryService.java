package com.fpt.sample.service;

import com.fpt.sample.entity.Categories;
import com.fpt.sample.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategory();
}
