package me.loda.spring.componentscan;

import me.loda.spring.componentscan.other.OtherGirl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("me.loda.spring.componentscan.other")
@SpringBootApplication(scanBasePackages = "me.loda.spring.componentscan.other")
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        try {
        Girl girl = context.getBean(Girl.class);
            System.out.println("Bean: " + girl.toString());
        }catch (Exception e){
            System.out.println("Bean Girl không tồn tại");
        }

        try {
            OtherGirl otherGirl = context.getBean(OtherGirl.class);
            if (otherGirl != null) {
                System.out.println("Bean: " + otherGirl.toString());
            }
        } catch (Exception e) {
            System.out.println("Bean Girl không tồn tại");
        }
    }


}
