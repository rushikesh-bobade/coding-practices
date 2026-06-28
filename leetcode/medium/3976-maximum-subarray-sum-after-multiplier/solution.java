class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        final long NEG = Long.MIN_VALUE / 4; // safe sentinel, won't overflow on +x

        long base = nums[0];
        long runMul = (long) nums[0] * k;
        long doneMul = NEG;
        long runDiv = nums[0] / k;     // Java truncation = floor(+), ceil(-) — matches spec
        long doneDiv = NEG;

        long ans = Math.max(runMul, runDiv);

        for (int i = 1; i < nums.length; i++) {
            long x = nums[i];
            long xMul = x * (long) k;
            long xDiv = x / k;

            long newBase    = Math.max(x, base + x);
            long newRunMul  = Math.max(xMul, Math.max(runMul + xMul, base + xMul));
            long newDoneMul = Math.max(runMul + x, doneMul + x);
            long newRunDiv  = Math.max(xDiv, Math.max(runDiv + xDiv, base + xDiv));
            long newDoneDiv = Math.max(runDiv + x, doneDiv + x);

            base = newBase;
            runMul = newRunMul;
            doneMul = newDoneMul;
            runDiv = newRunDiv;
            doneDiv = newDoneDiv;

            ans = Math.max(ans, Math.max(Math.max(runMul, doneMul), Math.max(runDiv, doneDiv)));
        }

        return ans;
    }
}