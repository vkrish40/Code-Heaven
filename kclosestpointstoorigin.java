class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        Queue<Double> queue=new PriorityQueue<>();
                 
        double cal=0;
        int temp=K;
        int flag=0;
        int arr[][] = new int[K][2];
        for(int i=0;i<points.length;i++)
        {
            cal=Math.sqrt(Math.pow(points[i][0],2) + Math.pow(points[i][1],2));
            queue.offer(cal);       
        }
        
        while(K>1)
        {
            queue.poll();
            K--;
        }
        
        double check=queue.poll();
        
        for(int i=0;i<points.length;i++)
        {
            if(flag>=temp)
                break;
            cal=Math.sqrt(Math.pow(points[i][0],2) + Math.pow(points[i][1],2));
            if(cal<=check)
            {
                arr[flag][0]=points[i][0];
                arr[flag][1]=points[i][1];
                flag++;            
            }
        }
        return arr;
    }
}