package domain;

/**
 * @author sadowsm3 on 17.06.2018
 */
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Integer born;
    private Float salary;

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{" +
                "id: \" " + id + "\"" +
                ", firstName:\"" + firstName + '\"' +
                ", lastName:\"" + lastName + '\"' +
                ", born:\"" + born + "\"" +
                ", salary:\"" + salary + "\"" +
                '}';
    }
}
