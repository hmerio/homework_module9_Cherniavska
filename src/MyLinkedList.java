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

    public void remove(int index) {
        Objects.checkIndex(index, size);

        if (index == 0) {
            first = first.next;
        } else if (index == size - 1) {
            last = last.prev;
        } else {
            Node<T> next = first;
            for (int i = 0; i < index + 1; i++) {
                next = next.next;
            }
            next.prev = next.prev.prev;
            Node<T> prev = first;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;


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

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
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

class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Hello");
        myLinkedList.add("Hello1");
        myLinkedList.add("Hello2");
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        myLinkedList.remove(2);
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());


    }
}
