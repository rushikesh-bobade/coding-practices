class Solution {
    public String capitalizeTitle(String title) {
        
        String s[]=title.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length;i++){
            boolean j=true;

            for(char c : s[i].toCharArray()){
                if(s[i].length()==1){
                    sb.append(Character.toLowerCase(c));
                }else if(s[i].length()==2){
                    sb.append(Character.toLowerCase(c));
                }else{
                    if(j){
                        sb.append(Character.toUpperCase(c));
                    }else{
                        sb.append(Character.toLowerCase(c));
                    }
                    j=false;
                }
           }

           sb.append(" ");
        }

        return sb.toString().trim();
    }
}