package com.company;

import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }



//
//
//    @Bean
//    public CommandLineRunner run() {
//        CommandLineRunner clr = new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//
//                List<User> list = userDao.getAll(null, null, null);
//                System.out.println(list);
//                User u = list.get(0);
//                u.setName(u.getName().toLowerCase());
//                userDao.updateUser(u);
//                System.out.println("Name " + u.getName());
//            }
//        };
//        return clr;
//    }

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserServiceInter userDao;
//
//    @Bean
//    public CommandLineRunner run() {
//        CommandLineRunner clr = new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//
////                List<User> list = userRepository.findAll();
////                List<User> list2 =userRepository.findAll(Sort.by(Sort.Order.desc("id")));
////                System.out.println(list2);
////                User u=userRepository.findByName("alim");
////                User u2=userRepository.findByNameAndSurname("asif","Kamilov");
////                User u3=userRepository.findByEmail("asim@gmail.com");
//                List<User> u=userDao.getAll(null,null,null);
//
//                System.out.println(u);
//
//            }
//        };
//        return clr;
//    }
}
