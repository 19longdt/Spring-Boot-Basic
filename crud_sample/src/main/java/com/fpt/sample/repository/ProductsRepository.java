package com.fpt.sample.repository;

import com.fpt.sample.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    @Query(value = "SELECT * FROM Products where category_id = :id and delete_flag = 0",
            //   countQuery = "select count(*) from Products where category_id = :id and delete_flag = 0",
            nativeQuery = true)
    List<Products> getListProductByCategoryId(@Param(value = "id") Integer id, Pageable pageable);

    @Query(value = "SELECT * FROM Products where category_id = :id and name LIKE CONCAT('%',:product_name,'%') and delete_flag = 0 ",
            nativeQuery = true)
    List<Products> getListProductBySearchAndCategoryId(@Param(value = "id") Integer id, @Param(value = "product_name") String product_name, Pageable pageable);

    @Query(value = "select count(*) from Products where category_id = :id and delete_flag = 0", nativeQuery = true)
    int getSizeByCategoryId(@Param(value = "id") Integer id);

    @Query(value = "select count(*) from Products where category_id = :id and name LIKE CONCAT('%',:product_name,'%') and delete_flag = 0", nativeQuery = true)
    int getSizeBySearchAndCategoryId(@Param(value = "id") Integer id, @Param(value = "product_name") String product_name);
}
