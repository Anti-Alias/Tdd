package tdd.covid;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A POJO representing a person.
 */
public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Set<Condition> conditions;
    private Set<Symptom> symptoms;

    public Person(String firstName, String lastName, LocalDate dob, Set<Condition> conditions, Set<Symptom> symptoms) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.conditions = new HashSet<>(conditions);
        this.symptoms = new HashSet<>(symptoms);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDOB() {
        return dob;
    }

    public Set<Condition> getConditions() {
        return Collections.unmodifiableSet(conditions);
    }

    public Set<Symptom> getSymptoms() {
        return Collections.unmodifiableSet(symptoms);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", conditions=" + conditions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(dob, person.dob) &&
                Objects.equals(conditions, person.conditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dob, conditions);
    }
}
