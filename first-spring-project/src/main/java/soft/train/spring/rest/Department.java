package soft.train.spring.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private long departmentId;

    private String departmentName;
    private int    workingYear;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER,
              cascade = { CascadeType.ALL })
    private Person person;

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(final String departmentNameParam) {
        this.departmentName = departmentNameParam;
    }

    public int getWorkingYear() {
        return this.workingYear;
    }

    public void setWorkingYear(final int workingYearParam) {
        this.workingYear = workingYearParam;
    }

    public long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(final long departmentIdParam) {
        this.departmentId = departmentIdParam;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(final Person personParam) {
        this.person = personParam;
    }
}
