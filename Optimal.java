public class Optimal {
    /*
    Optimal Page Replacement Algorithm Pseudocode:

    1. Create list to hold frames.
    2. For each page in the referenceString:
            - If page is already in frames -> no fault.
        - Else (page fault):
            a. If there is space -> add page.
            b. Else:
                - For each page currently in frames:
                    - Look ahead in the referenceString to see when it will be used next.
                    - Record the distance to next use.
                - The page with the farthest next use OR not used again is replaced.
    3. Print frames after each reference.
    4. Print total faults.
    */
    public void run() {
        /* Nothing here yet */
    }
}
