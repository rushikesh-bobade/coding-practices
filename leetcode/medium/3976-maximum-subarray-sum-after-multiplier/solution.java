class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long base = nums[0];
        long ans = nums[0];

        // best gain if we apply operation in current subarray
        long mulGain = (long)nums[0] * (k - 1);
        long divGain = (long)(nums[0] / k - nums[0]);

        long mulBest = nums[0] + mulGain;
        long divBest = nums[0] + divGain;

        for (int i = 1; i < nums.length; i++) {

            long x = nums[i];

            base = Math.max(x, base + x);

            long gainMul = x * (k - 1);
            long gainDiv = (x / k) - x;

            mulGain = Math.max(gainMul, mulGain + gainMul);
            divGain = Math.max(gainDiv, divGain + gainDiv);

            mulBest = Math.max(mulBest, base + mulGain);
            divBest = Math.max(divBest, base + divGain);

            ans = Math.max(ans, Math.max(base, Math.max(mulBest, divBest)));
        }

        return ans;
    }
}