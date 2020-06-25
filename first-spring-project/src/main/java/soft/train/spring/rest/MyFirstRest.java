package soft.train.spring.rest;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/first")
public class MyFirstRest {

    @PostMapping("/hello")
    public static String hello2() {
        return "POST Hello ";
    }

    @GetMapping("/hello2/{xyz}/{abc}")
    public static String hello2(@PathVariable("xyz") final String name,
                                @PathVariable("abc") final String surname) {
        return "GET Hello " + name + " " + surname;
    }

    @GetMapping("/hello3")
    public static String hello3(@RequestParam("xyz") final String name,
                                @RequestParam("abc") final String surname) {
        return "GET Hello " + name + " " + surname;
    }

    @GetMapping("/hello4/{uvf}")
    public static String hello4(@RequestParam("xyz") final String name,
                                @RequestParam("abc") final String surname,
                                @PathVariable("uvf") final int age) {
        return "GET Hello 4 : " + name + " " + surname + " " + age;
    }

    @GetMapping("/hello5/{uvf}")
    public static String hello5(@RequestHeader("xyz") final String name,
                                @RequestHeader("abc") final String surname,
                                @PathVariable("uvf") final int age) {
        return "GET Hello 5 : " + name + " " + surname + " " + age;
    }

    @PostMapping("/hello6")
    public static String hello6(@RequestBody final Person personParam) {
        return "GET Hello 6 : " + personParam.getName() + " " + personParam.getSurname() + " " + personParam.getAge();
    }

    @PostMapping(value = "/hello7",
                 consumes = { MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE },
                 produces = { MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE })
    public static Person hello7(@RequestBody final Person personParam) {
        return personParam.setName("osman")
                          .setSurname("yay");
    }

    @PostMapping(value = "/hello8")
    public static Person hello8(@Validated @RequestBody final Person personParam) {
        if (personParam.getAge() == 49) {
            throw new IllegalArgumentException("49 olamaz");
        }
        return personParam.setName("osman")
                          .setSurname("yay");
    }

    @GetMapping("/hello")
    public static String hello() {
        return "GET Hello ";
    }

    @PostMapping(value = "/hello9")
    public static MyResponse<Person> hello9(@Validated @RequestBody final Person personParam) {
        if (personParam.getAge() == 49) {
            throw new IllegalArgumentException("49 olamaz");
        }
        //        final MyResponse<Person> personMyResponseLoc = new MyResponse<>();
        //        personMyResponseLoc.setErrorOccured(false);
        //        personMyResponseLoc.setResponse(personParam.setName("osman")
        //                                                   .setSurname("yay"));
        return MyResponse.of(personParam.setName("osman")
                                        .setSurname("yay"));
    }

}




