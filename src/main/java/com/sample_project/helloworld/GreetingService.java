package com.sample_project.helloworld;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
  public final String DEFAULT_GREETING = "Hello World!";

  public String greet(){
    return DEFAULT_GREETING;
  }

}
