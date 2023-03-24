public class MyStackExtendsList<T> extends MyLinkedList<T> {

    @Override
    public void clear() {
        super.clear();
    }

    public void push(T value) {
        super.add(value);
    }

    @Override
    public T remove(int index) {
        return super.remove(index);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public T get(int index) {
        return super.get(index);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //    peek() повертає перший елемент стеку
    public T peek() {
        return super.get(0);
    }

    public T poll() {
        T element = super.get(0);
        remove(0);
        return element;
    }
}