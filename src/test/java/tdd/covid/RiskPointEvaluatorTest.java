package tdd.covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RiskPointEvaluatorTest {

    private RiskPointEvaluator evaluator;
    private Person joe;
    private Person mary;
    private Person jerry;

    @BeforeEach
    public void setup() {
        evaluator = new RiskPointEvaluator();
        joe = new Person("Joe", "Schmoe", LocalDate.parse("1970-01-01"), Set.of(), Set.of());
        mary = new Person("Mary", "Dairy", LocalDate.parse("1980-01-01"), Set.of(Condition.HEART_DISEASE), Set.of());
        jerry = new Person("Jerry", "Hairy", LocalDate.parse("1950-01-01"), Set.of(Condition.HEART_DISEASE, Condition.DIABETES), Set.of());
    }

    @Test
    public void testEvaluate() {
        int joeRiskPoints = evaluator.evaluate(joe);
        int maryRiskPoints = evaluator.evaluate(mary);
        int jerryRiskPoints = evaluator.evaluate(jerry);
        assertEquals(0, joeRiskPoints);
        assertEquals(3, maryRiskPoints);
        assertEquals(8, jerryRiskPoints);
    }
}