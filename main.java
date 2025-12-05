import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // Create an LRU instance to test
        List<Integer> pages = Arrays.asList(1, 2, 3, 4);
        LRU lru = new LRU(3, pages);
    }
}
