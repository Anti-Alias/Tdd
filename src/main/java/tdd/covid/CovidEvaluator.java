package tdd.covid;

/**
 * Performans an covid19 evalution of a person.
 *  */
public class CovidEvaluator {

    private PointEvaluator riskPointEvaluator;
    private PointEvaluator symptomPointEvaluator;

    public CovidEvaluator(PointEvaluator riskPointEvaluator, PointEvaluator symptomPointEvaluator) {
        this.riskPointEvaluator = riskPointEvaluator;
        this.symptomPointEvaluator = symptomPointEvaluator;
    }

    public CovidEvaluation evaluate(Person person) {

        // Calculates points
        int symptomPoints = symptomPointEvaluator.evaluate(person);
        int riskPoints = riskPointEvaluator.evaluate(person);

        // Determines if a person should be isolated and tested
        boolean shouldBeIsolated = false;
        if (riskPoints >= 5) shouldBeIsolated = true;
        else if (riskPoints + symptomPoints >= 8) shouldBeIsolated = true;

        // Done
        return new CovidEvaluation(symptomPoints >= 5, shouldBeIsolated);
    }
}