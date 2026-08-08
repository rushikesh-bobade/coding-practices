class Solution {
    public int largestRectangleArea(int[] heights) {
    int n=heights.length;
    int maxArea=0;

    Deque<Integer>stack=new ArrayDeque<>();

    for(int i=0;i<=n;i++){
        int currHt=(i==heights.length)?0:heights[i];

        while(!stack.isEmpty() && currHt < heights[stack.peek()]){
            int height=heights[stack.pop()];
            int pse=stack.isEmpty()?-1:stack.peek();
            int width=i-pse-1;;
            maxArea=Math.max(maxArea, height*width);
        }
        stack.push(i);

    }
    return maxArea;
   }
}
