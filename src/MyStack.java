/*
Написать свой класс MyStack как аналог классу Stack,
который работает по принципу LIFO (last-in-first-out).

Можно делать либо с помощью Node либо с помощью массива.


Методы

push(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
peek() возвращает первый элемент в стеке (LIFO)
pop() возвращает первый элемент в стеке и удаляет его из коллекции
 */

import java.util.Objects;
import java.util.Stack;

public class MyStack<T> {
    private Node<T> first;
    private Node<T> last;

    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);

        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Node<T> current = first;
        Node<T> nextNode = null;
        T el = null;

        int step = 0;
        while (current != null) {
            if (index == step) {
                if (current == first) {
                    el = current.element;
                    current = current.next;
                    first = current;
                } else {
                    nextNode.next = current.next;
                    el = current.element;
                }
            }
            nextNode = current;
            current = current.next;
            step++;
        }
        size--;

    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        Objects.checkIndex(size - 1, size);
        return last.element;
    }

    public T pop() {
        Node<T> poppedElement = first;
        for (int i = 0; i < size - 1; i++) {
            poppedElement = poppedElement.next;
        }
        last = last.prev;
        size--;
        return poppedElement.element;
    }

    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        public Node(T element) {
            this.element = element;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current == null)
                continue;
            sb.append(current.element);
            sb.append(", ");
            current = current.next;
        }
        if (sb.length() >= 2)
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));

        sb.append("]");

        return sb.toString();
    }
}

class MyStackTest {
    public static void main(String[] args) {

        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(12);
        myStack.push(12);
        myStack.push(12);
        myStack.push(12);
        myStack.push(12);
        myStack.push(12);
        myStack.push(12);
        myStack.push(12);
        myStack.push(12);
        myStack.push(12);

        System.out.println("myStack = " + myStack);
        System.out.println("myStack.size() = " + myStack.size());

        for (int i = 0; i < 10; i++) {
            myStack.remove(i);
        }

        System.out.println("myStack = " + myStack);
        System.out.println("myStack.size() = " + myStack.size());

    }
}
