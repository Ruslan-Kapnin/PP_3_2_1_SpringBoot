package ru.dego.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.dego.springBoot.dao.UserDAO;

@SpringBootApplication
public class Pp321SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(Pp321SpringBootApplication.class, args).getBean(UserDAO.class).init();
    }

}
