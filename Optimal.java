import java.util.*;

public class Optimal {
    private int frames;
    private List<Integer> referenceString;

    public Optimal(int frames, List<Integer> referenceString) {
        this.frames = frames;
        this.referenceString = referenceString;
    }

    public void run() {
        System.out.println("\n=== Optimal Page Replacement ===");
        System.out.println("Number of frames: " + frames);
        System.out.println("Reference String: " + referenceString);
        System.out.println();

        List<Integer> memory = new ArrayList<>();
        int pageFaults = 0;

        for (int i = 0; i < referenceString.size(); i++) {
            int page = referenceString.get(i);
            boolean isFault = false;

            // Check if page is already in memory
            if (memory.contains(page)) {
                // Page hit - no fault
            } else {
                // Page fault
                pageFaults++;
                isFault = true;

                if (memory.size() < frames) {
                    // Memory not full - simply add the page
                    memory.add(page);
                } else {
                    // Memory full - find optimal page to replace
                    int pageToReplace = findOptimalPage(memory, i);
                    int index = memory.indexOf(pageToReplace);
                    memory.set(index, page);
                }
            }

            // Print current state
            System.out.print("Page " + page + ": ");
            printFrames(memory);
            System.out.println(isFault ? " - Page Fault" : " - No Fault");
        }

        System.out.println("\nTotal Page Faults: " + pageFaults);
    }

    private int findOptimalPage(List<Integer> memory, int currentIndex) {
        // Find the page that will be used farthest in the future
        int farthest = currentIndex;
        int pageToReplace = -1;

        for (int page : memory) {
            // Find when this page will be used next
            int nextUse = findNextUse(page, currentIndex + 1);

            if (nextUse == -1) {
                // Page will never be used again - replace this one
                return page;
            }

            if (nextUse > farthest) {
                farthest = nextUse;
                pageToReplace = page;
            }
        }

        // If all pages will be used again, replace the one used farthest in future
        return pageToReplace != -1 ? pageToReplace : memory.get(0);
    }

    private int findNextUse(int page, int startIndex) {
        // Find the next occurrence of 'page' starting from startIndex
        for (int i = startIndex; i < referenceString.size(); i++) {
            if (referenceString.get(i) == page) {
                return i;
            }
        }
        return -1; // Page will not be used again
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
