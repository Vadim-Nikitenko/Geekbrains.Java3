package lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();
    private float weight;

    public boolean compare(Box<?> box) {
        return Math.abs(box.weight - weight) < 0.00000001;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
        weight += fruit.getWeight();
    }

    public void addFruits(ArrayList<? extends T> fruits) {
        for (T fruit : fruits) {
            this.fruits.add(fruit);
            weight += fruit.getWeight();
        }
    }

    public void clearBox(ArrayList<T> fruits) {
        fruits.clear();
        weight = 0;
    }

    void replaceFruits(Box<? super T> box) {
        if (box.equals(this)) return;
        box.addFruits(fruits);
        clearBox(getFruits());
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }
}