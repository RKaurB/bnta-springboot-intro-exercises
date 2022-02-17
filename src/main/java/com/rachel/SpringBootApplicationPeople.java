package com.rachel;

// Imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Needed for web server to start
@SpringBootApplication
// Expose methods as REST services to clients
@RestController
// All your code should be inside this one class
public class SpringBootApplicationPeople {

    // create a static List of type person with few people inside
    static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {

        // Create person object using the Person class
        Person rachel = new Person(1, "Rachel", 35);
        Person amy = new Person(2, "Amy", 35);
        Person emma = new Person(3, "Emma", 35);

        // Add person object to the people list
        people.add(rachel);
        people.add(amy);
        people.add(emma);

        // Run Springboot application
        SpringApplication.run(SpringBootApplicationPeople.class, args);
    }

    // Implement getPersonById method
    @GetMapping(path = "people/{id}")
    // Accepts id argument in path, e.g. localhost8080/1
    // Return person with matching id
    // (Note: Integer id accepts null, whereas int does not (only 0))
    public Person getPersonById(@PathVariable("id") Integer id) {
        // Enhanced for loop
        // Loops through people array list
        for (Person person : people) {
            // Returns person that matches id
            if (person.getId() == id) {
                return person;
            }
        }
        // Else returns null
        return null;
    }

    // Create another method that returns all people using @GetMapping("people")
    @GetMapping(path = "everyone")
    public List<Person> getAllPeople() {
        // Returns all people in the list
        return people;
    }
}

// Test api using chrome
// http://localhost:8080/everyone
// http://localhost:8080/people/2

// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

// Create a class called Person with following properties: id, name, age
// Person class
class Person {
    private int id;
    private String name;
    private int age;

    // Default Constructor
    public Person() {

    }

    // Constructor
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter & Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ToString
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // Equals & HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
