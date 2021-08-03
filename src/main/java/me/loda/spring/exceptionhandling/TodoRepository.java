package me.loda.spring.exceptionhandling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
//    @Query("SELECT t FROM todo t WHERE t.id = :id")
//    Todo findTodoByID(@Param("id") Integer id);
}
