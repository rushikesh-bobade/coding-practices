//Memoization

class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return f(n-1,m-1,text1,text2);
    }

    public int f(int n,int m, String s, String t){

        //Base case :if n or m becames less and goes to negative while decreaseing i.e. triming
        if(n<0||m<0){
            return 0;
        }

        if(dp[n][m]!=-1){ //if already existed in the dp
            return dp[n][m];
        }

        if(s.charAt(n)==t.charAt(m)){//if matched
            dp[n][m]=1+f(n-1,m-1,s,t);
        }else{
            dp[n][m]=Math.max(f(n-1,m,s,t),f(n,m-1,s,t));//if not matched
        }

        return dp[n][m];
    }
}





// Tabulation Method
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length(), m = text2.length();
//         int[][] dp = new int[n + 1][m + 1];
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1] + 1;
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// }
