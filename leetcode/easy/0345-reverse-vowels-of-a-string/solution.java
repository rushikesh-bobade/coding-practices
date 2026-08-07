class Solution {
    public String reverseVowels(String s) {
        HashSet<Character>set=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        char ch[]=s.toCharArray();
        int l=0;
        int r=s.length()-1;

        while(l<r){
            while(l<r && !set.contains(ch[l])){
                l++;
            }

            while(l<r && !set.contains(ch[r])){
                r--;
            }

            char temp=ch[l];
            ch[l]=ch[r];
            ch[r]=temp;

            l++;
            r--;
        }

        return new String(ch);
    }
}