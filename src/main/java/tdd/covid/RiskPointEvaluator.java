package tdd.covid;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public class RiskPointEvaluator implements PointEvaluator {

    @Override
    public int evaluate(Person person) {
        return calcAgePoints(person) + calcConditionPoints(person);
    }

    private int calcAgePoints(Person person) {
        LocalDate dob = person.getDOB();
        LocalDate now = LocalDate.now();
        int age = Period.between(dob, now).getYears();
        if (age >= 54 && age <= 59) return 1;
        if (age >= 60 && age <= 69) return 2;
        if (age >= 70 && age <= 79) return 3;
        if (age >= 80) return 5;
        return 0;
    }

    private int calcConditionPoints(Person person) {
        int points = 0;
        Set<Condition> conditions = person.getConditions();
        if (conditions.contains(Condition.DIABETES)) points += 2;
        if (conditions.contains(Condition.HEART_DISEASE)) points += 3;
        return points;
    }
}
