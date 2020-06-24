package soft.train.spring.rest;

public class Person {
    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(final String nameParam) {
        name = nameParam;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surnameParam) {
        surname = surnameParam;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int ageParam) {
        age = ageParam;
    }
}
