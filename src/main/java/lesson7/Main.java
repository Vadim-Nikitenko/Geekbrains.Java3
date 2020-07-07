package lesson7;

import java.lang.reflect.InvocationTargetException;

import static lesson7.TestManager.*;

public class Main {
    static Class c = Tests.class;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(c);
    }
}
