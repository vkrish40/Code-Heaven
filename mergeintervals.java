class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length==0)
            return new int[0][0];
        if(intervals==null)
            return null;
        if(intervals.length==1)
            return intervals;
        
        Queue<Integer> queue=new LinkedList<>();
        
        Arrays.sort(intervals, (arr1, arr2)->arr1[0]-arr2[0]);
        
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<=intervals[i-1][1])
            {
                if(intervals[i][1]<intervals[i-1][1])
                {
                    intervals[i][1]=intervals[i-1][1];
                }
                intervals[i][0]=intervals[i][0]<intervals[i-1][0]?intervals[i][0]:intervals[i-1][0];
            }
            else
            {
                queue.offer(i-1);
            }
            if(i==intervals.length-1)
                queue.offer(i);
        }
        
        int[][] ans=new int[queue.size()][2];
        int count=0;
        
        while(!queue.isEmpty())
        {
            int index=queue.poll();
            ans[count][0]=intervals[index][0];
            ans[count][1]=intervals[index][1];
            count++;            
        }
        
        return ans;
        
    }
}