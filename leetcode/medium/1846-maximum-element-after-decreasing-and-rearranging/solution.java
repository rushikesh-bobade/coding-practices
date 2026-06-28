class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int min=1;
        arr[0]=1;
        for(int i=1;i<arr.length;i++){
            min=Math.min(arr[i],arr[i-1]+1);

        }

        return min;
    }
}