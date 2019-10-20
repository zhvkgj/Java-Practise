package Tests;

import static ErrorHandling.ExceptionsHandler.*;

public class ExceptionsHandlerTest {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
        m1();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    private static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    private static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    private static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }
}