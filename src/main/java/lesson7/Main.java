package lesson7;

import java.lang.reflect.InvocationTargetException;

import static lesson7.TestManager.*;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(Tests.class);
    }
}
