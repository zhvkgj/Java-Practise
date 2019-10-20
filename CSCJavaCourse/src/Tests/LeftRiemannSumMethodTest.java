package Tests;

import static ObjectsAndClasses.LeftRiemannSumMethod.*;

public class LeftRiemannSumMethodTest {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 100));
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate(x -> Math.sin(x) / x, 1, 5));//0.603848
        System.out.println(integrate(x -> x, -458, 100)); // -50597.9526
    }
}
