package me.loda.spring.thymeleafweb.service;

import me.loda.spring.thymeleafweb.DTO.TodoDTO;
import me.loda.spring.thymeleafweb.model.Todo;
import me.loda.spring.thymeleafweb.model.TodoValidator;
import me.loda.spring.thymeleafweb.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoValidator validator;

    /**
     * Lấy ra danh sách List<Todo>
     *
     * @param limit - Giới hạn số lượng lấy ra
     *
     * @return Trả về danh sách List<Todo> dựa theo limit, nếu limit == null thì trả findAll()
     */
    public List<Todo> findAll(Integer limit){
        return Optional.ofNullable(limit)
                .map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> todoRepository.findAll());
    }

    /**
     * Thêm một Todo mới vào danh sách công việc cần làm
     *
     * @return Trả về đối tượng Todo sau khi lưu vào DB, trả về null nếu không thành công
     */

    public Todo add(Todo todo) {
        if (validator.isValid(todo)) {
            return todoRepository.save(todo);
        }
        return null;
    }
    public String addd(Todo todo) {
        if(!validator.isValidTitle(todo.getTitle())){

            return "Sai title";
        }
        todoRepository.save(todo);
        return "";
    }

    public String addTodo(Todo todo, Model model){
        String message = "";
        boolean isSuccess = false;
        if(!validator.isValidTitle(todo.getTitle())){
            model.addAttribute("sai", "saitittle");
//            return "Sai title";
        }
        if(todo.getDetail().length() < 3){
            model.addAttribute("sai1", "saidetail");
        }

        if(isSuccess){
            todoRepository.save(todo);
                return "redirect:/listTodo";
        }else{
            return "addTodo";
        }


    }


    public Todo getTodobyId(Long id) {
        return todoRepository.getOne(id);
    }
}
