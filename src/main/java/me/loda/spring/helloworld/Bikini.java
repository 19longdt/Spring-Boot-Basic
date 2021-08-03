package me.loda.spring.helloworld;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bikini")
// đánh dấu là bộ bikini mới
@Scope("prototype")
public class Bikini implements Outfit {
    @Override
    public void wear() {
        System.out.println("mặc bikini");
    }
}

