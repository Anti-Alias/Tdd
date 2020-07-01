package tdd.covid;

@FunctionalInterface
/**
 * Evaluates "points" of a Person.
 */
public interface PointEvaluator {
    int evaluate(Person person);
}
