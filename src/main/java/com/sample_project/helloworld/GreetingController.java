package com.sample_project.helloworld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {

  private final GreetingService greetingService;

  public GreetingController(GreetingService greetingService){
    this.greetingService = greetingService;
  }

  @GetMapping(value = "/greet")
  public ResponseEntity<String> helloWorld(){
    return ResponseEntity.ok().body(greetingService.greet());
  }
}
