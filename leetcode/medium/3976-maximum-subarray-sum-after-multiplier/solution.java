class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long base = nums[0];                 // best subarray ending here, unmodified
        long mul  = (long) nums[0] * k;       // best subarray ending here, exactly one *k applied
        long div  = nums[0] / k;              // best subarray ending here, exactly one /k applied

        long ans = Math.max(mul, div);

        for (int i = 1; i < nums.length; i++) {
            long x = nums[i];

            long newMul  = Math.max(x * (long) k, Math.max(base + x * (long) k, mul + x));
            long newDiv  = Math.max(x / k,        Math.max(base + x / k,        div + x));
            long newBase = Math.max(x, base + x);

            mul  = newMul;
            div  = newDiv;
            base = newBase;

            ans = Math.max(ans, Math.max(mul, div));
        }

        return ans;
    }
}