package soft.train.spring.rest;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import soft.train.spring.rest.validation.MyCheck;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
@Entity
@SecondaryTable(name = "person_date")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Cacheable
public class Person {

    @Id
    @GeneratedValue
    private long id;

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

    @Column(table = "person_date")
    private long createDate;
    @Column(table = "person_date")
    private long startDate;

    @Embedded
    private PersonExtra personExtra;

    @OneToOne(fetch = FetchType.EAGER,
              cascade = { CascadeType.ALL },
              mappedBy = "person")
    private Department department;

    @OneToMany(fetch = FetchType.EAGER,
               cascade = { CascadeType.ALL },
               mappedBy = "person")
    private List<Address> addresses;

    @Version
    private int ver;

    public PersonExtra getPersonExtra() {
        return this.personExtra;
    }

    public void setPersonExtra(final PersonExtra personExtraParam) {
        this.personExtra = personExtraParam;
    }

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


    public long getId() {
        return this.id;
    }

    public void setId(final long idParam) {
        this.id = idParam;
    }

    public long getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(final long createDateParam) {
        this.createDate = createDateParam;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public void setStartDate(final long startDateParam) {
        this.startDate = startDateParam;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(final Department departmentParam) {
        this.department = departmentParam;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(final List<Address> addressesParam) {
        this.addresses = addressesParam;
    }
}
