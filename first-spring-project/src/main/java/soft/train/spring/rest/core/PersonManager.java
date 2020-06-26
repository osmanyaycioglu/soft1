package soft.train.spring.rest.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.train.spring.rest.Person;
import soft.train.spring.rest.dao.IPersonDAO;

@Service
public class PersonManager {

    @Autowired
    private IPersonDAO personDAO;

    public void provision(final Person person) {
        this.personDAO.save(person);
    }

    public Person get(final long personId) {
        return this.personDAO.findById(personId)
                             .get();
    }

}
