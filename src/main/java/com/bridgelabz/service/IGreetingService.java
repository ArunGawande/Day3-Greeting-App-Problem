package com.bridgelabz.service;

import com.bridgelabz.model.Greeting;
import com.bridgelabz.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);
    List<Greeting> getAll();
    Greeting editGreetingById(long id, String name);
    List<Greeting> deleteGreetingById(Long id);


}