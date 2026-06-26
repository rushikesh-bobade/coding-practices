import java.util.*;
import java.util.*;

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
       ArrayList<Integer>ans=new ArrayList<>();
       HashSet<Integer>set=new HashSet<>();
       int min=Integer.MAX_VALUE;
       
       for(int i=0;i<arr.length;i++){
           if(set.contains(arr[i])){
               ans.add(arr[i]);
           }else{
               set.add(arr[i]);
           }
           
           if(arr[i]<min){
               min=arr[i];
           }
           
       }
       
       for(int i=0;i<arr.length-1;i++){
           
           if(!set.contains(1)){
               ans.add(1);
               return ans;
           }
           
           if(set.contains(min+1)){
              min++; 
           }else{
               ans.add(min+1);
               return ans;
           }
       }
       