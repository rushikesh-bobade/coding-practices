class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long dp0 = nums[0];

        long dp1Mul = nums[0] * k;
        long dp1Div = nums[0] / k;

        long dp2Mul = Long.MIN_VALUE / 4;
        long dp2Div = Long.MIN_VALUE / 4;

        long ans = Math.max(dp0, Math.max(dp1Mul, dp1Div));

        for (int i = 1; i < nums.length; i++) {

            long x = nums[i];

            long newDp0 = Math.max(x, dp0 + x);

            long newDp1Mul = Math.max(
                x * k,
                Math.max(dp0 + x * k, dp1Mul + x)
            );

            long newDp1Div = Math.max(
                x / k,
                Math.max(dp0 + x / k, dp1Div + x)
            );

            long newDp2Mul = Math.max(
                dp2Mul + x,
                dp1Mul + x
            );

            long newDp2Div = Math.max(
                dp2Div + x,
                dp1Div + x
            );

            dp0 = newDp0;
            dp1Mul = newDp1Mul;
            dp1Div = newDp1Div;
            dp2Mul = newDp2Mul;
            dp2Div = newDp2Div;

            ans = Math.max(ans,
                Math.max(dp0, Math.max(dp2Mul, dp2Div))
            );
        }

        return ans;
    }
}