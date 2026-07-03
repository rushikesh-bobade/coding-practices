class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int sum=nums[0];
        if(nums.length==1){
            return nums[0];
        }

        for(int i=1;i<nums.length;i++){
            maxSum=Math.max(sum,maxSum);
            sum=sum+nums[i];
            if(sum<0){
                sum=0;
            }
        }
        
    return maxSum;
    }
}