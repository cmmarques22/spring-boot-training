package com.cmmarques22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
            return new GreetResponse(
                    "Hello Spring",

                    List.of("Golang(loading)", "Java", "Python"),

                    new Person("Camané", 32, 1.87)
                    );
        }

        record Person(String name, int age, double height) {}

        record GreetResponse(
                String greet,
                List<String> favProgrammingLanguages,
                Person person
        ){

        }



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
