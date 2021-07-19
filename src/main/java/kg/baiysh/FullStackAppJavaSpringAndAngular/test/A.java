package kg.baiysh.FullStackAppJavaSpringAndAngular.test;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class A {
    private String f;

    public A() {
        f = "asdf";
    }

    void printA() {
        System.out.println(f);
    }

    @Bean
    public String getF() {
        return f;
    }
}
