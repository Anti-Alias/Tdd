package tdd.covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CovidManagerTest {

    CovidManager manager;
    Person harry;
    Person larry;
    Person marry;
    Person jerry;
    Person dairy;

    @BeforeEach
    void setup () {
        manager = new CovidManager(new RiskPointEvaluator(), new SymptomPointEvaluator());
        harry = new Person("Harry", "Lastnamington", LocalDate.parse("1970-01-01"), Collections.emptySet(), Collections.emptySet());
        larry = new Person("Larry", "Lastnamington", LocalDate.parse("1950-01-01"), Set.of(Condition.DIABETES), Collections.emptySet());
        marry = new Person("Marry", "Lastnamington", LocalDate.parse("1990-01-01"), Collections.emptySet(), Set.of(Symptom.FATIGUE, Symptom.DRY_COUGH));
        jerry = new Person("Jerry", "Lastnamington", LocalDate.parse("1950-01-01"), Set.of(Condition.HEART_DISEASE), Set.of(Symptom.FATIGUE, Symptom.DRY_COUGH));
        dairy = new Person("Dairy", "Lastnamington", LocalDate.parse("1990-01-01"), Set.of(Condition.DIABETES, Condition.HEART_DISEASE), Set.of(Symptom.FEVER, Symptom.DRY_COUGH));
    }


    @Test
    void testEvaluate() {
        assertEquals(new CovidEvaluation(false, false), manager.evaluate(harry));
        assertEquals(new CovidEvaluation(false, true), manager.evaluate(larry));
        assertEquals(new CovidEvaluation(false, false), manager.evaluate(marry));
        assertEquals(new CovidEvaluation(false, true), manager.evaluate(jerry));
        assertEquals(new CovidEvaluation(true, true), manager.evaluate(dairy));
    }
}