class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }


        //Approach 1 : TC=O(N log n),SC=O(N)
        // char [] sArr=s.toCharArray();
        // char [] tArr=t.toCharArray();

        // Arrays.sort(sArr); //O(n log n)
        // Arrays.sort(tArr); 

        // // for(int i=0;i<s.length();i++){
        // //     if(sArr[i]!=tArr[i]){
        // //         return false;
        // //     }
        // // }
        // // return true;
        // return Arrays.equals(sArr,tArr);

        //Approach 2 : TC=O(N); SC:O(1)
        char []arr=new char[26];

        for(int i=0;i<t.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}