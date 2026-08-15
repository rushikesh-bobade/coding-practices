import java.util.*;
import java.io.*;

class Solution {
  
    
    // int helper(int height[], int n, ArrayList<Integer>dp){
    //     if(n==0) return 0;
    //     if(dp.get(n)!=-1){
    //         return dp.get(n);
    //     }
    //     int left=helper(height,n-1,dp)+Math.abs(height[n]-height[n-1]);
        
    //     int right=Integer.MAX_VALUE;
    //     if(n>1){
    //     right=helper(height,n-2,dp)+Math.abs(height[n]-height[n-2]);
    //     }
    
    //     dp.set(n,Math.min(left,right));
    //     return dp.get(n);
        
    // }
    
    // int minCost(int[] height) {
    // // code here
    // int n=height.length;
    // ArrayList<Integer>dp=new ArrayList<>(Collections.nCopies(n,-1));
    // return helper(height,n-1,dp);
    // }
    
    int minCost(int[] height) {
    // code here
    int n=height.length;
    ArrayList<Integer>dp=new ArrayList<>(Collections.nCopies(n,-1));
    dp.set(0,0);
    
    for(int i=1;i<n;i++){
        
        
    int left=dp.get(i-1) + Math.abs(height[i]-height[i-1]);
    int right=Integer.MAX_VALUE;
        
        if(i>1){
            right=dp.get(i-2) + Math.abs(height[i]-height[i-2]);
        }
        
    dp.set(i,Math.min(left,right));
    }
    
    return dp.get(n-1);
    }
}