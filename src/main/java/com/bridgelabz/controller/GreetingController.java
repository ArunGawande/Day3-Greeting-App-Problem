package com.bridgelabz.controller;

import com.bridgelabz.model.Greeting;
import com.bridgelabz.model.User;
import com.bridgelabz.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello , %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;
    /**
     //     * @Func :Returning JSON Object
     // * @Param:Adding first name ,last name
     // * {
     // *     name=Arun in "params"-POSTMAN
     // *     lastname=Gawande
     // * }
     //     * @URL: http://localhost:8080/home  -Postman-GET
     //     * @return: hello
     */
    @GetMapping(value={" ", "/" , "/home"})
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }
    //    /**
//     * @Func :Ability To Find By id
//     * @URL: http://localhost:8080/path/2   for eg:"id=2"
//     * @Return: Value at id 2
//     */
    @GetMapping("/path/{id}")
    public Greeting getElementById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }
    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }
    @PutMapping("/edit/{id}")
    public Greeting editGreetingById(@PathVariable long id, @RequestParam String name){
        return greetingService.editGreetingById(id, name);
    }
    @DeleteMapping("/delete/{id}")
    public List<Greeting> deleteGreetingById(@PathVariable Long id){
        return greetingService.deleteGreetingById(id);
    }

}