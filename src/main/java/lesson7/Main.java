package lesson7;

import java.lang.reflect.InvocationTargetException;

public class Main {
    static Class c = Tests.class;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestManager testManager = new TestManager();
        testManager.start(c);
    }
}
