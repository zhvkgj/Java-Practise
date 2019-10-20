package ObjectsAndClasses;

import java.util.function.DoubleUnaryOperator;

public class LeftRiemannSumMethod {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-7;
        double result = 0;
        int count = (int) Math.round((b - a) / step);
        for (int i = 0; i < count; i++) {
            result += f.applyAsDouble(a + i * step);
        }
        return step * result;
    }
}
