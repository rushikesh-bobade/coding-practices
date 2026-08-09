# Koko Eating Bananas

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Koko loves to eat bananas. There are `n` piles of bananas, the `ith` pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours.

Koko can decide her bananas-per-hour eating speed of `k`. Each hour, she chooses some pile of bananas and eats `k` bananas from that pile. If the pile has less than `k` bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return  *the minimum integer*  `k`  *such that she can eat all the bananas within*  `h`  *hours*.

 

 **Example 1:** 

```
Input: piles = [3,6,7,11], h = 8
Output: 4

```

 **Example 2:** 

```
Input: piles = [30,11,23,4,20], h = 5
Output: 30

```

 **Example 3:** 

```
Input: piles = [30,11,23,4,20], h = 6
Output: 23

```

 

 **Constraints:** 

- 1 <= piles.length <= 104
- piles.length <= h <= 109
- 1 <= piles[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 82.01%)  
**Memory:** 47.7 MB (beats 88.35%)  
**Submitted:** 2026-08-09T20:25:27.154Z  

```java
class Solution{
    public int minEatingSpeed(int[] piles,int h){
    int l=1;
    int r=piles[0];
    for(int i=1;i<piles.length;i++){
        r=Math.max(r , piles[i]);
    }

    while(l<r){
        int mid=l+(r-l)/2;
        int hr=0;
        for(int i=0;i<piles.length;i++){
            hr+=(piles[i]+mid-1)/mid;// or  here mid is we considering as no.of bananas
        }
        if(hr<=h){
            r=mid;
        }else{
            l=mid+1;
        }
    }
     
    return l;
    }
}





// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int left = 1;
//         int right = 0;
//         for (int pile : piles) right = Math.max(right, pile);

//         // Time Complexity: O(n log m)
//         while (left < right) {
//             int mid = left + (right - left) / 2;
//             if (canEatAll(piles, h, mid)) right = mid;
//             else left = mid + 1;
//         }

//         return left;
//     }

//     private boolean canEatAll(int[] piles, int h, int speed) {
//         int hours = 0;
//         for (int pile : piles) {
//             hours += (pile + speed - 1) / speed;
//             if (hours > h) return false;
//         }
//         return true;
//     }
// }

```

---

[View on LeetCode](https://leetcode.com/problems/koko-eating-bananas/)