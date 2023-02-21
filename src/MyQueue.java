/*
Написать свой класс MyQueue как аналог классу Queue, который будет
работать по принципу FIFO (first-in-first-out).

Можно делать либо с помощью Node либо с помощью массива.

Методы

add(Object value) добавляет элемент в конец
clear() очищает коллекцию
size() возвращает размер коллекции
peek() возвращает первый элемент в очереди (FIFO)
poll() возвращает первый элемент в очереди и удаляет его из коллекции
 */

import java.util.Objects;


public class MyQueue<T> {

    private Node<T> first;
    private Node<T> last;

    private int size;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last = newNode;
        }
        size++;
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
        Objects.checkIndex(0, size);
        return first.element;
    }

    public T poll() {

        Node<T> polledElement = first;
        first = first.next;
        size--;
        return polledElement.element;
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

class MyQueueTest {
    public static void main(String[] args) {

        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(2);
        myQueue.add(12);
        myQueue.add(24);
        myQueue.add(235);
        System.out.println("myQueue = " + myQueue);
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue = " + myQueue);

        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue = " + myQueue);


    }
}
