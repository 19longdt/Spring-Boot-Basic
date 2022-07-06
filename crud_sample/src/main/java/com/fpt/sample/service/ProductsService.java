package com.fpt.sample.service;

import com.fpt.sample.entity.Products;
import com.fpt.sample.model.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductsService {
   Map<String, Object> getProductByCategory(int id, int currentPage);
   Map<String, Object> getProductBySearchAndCategory(int id,String search ,int currentPage);
}
