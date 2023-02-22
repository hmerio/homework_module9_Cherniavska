/*

Написать свой класс MyHashMap как аналог классу HashMap.

Нужно делать с помощью односвязной Node.

Не может хранить две ноды с одинаковых ключами одновременно.


put(Object key, Object value) добавляет пару ключ + значение
remove(Object key) удаляет пару по ключу
clear() очищает коллекцию
size() возвращает размер коллекции
get(Object key) возвращает значение(Object value) по ключу
 */


public class MyHashMap<K, V> {
    private final Node<K, V>[] bucket;
    private int size;
    private final int CAPACITY = 16;

    private int index;


    public MyHashMap() {
        bucket = new Node[CAPACITY];
    }

    public void put(K key, V value) {

        if (size == CAPACITY) {
            resize();
        }

        index = (key.hashCode()) % CAPACITY;

        if (index == -1) index = key.hashCode() % size;


        Node<K, V> node = bucket[index];

        if (node == null) {
            bucket[index] = new Node<>(key, value);
        } else {
            while (node.next != null) {
                if (node.getKey() == key) {
                    node.setValue(value);
                    return;
                }
                node = node.next;
            }
            node.next = new Node<>(key, value);
        }

        size++;
    }

    private void resize() {

        Node<K, V>[] newNodes = new Node[size * 2];
        System.arraycopy(bucket, 0, newNodes, 0, size);
    }

    public V remove(K key) {
        index = key.hashCode() % CAPACITY;
        Node<K, V> element = bucket[index];

        if (element == null) {
            return null;
        }
        V removedElement = bucket[index].value;
        bucket[index] = null;

        size--;

        return removedElement;
    }

    public V get(K key) {
        index = (key.hashCode()) % CAPACITY;

        Node<K, V> element = bucket[index];

        if (element == null) {
            return null;
        }

        if (element.getKey() == key) {
            return element.value;
        }
        return element.value;
    }

    public int size() {
        return size;
    }

    public void clear() {

        Node<K, V>[] tab;
        if ((tab = bucket) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
        size = 0;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;


        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + "=" + value + ']';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        if (bucket == null) {
            return "{}";
        }
        for (int i = 0; i < CAPACITY; i++) {

            Node<K, V> current = bucket[i];
            if (current == null) {
                continue;
            } else {
                sb.append(current.getKey()).append("=").append(current.getValue()).append(", ");
            }
        }
        if (size > 0) {
            sb.deleteCharAt(sb.lastIndexOf(", "));
        }

        return "{" + sb.toString().trim() + "}";
    }
}

class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, Integer> jobSalary = new MyHashMap<>();
        jobSalary.put("Java", 3000);
        jobSalary.put("JS", 2000);
        jobSalary.put("Sales", 1500);
        jobSalary.put("5654", 4500000);
        jobSalary.put("5604", 4500000);
        jobSalary.put("5054", 4500000);
        jobSalary.put("56e4", 4500000);
        jobSalary.put("5ewr54", 4500000);
        jobSalary.put("5rff4", 4500000);
        jobSalary.put("56g4", 4500000);
        jobSalary.put("56b54", 4500000);
        jobSalary.put("56rge4", 4500000);
        jobSalary.put("5ted54", 4500000);
        jobSalary.put("5gdf54", 4500000);
        jobSalary.put("5vfd54", 4500000);
        jobSalary.put("56erf4", 4500000);
        jobSalary.put("5dfv4", 4500000);
        jobSalary.put("5cv4", 4500000);
        jobSalary.put("56wr44", 4500000);
        jobSalary.put("534te4", 4500000);
        System.out.println("jobSalary.size() = " + jobSalary.size());


//        System.out.println("jobSalary = " + jobSalary);
//        System.out.println("jobSalary.size() = " + jobSalary.size());
//        System.out.println("jobSalary.get(\"JS\") = " + jobSalary.get("JS"));
//        System.out.println("jobSalary.get(\"Java\") = " + jobSalary.get("Java"));
//
//        System.out.println("jobSalary.get(\"Sales\") = " + jobSalary.get("Sales"));
//
//        System.out.println("jobSalary.remove(\"JS\") = " + jobSalary.remove("JS"));
//        System.out.println("jobSalary.remove(\"Sales\") = " + jobSalary.remove("Sales"));
//        System.out.println("jobSalary = " + jobSalary);
//        System.out.println("jobSalary.size() = " + jobSalary.size());
//
//        jobSalary.clear();
//        System.out.println("jobSalary = " + jobSalary);
//        System.out.println("jobSalary.size() = " + jobSalary.size());


    }
}


