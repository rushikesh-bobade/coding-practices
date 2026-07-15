class Solution {
    public int[][] merge(int[][] intervals) {
//More optimal

    List<int[]>list=new ArrayList<>();

    Arrays.sort(intervals,Comparator.comparingInt(o->o[0]));

    int row=0;
    int start=intervals[0][0];
    int lastend=intervals[0][1];

    for(int i=1;i<intervals.length;i++){
        if(intervals[i][0]<=lastend){
            lastend=Math.max(lastend,intervals[i][1]);
        }else{
            list.add(new int []{start,lastend});
            start=intervals[i][0];
            lastend=intervals[i][1];
        }
    }

    list.add(new int[]{start,lastend});

return list.toArray(new int[0][]);





            // less optimal
    //     Arrays.sort(intervals,Comparator.comparingDouble(o->o[0]));

    //     int ans[][]=new int[intervals.length][2];
    //     int row=0;

    //     int start=intervals[0][0];
    //     int lastend=intervals[0][1];

    //     for(int i=1;i<intervals.length;i++){

    //         if(intervals[i][0]<=lastend){
    //             lastend=Math.max(lastend,intervals[i][1]);
    //         }else{ 
    //             ans[row][0]=start;
    //             ans[row][1]=lastend;
    //             row++;

    //             start=intervals[i][0];
    //             lastend=intervals[i][1];
    //         }

    //     }

    // // Save the last interval
    //     ans[row][0]=start;
    //     ans[row][1]=lastend;
    //     row++;
        

    // return Arrays.copyOf(ans, row);
    }
}