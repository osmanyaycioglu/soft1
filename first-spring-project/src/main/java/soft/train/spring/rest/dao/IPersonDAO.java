package soft.train.spring.rest.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import soft.train.spring.rest.Person;

import java.util.List;

@Repository
public interface IPersonDAO extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameAndSurname(String name, String surname);

    List<Person> findByNameIn(List<String> name);

    @Query("select p from Person p where p.name=:isim")
    List<Person> searchName(@Param("isim") String name);

    @Modifying
    @Query("update Person p set p.surname=:ss where p.name=:isim")
    List<Person> searchName2(@Param("isim") String name, @Param("ss") String surname);

    @Query(value = "select * from Person where name=:isim",
           nativeQuery = true)
    List<Person> searchNameNative(@Param("isim") String name);

}
