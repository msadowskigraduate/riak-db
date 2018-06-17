package domain;

import com.basho.riak.client.api.commands.kv.UpdateValue;

/**
 * @author sadowsm3 on 17.06.2018
 */
public class PersonUpdate extends UpdateValue.Update<Person> {

    private final String updateId;
    private final String updateFirstName;
    private final String updateLastName;
    private final Integer updateBorn;
    private final Float updateSalary;

    public PersonUpdate(String updateId, String updateFirstName, String updateLastName, Integer updateBorn, Float updateSalary) {
        this.updateId = updateId;
        this.updateFirstName = updateFirstName;
        this.updateLastName = updateLastName;
        this.updateBorn = updateBorn;
        this.updateSalary = updateSalary;
    }

    public Person apply(Person person) {
        if(person == null) {
            person = new Person();
        }

        if(this.updateId != null) {
            person.setId(updateId);
        }

        if(this.updateFirstName != null) {
            person.setFirstName(updateFirstName);
        }

        if(this.updateLastName != null) {
            person.setLastName(updateLastName);
        }

        if(this.updateBorn != null) {
            person.setBorn(updateBorn);
        }

        if(this.updateSalary != null) {
            person.setSalary(updateSalary);
        }

        return person;
    }
}
