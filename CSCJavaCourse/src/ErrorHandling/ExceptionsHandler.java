package ErrorHandling;

public class ExceptionsHandler {
    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] elements = new Throwable().getStackTrace();
        if (elements.length < 3) {
            return null;
        }
        StackTraceElement curElem = elements[2];
        return curElem.getClassName() + "#" + curElem.getMethodName();
    }
}

