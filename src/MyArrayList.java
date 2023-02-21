/*
Написать свой класс MyArrayList как аналог классу ArrayList.

Можно использовать 1 массив для хранения данных.

Методы

add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
get(int index) возвращает элемент под индексом
 */

import java.util.Objects;

public class MyArrayList<T> {


    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.elements = new Object[initialCapacity];
        }
    }

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }


    private void resize() {
        if (elements.length == size) {
            Object[] newArray = new Object[size * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    public void add(Object value) {
        resize();
        elements[size] = value;
        size++;
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index);
        size--;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }

    public void clear() {
        size = 0;
        elements = new Object[0];
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        for (Object obj : elements) {
            if (obj == null) continue;

            sb.append(obj);
            sb.append(", ");
        }
        if (sb.length() >= 2) sb = new StringBuilder(sb.substring(0, sb.length() - 2));

        sb.append("]");

        return sb.toString();

    }
}

class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(9);
        myArrayList.add(4);

        System.out.println(myArrayList);

        System.out.println("myArrayList.remove(1) = " + myArrayList.remove(1));

        System.out.println(myArrayList);

        System.out.println("myArrayList.size() = " + myArrayList.size());

        System.out.println("myArrayList.get(0) = " + myArrayList.get(0));

        myArrayList.clear();

        System.out.println("myArrayList = " + myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());


    }
}
