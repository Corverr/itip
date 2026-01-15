public class Stack<T> {
    private Object[] data;
    private int size;

    public Stack(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new StackOverflowError("Стек переполнен");
        }
        data[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        T element = (T) data[--size];
        data[size] = null;
        return element;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        return (T) data[size - 1];
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Извлеченный элемент: " + stack.pop());
        System.out.println("Верхний элемент после pop: " + stack.peek());
    }
}