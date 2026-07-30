class Solution {
    public int maxSubArray(int[] nums) {

        //Approach 2
        int maxSum=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(nums[i],sum+nums[i]);
            maxSum=Math.max(sum,maxSum);
        }


        //approach 1
        // int maxSum=Integer.MIN_VALUE;
        // int sum=0;

        // for(int i=0;i<nums.length;i++){
        //     sum=sum+nums[i];
        //     maxSum=Math.max(sum,maxSum);
        //     if(sum<0){
        //         sum=0;
        //     }
        // }
        
    return maxSum;
    }
}