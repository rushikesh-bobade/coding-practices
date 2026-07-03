class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int sum=nums[0];
        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

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