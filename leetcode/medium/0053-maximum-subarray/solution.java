class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MAX_VALUE;
        int sum=nums[0];

        for(int i=1;i<nums.length;i++){
            sum=sum+nums[i];
            maxSum=Math.max(sum,maxSum);
            if(sum<0){
                sum=0;
            }
        }
        
    return maxSum;
    }
}