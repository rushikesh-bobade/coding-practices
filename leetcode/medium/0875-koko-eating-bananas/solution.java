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