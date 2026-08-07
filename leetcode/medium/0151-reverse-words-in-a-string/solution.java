class Solution {
    public String reverseWords(String s) {

        String ans[]=s.trim().split("\\s+");

        StringBuilder sb=new StringBuilder();

        for(int i=ans.length-1;i>=0;i--){
            sb.append(ans[i]);
            if(i!=0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}