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

        int n = arr.length;
        int[] count = new int[n + 1];

        for (int x : arr) {
            count[Math.min(x, n)]++;
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans + count[i], i);
        }

        return ans;

    }
}