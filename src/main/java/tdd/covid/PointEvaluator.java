package tdd.covid;

@FunctionalInterface
/**
 * Evaluates "points" of a Person.
 */
public interface PointEvaluator {
    public int evaluate(Person person);
}
