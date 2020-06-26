package soft.train.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soft.train.spring.rest.core.PersonManager;

@RestController
@RequestMapping("/person/management/v1")
public class PersonRest2 {

    @Autowired
    private PersonManager personManager;

    @PostMapping("/provison")
    public String provison(@RequestBody final Person person) {
        this.personManager.provision(person);
        return "OK";
    }

    @GetMapping("/get/{personId}")
    public Person get(@PathVariable("personId") final long personId) {
        return this.personManager.get(personId);
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
