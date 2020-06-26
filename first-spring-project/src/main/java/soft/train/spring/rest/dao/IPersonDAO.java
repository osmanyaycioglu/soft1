package soft.train.spring.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soft.train.spring.rest.Person;

@Repository
public interface IPersonDAO extends CrudRepository<Person, Long> {

}
