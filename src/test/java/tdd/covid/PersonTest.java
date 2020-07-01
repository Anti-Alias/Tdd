package tdd.covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person joe;
    private Person mary;
    private Person oldMan;
    private Person oldWoman;

    @BeforeEach
    public void setup() {
        joe = new Person("Joe", "Schmoe", LocalDate.parse("1970-01-01"), Collections.emptySet(), Collections.emptySet());
        mary = new Person("Mary", "Dairy", LocalDate.parse("1980-01-01"), Collections.emptySet(), Collections.emptySet());
        oldMan = new Person("Old", "Man", LocalDate.parse("1950-01-01"), Set.of(Condition.DIABETES), Collections.emptySet());
        oldWoman = new Person("Old", "Woman", LocalDate.parse("1950-03-01"), Collections.emptySet(), Set.of(Symptom.DRY_COUGH));
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Joe", joe.getFirstName());
        assertEquals("Mary", mary.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Schmoe", joe.getLastName());
        assertEquals("Dairy", mary.getLastName());
    }

    @Test
    public void testGetDOB() {
        assertEquals(LocalDate.parse("1970-01-01"), joe.getDOB());
        assertEquals(LocalDate.parse("1980-01-01"), mary.getDOB());
    }

    @Test
    public void testGetConditions() {
        assertEquals(Collections.emptySet(), joe.getConditions());
        assertEquals(Set.of(Condition.DIABETES), oldMan.getConditions());
    }

    @Test
    public void testGetSymptoms() {
        assertEquals(Collections.emptySet(), joe.getSymptoms());
        assertEquals(Set.of(Symptom.DRY_COUGH), oldWoman.getSymptoms());
    }
}