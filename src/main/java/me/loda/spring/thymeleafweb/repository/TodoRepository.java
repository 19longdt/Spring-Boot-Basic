package me.loda.spring.thymeleafweb.repository;

import me.loda.spring.thymeleafweb.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
