import java.io.*;
import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int count=0;

        double[][] cars=new double [n][2];

        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=(double)(target-position[i])/speed[i]; // c1:2, c2:1, c3:12, c4:7, c5:3
        }

        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));
        //Arrays.sort(cars,Comparator.comparingDouble((double a[])->a[0]).reversed());// c1:1, c2:1, c4:7, c5:3, c3:12 that mean how much position they are closure in time to target

        Stack<Double>st=new Stack<>();

        double prev=0;
      
        for(int i=0;i<n;i++){
           if(st.isEmpty()||cars[i][1]>prev){
                st.push(cars[i][1]);
                prev=cars[i][1];
           }
        }

        return st.size();

    }
}