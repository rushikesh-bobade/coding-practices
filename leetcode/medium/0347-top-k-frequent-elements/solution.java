class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer>freqMpp=new HashMap<>();

        for(int num:nums){
            freqMpp.put(num,freqMpp.getOrDefault(num,0)+1);

        // if (freqMpp.containsKey(num)) {
        // freqMpp.put(num, freqMpp.get(num) + 1);
        // } else {
        //     freqMpp.put(num, 1);
        // }
        }

            PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> freqMpp.get(a) - freqMpp.get(b)
        );

        for (int num : freqMpp.keySet()) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;

        // HashMap <Integer,Integer> freqMpp=new HashMap<>();
        // List<Integer>[]bucket=new List[nums.length+1];
        
        // for(int num:nums){
        //     freqMpp.put(num,freqMpp.getOrDefault(num,0)+1);
        // }

        // for(int key:freqMpp.keySet()){
        //     int freq=freqMpp.get(key);
        //     if(bucket[freq]==null){
        //         bucket[freq]=new ArrayList<>();
        //     }

        //     bucket[freq].add(key);
        // }

        // int []ans=new int[k];
        // int counter=0;

        // for(int pos=nums.length;pos>0 && counter<k; pos--){
        //     if(bucket[pos]!=null){
        //         for(int n:bucket[pos]){
        //         ans[counter++]=n;
        //         if(counter==k) break;
        //         }   
        //     }
        // }
        // return ans;
    }
}