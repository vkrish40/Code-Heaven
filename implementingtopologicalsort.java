/******************************************************************************

                    Implementing Topological Sort 
"Given a Directed Acyclic Graph (DAG), Topological Sort is the ordering of vertices
of this grpah such that for every edge uv going from u to v, u should always appear
before v in the ordering."

*******************************************************************************/
import java.util.*;

public class Main
{
    Map<Character, List<Character>> graph = new HashMap<>();
    Set<Character> visited = new HashSet<>();
    Deque<Character> stack = new ArrayDeque<>();
    
    public void dfs(char ch)
    {
        List<Character> list = graph.get(ch);
        if(list==null)
        {
            stack.push(ch);
            return;
        }
        
        Iterator<Character> it = list.iterator();
        while(it.hasNext())
        {
            char temp = it.next(); 
            if(!visited.contains(temp))
            {
                visited.add(temp);
                dfs(temp);
            }
        }
        stack.push(ch);
    }
    
    
    public void build_graph(char[][] edges)
    {
        for(int i=0;i<edges.length;i++)
        {
            List<Character> list;
            if(graph.containsKey(edges[i][0]))
            {
                list = graph.get(edges[i][0]);
                list.add(edges[i][1]);
            }
            else
            {
                list = new ArrayList<>();
                list.add(edges[i][1]);
                graph.put(edges[i][0], list);
            }
        }
        
    }
    
    public void run(char[][] edges)
    {
        build_graph(edges);
        System.out.println(graph);
        Set<Character> keys = graph.keySet();
        Iterator<Character> itr = keys.iterator();
        while(itr.hasNext())
        {
            char ch = itr.next();
            if(!visited.contains(ch))
            {
                visited.add(ch);
                dfs(ch);
            }
        }
        
        System.out.println("TOPOLOGICAL SORT: ");
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }


	public static void main(String[] args)
	{
		char[][] edges = {{'A','C'},{'B','C'},{'B','D'},{'C','E'},{'E','F'},{'D','F'},{'F','G'}};
		
		Main obj = new Main();
		
		obj.run(edges);
	}
}
