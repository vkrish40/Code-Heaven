class Solution {
    
    boolean[] visited;
    int count=0;
    
    public void permutations(int N, int pos)
    {
        if(pos>N)
            count++;
        for(int i=1;i<=N;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                if(i%pos==0 || pos%i==0)
                    permutations(N,pos+1);
                visited[i]=false;
            }
        }
    }
    
    public int countArrangement(int N) {
        
        visited=new boolean[N+1];
        permutations(N, 1);
        return count;
    }
}