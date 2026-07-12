class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            ans.add(generateRow(i));
        }

        return ans;
    }

    public List<Integer> generateRow(int n){
        List<Integer>temp=new ArrayList<>();
        long res=1;
        
        temp.add(1);
        for(int i=1;i<n;i++){
            res=res*(n-i);
            res=res/i;
            temp.add((int)res);
        }
        return temp;
    }
}