package soft.train.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import soft.train.spring.rest.core.PersonManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SynchronizationType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person/management/v2")
// @RequestScope
// @SessionScope
// @ApplicationScope
public class PersonRest2V2 {

    private Map<Long, Person> personMap = new HashMap<>();

    @Autowired
    private MyTestObj obj;

    @Autowired
    private PersonRest2 rest2;

    @Autowired
    private PersonManager personManager;

    @PostMapping("/insert")
    public String provison(final Person person) {
        this.personMap.put(person.getId(),
                           person);
        return "OK";
    }

    @GetMapping("/get/{personId}")
    public Person get(@PathVariable("personId") final long personId, final HttpRequest httpRequestParam) {
        final Person personLoc = this.personMap.get(personId);
        return personLoc;
    }

    @GetMapping("/getall")
    public List<Person> getAll() {
        final List<Person> pl = new ArrayList<>(this.personMap.values());
        EntityManagerFactory entityManagerFactory;
        SynchronizationType synchronizationType;
        return pl;
    }

    @GetMapping("/deactivate/{personId}")
    public Person deactivate(@PathVariable("personId") final long personId) {
        return null;
    }

    @PostMapping("/update")
    public String update(final Person person) {
        return null;
    }


}
