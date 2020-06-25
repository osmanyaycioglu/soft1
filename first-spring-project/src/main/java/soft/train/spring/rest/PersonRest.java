package soft.train.spring.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person/management")
public class PersonRest {

    @PutMapping
    public String provison(final Person person) {
        return "OK";
    }

    @GetMapping("/{personId}")
    public Person get(@PathVariable("personId") final long personId) {
        return null;
    }

    @DeleteMapping("/{personId}")
    public Person deactivate(@PathVariable("personId") final long personId) {
        return null;
    }

    @PatchMapping
    public String update(final Person person) {
        return null;
    }

}
