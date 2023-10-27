package com.cmmarques22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@ComponentScan(basePackages = "com.cmmarques22")
@EnableAutoConfiguration
@Configuration
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //System.out.println("Hello Springboot");
    }
        @GetMapping("/greet")
        public GreetResponse greet() {
            GreetResponse response =  new GreetResponse(
                    "Hello Spring",

                    List.of("Golang", "Java", "Python"),

                    new Person("Camané")
                    );
            return response;
        }

        record Person(String name) {}

        record GreetResponse(
                String greet,
                List<String> favProgrammingLanguages,
                Person person
        ){

        };



//        static class GreetResponse {
//        private final String greet;
//
//        public GreetResponse(String greet){
//            this.greet = greet;
//        }
//
//            public String getGreet() {
//                return greet;
//            }
//
//            @Override
//            public String toString() {
//                return "GreetResponse{" +
//                        "greet='" + '\'' +
//                        '}';
//            }
//
//            @Override
//            public boolean equals(Object o) {
//                if (this == o) return true;
//                if (o == null || getClass() != o.getClass()) return false;
//                GreetResponse that = (GreetResponse) o;
//                return Objects.equals(greet, that.greet);
//            }
//
//            @Override
//            public int hashCode() {
//                return Objects.hash(greet);
//            }
//        }


}
