/*
Написать свой класс MyLinkedList как аналог классу LinkedList.

Нельзя использовать массив.
Каждый элемент должен быть отдельным объектом-посредником(Node - нода)
который хранит ссылку на предыдущий и следующий элемент коллекции
(двусвязный список).

Методы

add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
get(int index) возвращает элемент под индексом
 */


import java.util.LinkedList;
import java.util.Objects;

class MyLinkedList<T> {

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

    public T remove(int index) {
        Node<T> currentNode = findNode(index);
        if (index == 0) {
            first = currentNode.next;
            first.prev = null;
        } else if (index == size) {
            last = currentNode.prev;
            last.next = null;
        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        this.size--;
        return currentNode.element;
    }

    private Node<T> findNode(int index) {
        Objects.checkIndex(index, size);
        Node<T> currentNode = first;
        int tmpIndex = 0;
        while (currentNode.next != null) {
            if (tmpIndex == index) {
                break;
            }
            currentNode = currentNode.next;
            tmpIndex++;
        }
        return currentNode;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    static class Node<T> {
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

class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 12 ; i++) {
            myLinkedList.add("Hello");
        }

        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        System.out.println("myLinkedList = " + myLinkedList);
        for (int i = 0; i < 12; i++) {
            myLinkedList.remove(i);
        }
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        System.out.println("myLinkedList = " + myLinkedList);


    }
}
