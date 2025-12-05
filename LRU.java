import java.util.*;

public class LRU {

    private int frames;
    private List<Integer> referenceString;

    public LRU(int frames, List<Integer> referenceString) {
        this.frames = frames;
        this.referenceString = referenceString;
    }

    public void run() {
        System.out.println("\n=== LRU (Least Recently Used) Page Replacement ===");
        System.out.println("Number of frames: " + frames);
        System.out.println("Reference String: " + referenceString);
        System.out.println();

        List<Integer> memory = new ArrayList<>();
        Map<Integer, Integer> lastUsed = new HashMap<>();
        int pageFaults = 0;
        int time = 0;

        for (int page : referenceString) {
            time++;
            boolean isFault = false;

            // Check if page is already in memory
            if (memory.contains(page)) {
                // Page hit - no fault, just update last used time
                lastUsed.put(page, time);
            } else {
                // Page fault
                pageFaults++;
                isFault = true;

                if (memory.size() < frames) {
                    // Memory not full - simply add the page
                    memory.add(page);
                } else {
                    // Memory full - find LRU page and replace it
                    int lruPage = memory.get(0);
                    int lruTime = lastUsed.get(lruPage);

                    for (int p : memory) {
                        if (lastUsed.get(p) < lruTime) {
                            lruPage = p;
                            lruTime = lastUsed.get(p);
                        }
                    }

                    // Replace LRU page with new page
                    int index = memory.indexOf(lruPage);
                    memory.set(index, page);
                }

                // Update last used time for the new page
                lastUsed.put(page, time);
            }

            // Print current state
            System.out.print("Page " + page + ": ");
            printFrames(memory);
            System.out.println(isFault ? " - Page Fault" : " - No Fault");
        }

        System.out.println("\nTotal Page Faults: " + pageFaults);
    }

    private void printFrames(List<Integer> memory) {
        System.out.print("[");
        for (int i = 0; i < memory.size(); i++) {
            System.out.print(memory.get(i));
            if (i < memory.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
