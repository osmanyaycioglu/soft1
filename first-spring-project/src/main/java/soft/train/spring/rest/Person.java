package soft.train.spring.rest;

import soft.train.spring.rest.validation.MyCheck;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Person {

    @NotEmpty(message = "Person name should not be empty.")
    @Size(min = 2,
          max = 30,
          message = "Person ın isminin uzunluğu 2 ile 30 arasında olabilir.")
    private String name;
    @MyCheck(checkStr = "API",
             message = "Surname API ile başlamalı")
    @NotEmpty
    private String surname;
    @Min(18)
    @Max(120)
    private int    age;

    public String getName() {
        return this.name;
    }

    public Person setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Person setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public int getAge() {
        return this.age;
    }

    public Person setAge(final int ageParam) {
        this.age = ageParam;
        return this;
    }

    @Override
    public boolean equals(final Object oParam) {
        if (this == oParam) {
            return true;
        }
        if (oParam == null || this.getClass() != oParam.getClass()) {
            return false;
        }
        final Person personLoc = (Person) oParam;
        return this.age == personLoc.age &&
               Objects.equals(this.name,
                              personLoc.name) &&
               Objects.equals(this.surname,
                              personLoc.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name,
                            this.surname,
                            this.age);
    }
}
