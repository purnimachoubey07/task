import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;

public class DSA32 {

    static int capacity = 3;

    static HashMap<Integer, Integer> map = new HashMap<>();
    static Deque<Integer> deque = new ArrayDeque<>();

    static void put(int key, int value) {

        // If key already exists
        if (map.containsKey(key)) {
            deque.remove(key);
        }

        // Add key at the front
        deque.addFirst(key);
        map.put(key, value);

        // If cache becomes full
        if (deque.size() > capacity) {

            int lastKey = deque.removeLast();

            map.remove(lastKey);
        }
    }

    static int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        // Make this key recently used
        deque.remove(key);
        deque.addFirst(key);

        return map.get(key);
    }

    static void display() {

        System.out.println("LRU Cache:");

        for (int key : deque) {
            System.out.println(key + " = " + map.get(key));
        }
    }

    public static void main(String[] args) {

        put(1, 100);
        put(2, 200);
        put(3, 300);

        display();

        System.out.println("Get 1: " + get(1));

        put(4, 400);

        display();
    }
}