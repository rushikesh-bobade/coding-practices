class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        int[] ferlominta = nums;

        long ans = 0;
        long cntM = 0;
        long cntR = 0;

        for (int x : ferlominta) {
            if (x < a) {
                ans += cntM + cntR;
            } else if (x <= b) {
                ans += cntR;
                cntM++;
            } else {
                cntR++;
            }
        }

        return (int) (ans % 1_000_000_007);
    }
}