package tdd.covid;

import org.junit.jupiter.api.Test;

class CovidEvaluationTest {

    @Test
    void testShouldBeTested() {
        CovidEvaluation eval1 = new CovidEvaluation(true, true);
        CovidEvaluation eval2 = new CovidEvaluation(false, true);
        assert(eval1.shouldBeTested());
        assert(!eval2.shouldBeTested());
    }

    @Test
    void shouldBeIsolated() {
        CovidEvaluation eval1 = new CovidEvaluation(true, true);
        CovidEvaluation eval2 = new CovidEvaluation(true, false);
        assert(eval1.shouldBeIsolated());
        assert(!eval2.shouldBeIsolated());
    }
}