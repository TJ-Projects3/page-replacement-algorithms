import java.util.*;

public class LRU {

    private int frames;
    private List<Integer> referenceString;


    public LRU(int frames, List<Integer> referenceString) {
        this.frames = frames;
        this.referenceString = referenceString;
        System.out.println("Hiyaa!!");
    }

    public void run() {
        /*
        LRU Algorithm Pseudocode:

        1. Create list for frames in memory.
        2. Use a map to track when each page was last used.
        3. For each page in the referenceString:
            a. If page is in frames -> no page fault -> update timestamp.
            b. Else page fault:
                - If memory not full, add the page.
                - Else:
                    - Find the page with the oldest last-used timestamp.
                    - Replace it with the new page.
            c. Print frame state + fault/no fault.
        4. Print total page faults.
        */
    }
}
