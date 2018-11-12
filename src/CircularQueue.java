public class CircularQueue {
    int[] items;
    int capacity;
    int head = 0;
    int tail = 0;

    public CircularQueue(int capacity) {
        items = new int[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(int item) {
        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

    public int dequeue() {
        if (head == tail) {
            return Integer.MAX_VALUE;
        }
        int value = items[head];
        head = (head + 1)%capacity;
        return value;
    }
}