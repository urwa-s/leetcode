import java.util.*;

class Solution {
    public int minimumEffort(int[][] tasks) {
        // Sort by (minimum - actual) descending
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int initial = 0;
        int current = 0;

        for (int[] task : tasks) {
            int actual  = task[0];
            int minimum = task[1];

            if (current < minimum) {
                // Top up just enough to start this task
                initial += minimum - current;
                current  = minimum;
            }

            current -= actual; // spend energy
        }

        return initial;
    }
}