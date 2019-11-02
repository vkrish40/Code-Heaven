class Solution {
    /*Applying Tarjan's algorithm*/
    List<List<Integer>> list;
    List<List<Integer>> ans;
    int[][] dl;
    boolean[] visited;
    int num=1;
    public void graph(int size)
    {
        for(int i=0;i<size;i++)
            list.add(new ArrayList<>());
    }
    public void addEdge(int i, int j)
    {
        List<Integer> temp=list.get(i);
        temp.add(j);
        temp=list.get(j);
        temp.add(i);
        
    }
    public void bridgecheck(int val,int current)
    {
        List<Integer> elem=list.get(val);
        
        for(int i=0;i<elem.size();i++)
        {
            int temp=elem.get(i);
            if(temp!=current && dl[temp][0]<dl[val][1])
            {
                dl[val][1]=dl[temp][0];
            }
        }
    }
    
    public void bridge(int current)
    {
        List<Integer> temp=list.get(current);
        for(int i=0;i<temp.size();i++)
        {
            int val=temp.get(i);
            if(!visited[val])
            {
                visited[val]=true;
                dl[val][0]=num;
                dl[val][1]=num;
                num++;
                bridge(val);
                bridgecheck(val,current);
                if(dl[val][1]<dl[current][1])
                {
                    dl[current][1]=dl[val][1];
                }
                if(dl[val][1]>dl[current][0])
                {
                    ans.add(Arrays.asList(current,val));
                }
                
            }
            
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        list=new ArrayList<>();
        ans = new ArrayList<>();
        int len = connections.size();
        graph(len);
        for(int i=0;i<len;i++) 
        {
            addEdge(connections.get(i).get(0), connections.get(i).get(1));
        }
        dl = new int[len][2];
        visited = new boolean[len];
        
        int first=connections.get(0).get(0);
        dl[first][0]=num;
        dl[first][1]=num;
        visited[first]=true;
        num++;
        bridge(first);
        
        return ans;
        
    }
}