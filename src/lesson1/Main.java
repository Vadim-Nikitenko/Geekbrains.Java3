package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Задание №1
        Integer[] intArr = {1,2};
        String[] strArr = {"AAA", "BBB"};
        replaceArray(intArr,0,1);
        System.out.println(Arrays.toString(intArr));
        replaceArray(strArr,0,1);
        System.out.println(Arrays.toString(strArr));


        //Задание №2
        Integer[] intArray = {1,2,3,4,5};
        System.out.println(arrayToArrayList(intArray).toString());
        System.out.println(intArray);

        //Задание №3
        //фрукты
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        ArrayList<Apple> apples = new ArrayList<>(Arrays.asList(apple1, apple2));

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        ArrayList<Orange> oranges = new ArrayList<>(Arrays.asList(orange1, orange2));

        //коробки
        Box<Apple> applesBox = new Box<>();
        applesBox.addFruits(apples);

        Box<Orange> orangesBox = new Box<>();
        orangesBox.addFruits(oranges);

        Box<Fruit> fruitsBox = new Box<>();

        //сравнение веса коробок яблок и апельсинов - false (2!=3)
        System.out.println(applesBox.compare(orangesBox));

        //сравнение веса коробок яблок и апельсинов после добавления 1 яблока - true (3==3)
        applesBox.addFruit(apple3);
        System.out.println(applesBox.compare(orangesBox));

        //сравнение веса коробки апельсинов и коробки fruitsBox после перемещения туда яблок - true (3==3)
        applesBox.replaceFruits(fruitsBox);
        System.out.println(orangesBox.compare(fruitsBox));

    }

    public static void replaceArray(Object[] arr, int firstIndex, int secondIndex) {
        Object temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }

}
