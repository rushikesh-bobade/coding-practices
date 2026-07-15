class Solution {
    public int gcdOfOddEvenSums(int n) {
        //more ooptimal
        int sumOdd=n*n;
        int sumEven=n*(n+1);


        //less optimal
        // int sumOdd=0;
        // int sumEven=0;
        // int na=2*n;
        // int i=1;
        // while(na>0){
        //     if(i%2!=0){
        //         sumOdd+=i;
        //     }else{
        //         sumEven+=i;
        //     }
        //     i++;
        //     na--;
        // }

        return gcd(sumOdd,sumEven);
    }

    public int gcd(int a,int b){
    
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}