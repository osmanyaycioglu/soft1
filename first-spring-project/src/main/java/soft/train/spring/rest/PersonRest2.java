package soft.train.spring.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person/management/v1")
public class PersonRest2 {

    @PostMapping("/provison")
    public String provison(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/get/{personId}")
    public Person get(@PathVariable("personId") final long personId) {
        return null;
    }

    @GetMapping("/deactivate/{personId}")
    public Person deactivate(@PathVariable("personId") final long personId) {
        return null;
    }

    @PostMapping("/update")
    public String update(@RequestBody final Person person) {
        return null;
    }

    @PostMapping("/xyz")
    public String xyz(@RequestBody final Person person) {
        return null;
    }

}
