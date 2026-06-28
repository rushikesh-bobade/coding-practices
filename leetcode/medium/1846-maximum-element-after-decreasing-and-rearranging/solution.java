class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {




        //Approach 1: Greedy approach O(N log N) and space complexity is O(1)
        // Arrays.sort(arr);

        // arr[0]=1;
        // for(int i=1;i<arr.length;i++){
        //     //arr[i]=Math.min(arr[i],arr[i-1]+1);
        //     //or
        //     if(arr[i]>arr[i-1]+1){
        //     arr[i]=arr[i-1]+1;
        //     }
        // }

        // return arr[arr.length-1];



        //APPRAOCH 2 : T.C. O(n) but S.C. is O(N)

        int count[]=new int[arr.length+1];
        count[0]=1;
        for(int i=1;i<arr.length;i++){
            count[Math.min(arr[i],arr.length)]++;
        }

        int ans = 0;

        for (int i = 1; i <= arr.length; i++) {
            ans = Math.min(ans + count[i], i);
        }

        return ans;

    }
}