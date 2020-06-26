package soft.train.spring.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import soft.train.spring.rest.Person;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        final Person personLocm = new Person();
        personLocm.setName("osman");
        personLocm.setSurname("yay");
        return Health.status(Status.UP)
                     .withDetail("info",
                                 personLocm)
                     .build();
    }
}
