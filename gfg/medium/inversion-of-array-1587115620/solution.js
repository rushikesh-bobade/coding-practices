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