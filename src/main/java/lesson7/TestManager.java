package lesson7;

import lesson7.annotations.AfterSuite;
import lesson7.annotations.BeforeSuite;
import lesson7.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TestManager {

    public static void start(Class c) throws InvocationTargetException, IllegalAccessException {

        //создаем лист из декларированных методов и переменные для методов @Before и @After, счетчики
        ArrayList<Method> methodList = new ArrayList<>(Arrays.asList(c.getDeclaredMethods()));
//        if (methodList.size())
        if (methodList.size() == 0) {
            throw new RuntimeException("В тестовом классе нет ни одного тестового метода");
        }

        Method before = null;
        Method after = null;
        int beforeCount = 0;
        int afterCount = 0;

        //проходимся циклом по методам, присваиваем методу before метод с аннотацией @BeforeSuite. Аналогично @AfterSuite.
        for (Method method : methodList) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeCount++;
                if (beforeCount > 1) {
                    throw new RuntimeException("В тестовом классе больше одного метода с аннотацией @BeforeSuite");
                }
                before = method;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterCount++;
                if (afterCount > 1) {
                    throw new RuntimeException("В тестовом классе больше одного метода с аннотацией @AfterSuite");
                }
                after = method;
            }
        }

        //удаляем из листа методы @BeforeSuite и @AfterSuite
        methodList.remove(before);
        methodList.remove(after);

        //соритруем методы с аннотацией @Test по полю priority
        methodList.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));

        //вызываем метод с аннотацией @BeforeSuite в самом начале если он есть
        if (before != null) {
            before.invoke(null);
        }

        //вызываем методы из списка согласно их очередности
        for (Method method : methodList) {
            if (method.isAnnotationPresent(Test.class)) {
                method.invoke(null);
            }
        }

        //вызываем метод  с аннотацией @AfterSuite в самом конце если он есть
        if (after != null) {
            after.invoke(null);
        }
    }
}