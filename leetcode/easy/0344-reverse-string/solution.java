class Solution {
    public void reverseString(char[] s) {


        int l=0;
        int r=s.length-1;

        while(l<r){
            char temp=s[l];
            s[l]=s[r];
            s[r]=temp;

            l++;
            r--;
        }

        // for(int i=0;i<s.length/2;i++){
        //     char a=s[i];
        //     s[i]=s[s.length-1-i];
        //     s[s.length-1-i]=a;
        // }


        // int j=s.length-1;
        // for(int i=0;i<s.length/2;i++){
        //     char a=s[i];
        //     s[i]=s[j];
        //     s[j]=a;
        //     j--;
        //}
    }
}