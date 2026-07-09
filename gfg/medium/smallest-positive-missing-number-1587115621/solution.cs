class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.Length;

        // Place each positive number x at index x-1
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Find the first index where value is incorrect
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }
}