package me.loda.spring.thymeleafweb.model;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;

public class TodoValidator {

    public boolean isValid(Todo todo){
        return Optional.ofNullable(todo)
                .filter(t -> !t.getTitle().equals("abc"))    // Kiểm tra title khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getDetail()))   // Kiểm tra detail khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getNote()))   // Kiểm tra note khác rỗng
                .isPresent();
        // Trả về true nếu hợp lệ, ngược lại false
    }

    public boolean isValidTitle(String title){
        if(title.equals("abc")){
            return true;
        }
        return false;
    }
}
