import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {

        Map<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (freq.containsKey(1L)) {
            int count = freq.get(1L);
            ans = Math.max(ans, (count % 2 == 0) ? count - 1 : count);
        }

        for (long start : freq.keySet()) {

            if (start == 1L) continue;

            long curr = start;
            int len = 0;

            while (true) {

                int count = freq.getOrDefault(curr, 0);

                if (count < 2) {
                    if (count == 1) {
                        len++;
                    } else if (len > 0) {
                        len--;
                    }
                    break;
                }

                // We have at least two copies
                len += 2;

                // Prevent overflow
                if (curr > (long) Math.sqrt(Long.MAX_VALUE)) {
                    len--;
                    break;
                }

                long next = curr * curr;

                // Can't continue the chain
                if (!freq.containsKey(next)) {
                    len--;
                    break;
                }

                curr = next;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}