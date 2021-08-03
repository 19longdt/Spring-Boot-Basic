package me.loda.spring.jpamysql;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        userRepository.findAllByAgiBetween(25,30).forEach(System.out::println);
        System.out.println("-------------------");
        userRepository.findAllByAgiBetweenQuery(25,30).forEach(System.out::println);
        System.out.println("========***========");
        userRepository.findAllByAgiGreaterThan(97).forEach(System.out::println);
        System.out.println("========***========");
        userRepository.findAllByAtk(74).forEach(System.out::println);
        System.out.println("========***========");
        User user = userRepository.findUserByDefQuery(49);
        System.out.println("User: " + user);
    }

    public static void JpaMySql(ApplicationContext context){

        UserRepository userRepository = context.getBean(UserRepository.class);

        // Laasy ra toafn bo User trong db
        // userRepository.findAll().forEach(System.out::println);

        // Lưu user xuống database
        User user = userRepository.save(new User());

        // Khi lưu xong, nó trả về User đã lưu kèm theo Id.
        System.out.println("User vừa lưu có ID: " + user.getId());
        Long userId = user.getId();

        // Cập nhật user.
        user.setAgi(100);
        userRepository.save(user);

        // Query lấy ra user vừa xong để kiểm tra xem.
        Optional<User> opUser = userRepository.findById(userId);
        User user2 = new User();

        if(opUser.isPresent()){
            user2 = opUser.get();

        }
        long a = user2.getId();
        System.out.println("User: " + user);
        System.out.println("User2: " + user2);

        // Xóa User khỏi DB
        userRepository.delete(user);

        // In ra kiểm tra xem userId còn tồn tại trong DB không
        User user3 = userRepository.findById(a).orElse(null);
        System.out.println("User3: " + user3);
        System.out.println( userRepository.findAll().get(userRepository.findAll().size() - 1));
    }
}
