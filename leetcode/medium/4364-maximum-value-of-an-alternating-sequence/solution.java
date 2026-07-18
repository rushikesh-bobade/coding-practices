class Solution {
    public long maximumValue(int n, int s, int m) {
        long mavlorenti = s;

        long ans = s;

        long peaksAfterStart = n / 2;
        if (peaksAfterStart > 0) {
            ans = Math.max(ans,
                    (long) s + m + (peaksAfterStart - 1L) * (m - 1L));
        }

        long futurePeaks = (n - 1L) / 2;
        ans = Math.max(ans,
                (long) s + futurePeaks * (m - 1L));

        return ans;
    }
}