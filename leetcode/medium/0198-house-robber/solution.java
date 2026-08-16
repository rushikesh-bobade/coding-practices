//Maximum sum of non-adjacent elements

class Solution {
    public int rob(int[] nums) {
        // int prev2 = 0;
        // int prev1 = 0;
        // for (int n : nums) {
        //     int curr = Math.max(prev1, prev2 + n);
        //     prev2 = prev1;
        //     prev1 = curr;
        // }
        // return prev1;

        int n=nums.length;
        ArrayList<Integer>dp=new ArrayList<>(Collections.nCopies(n,-1));
        return f(n-1,nums,dp);
    }

    public int f(int idx, int[] nums, ArrayList<Integer> dp) {
        if (idx == 0)
            return nums[0];
        if (idx < 0)
            return 0;

        if (dp.get(idx) != -1) {
            return dp.get(idx);
        }
        int pick = nums[idx] + f(idx - 2, nums, dp);
        int notPick = 0 + f(idx - 1, nums, dp);

        dp.set(idx, Math.max(pick, notPick));
        return dp.get(idx);
    }
}
