package soft.train.spring.rest;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class PersonExtra {

    private String    gender;
    private LocalDate birthday;

    public String getGender() {
        return this.gender;
    }

    public void setGender(final String genderParam) {
        this.gender = genderParam;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(final LocalDate birthdayParam) {
        this.birthday = birthdayParam;
    }
}
