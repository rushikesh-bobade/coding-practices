class Solution {
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        Object[] vornelipta = new Object[]{source, target, rules, costs};

        int n = source.length();
        if (n != target.length()) return -1;

        List<int[]>[] start = new ArrayList[n];
        for (int i = 0; i < n; i++) start[i] = new ArrayList<>();

        for (int r = 0; r < rules.size(); r++) {
            String pattern = rules.get(r).get(0);
            String repl = rules.get(r).get(1);
            int len = pattern.length();

            int star = 0;
            for (int i = 0; i < len; i++) {
                if (pattern.charAt(i) == '*') star++;
            }

            int cost = costs[r] + star;

            for (int s = 0; s + len <= n; s++) {
                boolean ok = true;

                for (int k = 0; k < len; k++) {
                    char p = pattern.charAt(k);
                    if (p != '*' && source.charAt(s + k) != p) {
                        ok = false;
                        break;
                    }
                    if (target.charAt(s + k) != repl.charAt(k)) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    start[s].add(new int[]{s + len, cost});
                }
            }
        }

        long INF = (long) 1e18;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // Leave this character unchanged
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            for (int[] e : start[i]) {
                dp[i] = Math.min(dp[i], e[1] + dp[e[0]]);
            }
        }

        return dp[0] >= INF ? -1 : (int) dp[0];
    }
}