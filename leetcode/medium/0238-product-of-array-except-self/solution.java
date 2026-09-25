class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];


        ans[0]=1;
        for (int i = 1; i < n ; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

       int sufix = 1;
        for (int i = n - 2; i >= 0; i--) {
            sufix *= nums[i+1];
            ans[i]*=sufix;
        }

        return ans;


        // int[] prefix = new int[n];
        // int[] sufix = new int[n];

        // prefix[0] = 1;
        // for (int i = 1; i < n ; i++) {
        //     prefix[i] = prefix[i - 1] * nums[i - 1];
        // }

        // sufix[n - 1] = 1;
        // for (int i = n - 2; i >= 0; i--) {
        //     sufix[i] = sufix[i + 1] * nums[i + 1];
        // }

        // for (int i = 0; i < n; i++) {
        //     ans[i] = prefix[i] * sufix[i];
        // }

        // return ans;

        //Brute force approach
        // for(int i=0;i<n;i++){
        //    int prod=1;
        //     for(int j=0;j<n;j++){
        //        if(i!=j){
        //         prod*=nums[j];
        //        }
        //     }
        //     ans[i]=prod;
        // }
        // return ans;
    }
}