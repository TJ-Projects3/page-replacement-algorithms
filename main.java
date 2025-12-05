import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("   PAGE REPLACEMENT ALGORITHM SIMULATION PROJECT");
        System.out.println("   Project 8 by Joseph and Joshua");
        System.out.println("======================================================");

        // Test reference string with 30 pages (exceeds minimum of 20)
        List<Integer> referenceString = Arrays.asList(
            7, 0, 1, 2, 0, 3, 0, 4, 2, 3,
            0, 3, 2, 1, 2, 0, 1, 7, 0, 1,
            2, 3, 4, 5, 6, 7, 0, 1, 2, 3
        );

        // Number of frames available in memory
        int numFrames = 4;

        System.out.println("\nSimulation Parameters:");
        System.out.println("----------------------");
        System.out.println("Total Pages in Reference String: " + referenceString.size());
        System.out.println("Number of Frames: " + numFrames);
        System.out.println("Reference String: " + referenceString);

        // Run LRU Algorithm
        System.out.println("\n\n");
        LRU lru = new LRU(numFrames, referenceString);
        lru.run();

        // Run Optimal Algorithm
        System.out.println("\n\n");
        Optimal optimal = new Optimal(numFrames, referenceString);
        optimal.run();

        // Summary comparison
        System.out.println("\n\n======================================================");
        System.out.println("                    SUMMARY");
        System.out.println("======================================================");
        System.out.println("Both algorithms have been executed successfully.");
        System.out.println("Compare the page fault counts above to analyze");
        System.out.println("the performance of each algorithm.");
        System.out.println("======================================================");
    }
}
