package tdd.covid;

import java.util.Objects;

/**
 * Represents the evaluation of a Person.
 */
public class CovidEvaluation {
    private boolean shouldBeTested;
    private boolean shouldBeIsolated;

    public CovidEvaluation(boolean shouldBeTested, boolean shouldBeIsolated) {
        this.shouldBeTested = shouldBeTested;
        this.shouldBeIsolated = shouldBeIsolated;
    }

    public boolean shouldBeTested() {
        return shouldBeTested;
    }

    public boolean shouldBeIsolated() {
        return shouldBeIsolated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CovidEvaluation that = (CovidEvaluation) o;
        return shouldBeTested == that.shouldBeTested &&
                shouldBeIsolated == that.shouldBeIsolated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shouldBeTested, shouldBeIsolated);
    }

    @Override
    public String toString() {
        return "CovidEvaluation{" +
                "shouldBeTested=" + shouldBeTested +
                ", shouldBeIsolated=" + shouldBeIsolated +
                '}';
    }
}
