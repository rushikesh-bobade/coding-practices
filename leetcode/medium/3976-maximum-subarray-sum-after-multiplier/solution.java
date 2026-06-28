class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long noOp = nums[0];

        long mul = nums[0] * k;
        long div = nums[0] / k;

        long ans = Math.max(noOp, Math.max(mul, div));

        for (int i = 1; i < nums.length; i++) {

            long x = nums[i];

            long newNoOp = Math.max(x, noOp + x);

            long newMul = Math.max(
                x * k,
                Math.max(noOp + x * k, mul + x * k)
            );

            long newDiv = Math.max(
                x / k,
                Math.max(noOp + x / k, div + x / k)
            );

            noOp = newNoOp;
            mul = newMul;
            div = newDiv;

            ans = Math.max(ans, Math.max(noOp, Math.max(mul, div)));
        }

        return ans;
    }
}