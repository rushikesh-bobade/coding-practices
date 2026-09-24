class Solution {
    public int[] topKFrequent(int[] nums, int k) {

       HashMap<Integer,Integer>mpp=new HashMap<>();

       for(int num:nums){
        mpp.put(num,mpp.getOrDefault(num,0)+1);
       }

       PriorityQueue<Integer>pq=new PriorityQueue<>(
        (a,b)->mpp.get(a)-mpp.get(b)
       );

       for(int num:mpp.keySet()){
        pq.offer(num);
        if(pq.size()>k){
            pq.poll();
        }
       }

       int ans[]=new int[k];
       for(int i=0;i<k;i++){
        ans[i]=pq.poll();
       }

       return ans;
    }
}