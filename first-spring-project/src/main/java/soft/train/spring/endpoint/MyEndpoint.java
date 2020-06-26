package soft.train.spring.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import soft.train.spring.rest.Person;

@Endpoint(id = "myEnd",
          enableByDefault = true)
@Component
public class MyEndpoint {

    @ReadOperation
    public Person getPerson() {
        final Person personLocm = new Person();
        personLocm.setName("osman");
        personLocm.setSurname("yay");
        return personLocm;
    }

}
