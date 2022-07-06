package com.fpt.sample.controller;

import com.fpt.sample.constant.CommonConstant;
import com.fpt.sample.model.ProductDTO;
import com.fpt.sample.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
//@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(CommonConstant.PRODUCT_URL)
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @GetMapping(CommonConstant.PRODUCT_LIST_BY_CATEGORY_URL)
    public ResponseEntity<Map<String, Object>> getProductsByCategory(@RequestParam(value = "categoryId") int categoryId,
                                                                     @RequestParam(value = "currentPage") Integer currentPage) {

        Map<String, Object> response = productsService.getProductByCategory(categoryId, currentPage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(CommonConstant.PRODUCT_LIST_BY_SEARCH_URL)
    public ResponseEntity<Map<String, Object>> getProductBySearchAndCategory(@RequestParam(value = "categoryId") int categoryId,
                                                                             @RequestParam(value = "productName") String textSearch,
                                                                             @RequestParam(value = "currentPage") Integer currentPage) {

        Map<String, Object> response = productsService.getProductBySearchAndCategory(categoryId, textSearch, currentPage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
