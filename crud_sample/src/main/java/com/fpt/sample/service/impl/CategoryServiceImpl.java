package com.fpt.sample.service.impl;

import com.fpt.sample.entity.Categories;
import com.fpt.sample.model.CategoryDTO;
import com.fpt.sample.repository.CategoryRepository;
import com.fpt.sample.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Categories> categories = categoryRepository.getAllCategory();

        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Categories c: categories) {
            categoryDTOList.add(modelMapper.map(c, CategoryDTO.class));
        }
        return categoryDTOList;
    }
}
