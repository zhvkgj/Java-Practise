package Collections;

import java.util.Objects;

public class Pair<T, U> {
    T firstValue;
    U secondValue;

    private Pair(T firstValue, U secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public static <T, U> Pair<T, U> of(T firstValue, U secondValue) {
        return new Pair<>(firstValue, secondValue);
    }

    public T getFirst() {
        return firstValue;
    }

    public U getSecond() {
        return secondValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Pair)) {
            return false;
        } else {
            Pair<?, ?> other = (Pair) obj;
            return Objects.equals(this.getFirst(), other.getFirst()) &&
                    Objects.equals(this.getSecond(), other.getSecond());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getFirst());
    }
}
