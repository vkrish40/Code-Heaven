import java.util.*;
public class HelloWorld{
    
    static List<List<Integer>> list;
    static int[][] dl;
    static boolean[] visited;
    static int num=1;
    
    public static void graph(int size)
    {
        for(int i=0;i<size;i++)
            list.add(new ArrayList<>());
    }
    
    public static void addEdge(int i, int j)
    {
        List<Integer> temp=list.get(i);
        temp.add(j);
        temp=list.get(j);
        temp.add(i);
        
    }
    
    public static void bridgecheck(int val,int current)
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
    
    public static void bridge(int current)
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
                    System.out.print(current + " " + val);
                    System.out.println();
                }
                
            }
            
        }
    }
    
     public static void main(String []args){
        //int[][] roads={{1,0},{0,2},{2,1},{0,3},{3,4},{4,5}};
        
        int[][] roads={{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}};
        
        //Number of vertices are 1 to 9 (total 9)
        list=new ArrayList<>();
        
        graph(10);
        
        for(int i=0;i<10;i++)
        {
            addEdge(roads[i][0],roads[i][1]);
        }
        
        dl = new int[10][2];
        visited = new boolean[10];
        
        int first=roads[0][0];
        dl[first][0]=num;
        dl[first][1]=num;
        visited[first]=true;
        num++;
        bridge(roads[0][0]);
     }
}