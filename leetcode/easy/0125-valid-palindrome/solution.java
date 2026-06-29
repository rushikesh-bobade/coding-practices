class Solution {
    public boolean isPalindrome(String s) {
        
        int l=0;
        int r=s.length()-1;

        while(l<r){

            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }

            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }

        return true;


        //Brute force approach using String Builder
        // StringBuilder str=new StringBuilder();
        // for(char c:s.toCharArray()){
        //     if(Character.isLetterOrDigit(c)){
        //         str.append(Character.toLowerCase(c));
        //     }
        // }

        // String str1=str.toString();
        // String str2=str.reverse().toString();

        // return str1.equals(str2);
    }
}