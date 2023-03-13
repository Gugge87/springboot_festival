package at.ingenium.exercise.exercise_3_315_springboot.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    // using /greeting results in output of Hello World!
    // using /greeting?name=Hansi results in output of Hello Hansi!
   @GetMapping("/greeting")
   public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
   {
       return new Greeting(1, "Hello " + name + "!");
   }
}
