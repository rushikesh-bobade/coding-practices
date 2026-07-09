# Count Inversions

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers  **arr[]**. You have to find the  **Inversion Count**  of the array. 
 **Note :**  Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

 **Examples:** 

```
Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
```

```
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
```

```
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
```

 **Constraints:** 
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-09T13:01:53.451Z  

```java
class Solution {
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }

        return count;
    }

    static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        int inv = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return inv;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1)