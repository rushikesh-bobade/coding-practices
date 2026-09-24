class Solution {
    public int smallestIndex(int[] nums) {
        int minAns=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int sum=0;
            while(num!=0){
                sum+=num % 10;
                num=num/10;
                
            }
            if(sum==i){
            minAns=Math.min(minAns,i);
            }
        }
        if(minAns>nums.length){
            return -1;
        }

        return minAns;
    }
}