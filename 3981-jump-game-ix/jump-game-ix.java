class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int curMax = nums[i];
            int curMin = nums[i];
            int start = i;

            while (!stack.isEmpty() && stack.peek()[0] > curMin) {
                int[] top = stack.pop();
                curMax = Math.max(curMax, top[0]);
                curMin = Math.min(curMin, top[1]);
                start = top[2]; // extend range leftward
            }

            stack.push(new int[]{curMax, curMin, start, i});
        }

        for (int[] comp : stack) {
            int compMax = comp[0];
            int from    = comp[2];
            int to      = comp[3];
            for (int i = from; i <= to; i++) {
                ans[i] = compMax;
            }
        }

        return ans;
    }
}