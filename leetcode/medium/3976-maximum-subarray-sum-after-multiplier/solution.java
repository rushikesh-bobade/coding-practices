class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long base = nums[0];
        long ans = nums[0];

        long gainMul = (long) nums[0] * (k - 1);
        long gainDiv = (long) (nums[0] / k - nums[0]);

        long bestMul = base + gainMul;
        long bestDiv = base + gainDiv;

        for (int i = 1; i < nums.length; i++) {

            long x = nums[i];

            base = Math.max(x, base + x);

            long gMul = x * (k - 1);
            long gDiv = (x / k) - x;

            gainMul = Math.max(gMul, gainMul + gMul);
            gainDiv = Math.max(gDiv, gainDiv + gDiv);

            bestMul = Math.max(bestMul, base + gainMul);
            bestDiv = Math.max(bestDiv, base + gainDiv);

            ans = Math.max(ans, Math.max(base, Math.max(bestMul, bestDiv)));
        }

        return ans;
    }
}