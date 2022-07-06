package com.fpt.sample.repository;

import com.fpt.sample.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

    @Query(value = "SELECT c.id, c.name, " +
            "c.create_datetime, c.update_datetime, c.delete_flag " +
            "FROM Categories c " +
            "WHERE c.delete_flag = 0 ", nativeQuery = true)
    List<Categories> getAllCategory();
}
