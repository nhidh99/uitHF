package com.example;

//import com.example.dao.UserDAO;
//import com.example.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.dao")
@ComponentScan(basePackages = "com.example")
public class BakeryStoreApplication /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(BakeryStoreApplication.class, args);
    }

//    @Autowired
//    UserDAO userDAO;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//      User user = new User();
//		user.setName("Nhi");
//		user.setUsername("user");
//		user.setPassword(passwordEncoder.encode("user"));
//		userDAO.save(user);
//		System.out.println(user);
//    }
}