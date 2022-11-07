package com.project.springBootJwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.springBootJwt.domain.Role;
import com.project.springBootJwt.domain.User;
import com.project.springBootJwt.service.UserService;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.project.springBootJwt"))                                     
          .build();                                       
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return arg -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new User(null,"Kutlu Özdemir","kozdemir141", "55431921", new ArrayList<>()));
			userService.saveUser(new User(null,"Bahadır Özdemir","bozdemir141", "55431921", new ArrayList<>()));
			userService.saveUser(new User(null,"Engin Özdemir","eozdemir141", "55431921", new ArrayList<>()));
			userService.saveUser(new User(null,"Gülçin Özdemir","gozdemir141", "55431921", new ArrayList<>()));
			
			userService.addRoleToUser("kozdemir141", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("kozdemir141", "ROLE_ADMIN");
			userService.addRoleToUser("kozdemir141", "ROLE_USER");
			
			userService.addRoleToUser("bozdemir141", "ROLE_ADMIN");
			userService.addRoleToUser("bozdemir141", "ROLE_USER");
			
			userService.addRoleToUser("eozdemir141", "ROLE_MANAGER");
			userService.addRoleToUser("eozdemir141", "ROLE_USER");
		};
	}
}
