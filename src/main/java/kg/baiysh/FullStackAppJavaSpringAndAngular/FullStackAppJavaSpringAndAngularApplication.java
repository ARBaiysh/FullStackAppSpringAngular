package kg.baiysh.FullStackAppJavaSpringAndAngular;

import kg.baiysh.FullStackAppJavaSpringAndAngular.entity.User;
import kg.baiysh.FullStackAppJavaSpringAndAngular.repository.UserRepository;
import kg.baiysh.FullStackAppJavaSpringAndAngular.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@SpringBootApplication
public class FullStackAppJavaSpringAndAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackAppJavaSpringAndAngularApplication.class, args);


	}
}
