class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long max = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long count=0;
        for(int i=0;i<nums.length;i++){
            long a=nums[i]*k;
            count+=nums[i];
            if(count<0) count=0;
            max=Math.max(count,max);
            
            long b=nums[i]/k;
            max2=Math.max(count,max2);
        }

        return Math.max(max,max2);
    }
}