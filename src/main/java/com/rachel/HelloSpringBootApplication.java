package com.rachel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
// Within this class, enables Rest functionality - to build a Restful API
@RestController
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

    // Specifies whether method will be a get/post/put/delete request
    // If don't specify a path, localhost:8080 is the root (default) path
    @GetMapping
    String greet() {
        // returns greeting message
        return "Hello Rachel";
    }

    // Include name parameters
    // e.g.
    // localhost:8080/?name=Rachel
    // This is an optional parameter (i.e. /?name=) - don't have to include it
    // (Note: "/name" doesn't work here in the path!)
    @GetMapping(params = "name")
    String greetName(@RequestParam String name) {
        return "Hello " + name + ", how are you today?";
    }

    // Set path to localhost:8080/ping
    // Note: Can't have the same method under the same path
    @GetMapping(path = "ping")
    String ping() {
        // returns 'pong'
        return "pong";
    }

    // * * * * * * * * * * * * * * * * * * * * * * * *

//    // Put the Person class underneath the method, or it doesn't work!
//    // getPerson method with return type Person, with path: localhost8080/people
//    // 9Install Json viewer Chrome plugin)
//    @GetMapping(path = "people")
//    Person getPerson() {
//        return new Person("Alex", 24);
//    }
//    // This gives us this object - key-value pairs, i.e fields (name, age) and values:
//    // http://localhost:8080/people
//    // {
//    // "name": "Alex",
//    //         "age": 24
//    // }

    // getPerson method with return type Person, with path: localhost8080/people
    //
    @GetMapping(path = "people")
    List<Person> getPerson() {
        // Return a list of people
        return List.of(
                new Person("Rachel", 35),
                new Person("Amy", 21)
        );
    }
    // Returns this: (square brackets - list - can add as many people as we like, above)
    // http://localhost:8080/people
    //[
    //  {
    //    "name": "Rachel",
    //    "age": 35
    //  },
    //  {
    //    "name": "Amy",
    //    "age": 21
    //  }
    //]

    // * * * * * * * * * * * * * * * * * * * * * * * *

    // Person class
    static class Person {
        String name;
        Integer age;

        // Default Constructor
        public Person() {

        }

        // Constructor
        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        // Generate Getters & Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        // ToString
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        // Equals & Hashcode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) && Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

    }

}
