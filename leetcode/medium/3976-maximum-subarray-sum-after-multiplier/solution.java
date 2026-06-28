class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long normal = nums[0];

        long mul = nums[0] * k;
        long div = nums[0] / k;

        long best = Math.max(normal, Math.max(mul, div));

        for (int i = 1; i < nums.length; i++) {

            long x = nums[i];

            long newNormal = Math.max(x, normal + x);

            long newMul = Math.max(
                x * k,
                Math.max(normal + x * k, mul + x * k)
            );

            long newDiv = Math.max(
                x / k,
                Math.max(normal + x / k, div + x / k)
            );

            normal = newNormal;
            mul = newMul;
            div = newDiv;

            best = Math.max(best, Math.max(normal, Math.max(mul, div)));
        }

        return best;
    }
}