package me.loda.spring.thymeleafweb.controller;

import me.loda.spring.thymeleafweb.DTO.TodoDTO;
import me.loda.spring.thymeleafweb.model.Todo;
import me.loda.spring.thymeleafweb.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class TodoController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TodoService todoService;

    /*
    @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
    Nó sẽ gán dữ liệu của param-name tương ứng vào biến
     */
    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        // Trả về đối tượng todoList.
        List<Todo> listTodo = todoService.findAll(limit);
       List<TodoDTO> listTodoDTO =  listTodo.stream().map(this::convertToDto).collect(Collectors.toList());
       model.addAttribute("todoList", listTodoDTO);
        // Trả về template "listTodo.html"
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    /*
   @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
    */
    @PostMapping("/addTodo")
    public String addTodo(@RequestBody Todo todo, Model model) {
           // todoService.addd(todo);

//        todoService.add(todo);
//
//        return "redirect:/listTodo";
//        return Optional.ofNullable(todoService.add(todo))
//                .map(t -> "redirect:/listTodo") // Trả về success nếu save thành công
//                .orElse("/addTodo"); // Trả về failed nếu không thành công
        //return new ResponseEntity<>("sai", HttpStatus.BAD_REQUEST);
       return todoService.addTodo(todo, model);

    }

    private TodoDTO convertToDto(Todo todo) {
        TodoDTO todoDto = modelMapper.map(todo, TodoDTO.class);
        todoDto.setDatetime(Calendar.getInstance().getTime());
        return todoDto;
    }

    private Todo convertToEntity(TodoDTO todoDto) throws ParseException {
        Todo todo = modelMapper.map(todoDto, Todo.class);
//        todo.setSubmissionDate(postDto.getSubmissionDateConverted(
//                userService.getCurrentUser().getPreference().getTimezone()));

        if (todoDto.getId() != null) {
            Todo oldTodo = todoService.getTodobyId(todoDto.getId());
                todo.setNote("New note");
        }
        return todo;
    }
}
