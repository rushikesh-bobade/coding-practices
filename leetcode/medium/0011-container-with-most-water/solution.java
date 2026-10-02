class Solution {
    public int maxArea(int[] height) {
        int most=0;
        int left=0,right=height.length-1;

       while(left<right){
        int h=Math.min(height[left],height[right]);
        int w= right-left;
        int area=h*w;
        most=Math.max(area,most);

        if(height[left]<height[right]){
            left++;
        }else{
            right --;
        }
       }





        //Brute force approach
        // for(int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        //         int heightt = Math.min(height[i],height[j]);
        //         int width=j-i;
        //         int count=heightt*width;
        //         most=Math.max(count,most);
        //     }
            
        // }
        return most;
    }
}