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

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-09T13:02:20.589Z  

```js
/**
 * @param {number[]} arr
 * @returns {number}
 */

class Solution {
    inversionCount(arr) {
        return this.mergeSort(arr, 0, arr.length - 1);
    }

    mergeSort(arr, left, right) {
        let count = 0;

        if (left < right) {
            const mid = Math.floor((left + right) / 2);

            count += this.mergeSort(arr, left, mid);
            count += this.mergeSort(arr, mid + 1, right);
            count += this.merge(arr, left, mid, right);
        }

        return count;
    }

    merge(arr, left, mid, right) {
        const temp = [];
        let i = left;
        let j = mid + 1;
        let inv = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp.push(arr[i++]);
            } else {
                temp.push(arr[j++]);
                inv += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp.push(arr[i++]);
        }

        while (j <= right) {
            temp.push(arr[j++]);
        }

        for (let k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }

        return inv;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1)