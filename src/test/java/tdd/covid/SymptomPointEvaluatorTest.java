package tdd.covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SymptomPointEvaluatorTest {

    private SymptomPointEvaluator evaluator;
    private Person joe;
    private Person mary;
    private Person jerry;

    @BeforeEach
    public void setup() {
        evaluator = new SymptomPointEvaluator();
        joe = new Person("Joe", "Schmoe", LocalDate.parse("1970-01-01"), Collections.emptySet(), Set.of(Symptom.DRY_COUGH, Symptom.FATIGUE));
        mary = new Person("Mary", "Dairy", LocalDate.parse("1980-01-01"), Collections.emptySet(), Set.of(Symptom.FEVER));
        jerry = new Person("Mary", "Dairy", LocalDate.parse("1980-01-01"), Collections.emptySet(), Collections.emptySet());
    }

    @Test
    public void testEvaluate() {
        assertEquals(3, evaluator.evaluate(joe));
        assertEquals(3, evaluator.evaluate(mary));
        assertEquals(0, evaluator.evaluate(jerry));
    }
}