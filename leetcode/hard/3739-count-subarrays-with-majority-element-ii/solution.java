import java.util.*;

class Solution {

    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        // Prefix sums
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        // Coordinate Compression
        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> compress = new HashMap<>();

        int id = 1;
        for (int x : sorted) {
            if (!compress.containsKey(x)) {
                compress.put(x, id++);
            }
        }

        Fenwick bit = new Fenwick(id + 2);

        long ans = 0;

        for (int x : prefix) {

            int idx = compress.get(x);

            // Count previous prefix sums smaller than current
            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return ans;
    }
}