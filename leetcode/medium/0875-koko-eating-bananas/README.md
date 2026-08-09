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
**Runtime:** 26 ms (beats 14.63%)  
**Memory:** 47.7 MB (beats 75.25%)  
**Submitted:** 2026-08-09T20:54:24.489Z  

```java
// class Solution{
//     public int minEatingSpeed(int[] piles,int h){
//     int l=1;
//     int r=piles[0];
    
//     for(int i=1;i<piles.length;i++){
//         r=Math.max(r , piles[i]);
//     }

//     while(l<r){
//         int mid=l+(r-l)/2;
//         int hr=0;
//         for(int i=0;i<piles.length;i++){
//             hr+=(piles[i]+mid-1)/mid;// or  here mid is we considering as no.of bananas
//         }

//         if(hr<=h){
//             r=mid;
//         }else{
//             l=mid+1;
//         }
//     }
     
//     return l;
//     }
// }


class Solution{
    public int minEatingSpeed(int []piles, int h){
        int left=0;
        int right=findMaxRange(piles);

        while(left<=right){

            int mid=left+(right-left)/2;

            if(bananaPerHour(piles,h,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public boolean bananaPerHour(int []piles, int h, int mid){
        int hour=0;
        for(int pile:piles){
            hour+=Math.ceil((double)pile/(double)mid);
        }
        if(hour>h){
            return false;
        }
        return true;
    }


    public int findMaxRange(int []piles){
        int ans=0;
        for(int pile:piles){
            ans=Math.max(ans,pile);
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/koko-eating-bananas/)