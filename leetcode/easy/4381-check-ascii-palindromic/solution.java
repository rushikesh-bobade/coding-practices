class Solution {
    public boolean isPalindromic(String s) {
        int n=s.length();
        int l=0;

        int totBit=n*8;
        int r=totBit-1;

        while(l<r){
            if(bitGet(s,l)!=bitGet(s,r)){
                return false;
            }

            l++;
            r--;
        }
        return true;
    }

    public int bitGet(String s,int idx){
        int charIdx=idx/8;
        int posBit=7-(idx %8);
        int asciVal=s.charAt(charIdx);

        return (asciVal>>posBit) &1;
    }
}