package tdd.covid;

import java.util.Set;

public class SymptomPointEvaluator implements PointEvaluator {

    @Override
    public int evaluate(Person person) {
        int points = 0;
        Set<Symptom> symptoms = person.getSymptoms();
        if(symptoms.contains(Symptom.DRY_COUGH)) points += 2;
        if(symptoms.contains(Symptom.FEVER)) points += 3;
        if(symptoms.contains(Symptom.FATIGUE)) points += 1;
        return points;
    }
}
