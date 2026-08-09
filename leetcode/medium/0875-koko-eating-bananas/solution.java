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
