class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum=0;
        int count=0;

        HashMap<Integer,Integer>mpp=new HashMap<>();
        mpp.put(0,1);

        for(int num:nums){
            prefixSum+=num;
            if(mpp.containsKey(prefixSum-k)){
                count+=mpp.get(prefixSum-k);
            }
        mpp.put(prefixSum,mpp.getOrDefault(prefixSum,0)+1);
        }


        return count;
    }
}