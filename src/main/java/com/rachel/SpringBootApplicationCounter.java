package com.rachel;

// Imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// All your code should be inside this one class
@SpringBootApplication          // needed for web server to start
@RestController                 // expose methods as REST services to clients
public class SpringBootApplicationCounter {
    // Run the application and listen for requests
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationCounter.class, args);
    }

    // Create a variable static int count = 0;
    static int count = 0;

    // All methods should have a @GetMapping
    // Create a method to get current count. i.e localhost:8080/current-count
    @GetMapping(path = "current-count")
    int getCurrentCount() {     // gets the current count
        return count;
    }

    // Create method to increment the count. i.e localhost:8080/increment-count
    @GetMapping(path = "increment-count")
    int incrementCount() {
        // return count++;      // returns and then increments
        return ++count;         // increments and then returns
    }

    // Create method to decrement the count. i.e localhost:8080/decrement-count
    @GetMapping(path = "decrement-count")
    int decrementCount() {
        // return count--;      // returns and then decrements
        return --count;         // decrements and then returns
    }

    // Test your api with chrome
    // http://localhost:8080/current-count
    // http://localhost:8080/increment-count
    // http://localhost:8080/decrement-count

}