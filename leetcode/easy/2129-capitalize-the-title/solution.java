class Solution {
    public String capitalizeTitle(String title) {

        String[] words = title.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) sb.append(" ");

            if (words[i].length() <= 2) {
                sb.append(words[i]);
            } else {
                sb.append(Character.toUpperCase(words[i].charAt(0)));
                sb.append(words[i].substring(1));
            }
        }

        return sb.toString();
    

        // String s[]=title.trim().split("\\s+");
        // StringBuilder sb=new StringBuilder();

        // for(int i=0;i<s.length;i++){
        //     boolean j=true;

        //     for(char c : s[i].toCharArray()){
        //         if(s[i].length()==1){
        //             sb.append(Character.toLowerCase(c));
        //         }else if(s[i].length()==2){
        //             sb.append(Character.toLowerCase(c));
        //         }else{
        //             if(j){
        //                 sb.append(Character.toUpperCase(c));
        //             }else{
        //                 sb.append(Character.toLowerCase(c));
        //             }
        //             j=false;
        //         }
        //    }

        //    sb.append(" ");
        // }

        // return sb.toString().trim();
    }
}