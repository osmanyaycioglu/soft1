package soft.train.spring.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/first")
public class MyFirstRest {

    @GetMapping("/hello")
    public String hello(){
        return "GET Hello ";
    }
    @PostMapping("/hello")
    public String hello2(){
        return "POST Hello ";
    }
    @GetMapping("/hello2/{xyz}/{abc}")
    public String hello2(@PathVariable("xyz") String name,
                         @PathVariable("abc") String surname){
        return "GET Hello " + name + " " + surname;
    }
    @GetMapping("/hello3")
    public String hello3(@RequestParam("xyz") String name,
                         @RequestParam("abc") String surname){
        return "GET Hello " + name + " " + surname;
    }
    @GetMapping("/hello4/{uvf}")
    public String hello4(@RequestParam("xyz") String name,
                         @RequestParam("abc") String surname,
                         @PathVariable("uvf") int age){
        return "GET Hello 4 : " + name + " " + surname + " " + age;
    }
    @GetMapping("/hello5/{uvf}")
    public String hello5(@RequestHeader("xyz") String name,
                         @RequestHeader("abc") String surname,
                         @PathVariable("uvf") int age){
        return "GET Hello 5 : " + name + " " + surname + " " + age;
    }

    @PostMapping("/hello6")
    public String hello6(@RequestBody Person personParam){
        return "GET Hello 6 : " + personParam.getName() + " " + personParam.getSurname() + " " +  personParam.getAge();
    }

}




