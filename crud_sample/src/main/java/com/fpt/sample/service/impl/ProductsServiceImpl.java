package com.fpt.sample.service.impl;

import com.fpt.sample.constant.CommonConstant;
import com.fpt.sample.entity.Products;
import com.fpt.sample.model.ProductDTO;
import com.fpt.sample.repository.ProductsRepository;
import com.fpt.sample.service.ProductsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Map<String, Object> getProductByCategory(int id, int currentPage) {
        int size = productsRepository.getSizeByCategoryId(id);
        Map<String, Object> condition = new HashMap<>();
        condition.put("category_id", id);
        condition.put("textSearch", "");

        return getPagingProductDto(condition, size, currentPage);
    }

    @Override
    public Map<String, Object> getProductBySearchAndCategory(int id, String search, int currentPage) {
        int size = productsRepository.getSizeBySearchAndCategoryId(id, search);
        Map<String, Object> condition = new HashMap<>();
        condition.put("category_id", id);
        condition.put("textSearch", search);

        return getPagingProductDto(condition, size, currentPage);
    }

    public Map<String, Object> getPagingProductDto(Map<String, Object> condition, int size, int currentPage) {
        Map<String, Object> response = new HashMap<>();
        List<Products> products = new ArrayList<>();

        // calculate SizeByCategoryId, sizePerPage, totalPage
        int sizePerPage = CommonConstant.SIZE_PER_PAGE;
        int totalPage = size % sizePerPage == 0 ? size / sizePerPage : (size / sizePerPage) + 1;

        // check currentPage
        if (currentPage < 0) {
            currentPage = 0;
        } else if (currentPage > totalPage - 1) {
            currentPage = totalPage - 1;
        }
        Pageable pageable = PageRequest.of(currentPage, CommonConstant.SIZE_PER_PAGE);

        String cid = condition.get("category_id").toString();
        String textSearch = condition.get("textSearch").toString();

        if (textSearch.isEmpty() && !cid.isEmpty()) {
            products = productsRepository.getListProductByCategoryId(Integer.parseInt(cid), pageable);

        } else if (!textSearch.isEmpty() && !cid.isEmpty()) {
            products = productsRepository.getListProductBySearchAndCategoryId(Integer.parseInt(cid), textSearch, pageable);
            response.put("textSearch", textSearch);
        }
        List<ProductDTO> productDTOList = new ArrayList<>();

        // mapper entity to model
        for (Products p : products) {
            productDTOList.add(modelMapper().map(p, ProductDTO.class));
        }
        Page<ProductDTO> productDTOPage = new PageImpl<>(productDTOList);

        // result
        response.put("category_id", cid);
        response.put("ProductsByCategory", productDTOPage.getContent());
        response.put("currentPage", currentPage);
        response.put("totalItems", productDTOPage.getTotalElements());
        response.put("totalPages", totalPage);

        return response;
    }
}
