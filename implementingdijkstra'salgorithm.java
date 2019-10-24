/******************************************************************************

                            Implementing Dijkstra's Algorithm

*******************************************************************************/
import java.util.*;

public class Main
{
    Map<Character,List<Character>> graph = new HashMap<>();
    Map<String,Integer> cost = new HashMap<>(); 
    Map<Character,Integer> least_cost = new HashMap<>();
    Map<Character,Character> previous_vertex = new HashMap<>();
    Map<Integer,Queue<Character>> least_track = new HashMap<>();
    Queue<Integer> p_queue = new PriorityQueue<>();
    Set<Character> visited = new HashSet<>();
    
    public void run(Character node)
    {
       List<Character> list = graph.get(node);
       int least_val = Integer.MAX_VALUE;
       char ret='.';
       for(int i=0;i<list.size();i++)
       {
           char ch = list.get(i);
           if(!visited.contains(ch))
           {
               int val = least_cost.get(node);
               String str = ""+node+ch;
               val+=cost.get(str);
               if(val<least_cost.get(ch))
               {
                   least_cost.put(ch,val);
                   previous_vertex.put(ch,node);
                   p_queue.offer(val);
                   if(least_track.containsKey(val))
                   {
                       Queue<Character> queue = least_track.get(val);
                       queue.offer(ch);
                   }
                   else
                   {
                       Queue<Character> queue = new ArrayDeque<>();
                       queue.offer(ch);
                       least_track.put(val, queue);
                   }
               }
        
           }
       }
    }
    
        public void build_map(char[][] edges, int[] price)
        {
            least_cost.put('a',0);                  //Because our source node is 'a'    
            for(int i=0;i<edges.length;i++)
    		{
    		    if(!graph.containsKey(edges[i][0]))
    		    {
    		        List<Character> list = new ArrayList<>();
    		        list.add(edges[i][1]);
    		        graph.put(edges[i][0],list);
    		    }
    		    else
    		    {
    		        List<Character> list = graph.get(edges[i][0]);
    		        list.add(edges[i][1]);
    		    }
    		    if(!graph.containsKey(edges[i][1]))
    		    {
    		        List<Character> list = new ArrayList<>();
    		        list.add(edges[i][0]);
    		        graph.put(edges[i][1],list);
    		    }
    		    else
    		    {
    		        List<Character> list = graph.get(edges[i][1]);
    		        list.add(edges[i][0]);
    		    }
    		    String comb1 = ""+edges[i][0]+edges[i][1];
    		    String comb2 = ""+edges[i][1]+edges[i][0];
    		    
    		    if(!cost.containsKey(comb1))
    		        cost.put(comb1,price[i]);
    		    if(!cost.containsKey(comb2))
    		        cost.put(comb2,price[i]);
    		    if(edges[i][0]!='a' && !least_cost.containsKey(edges[i][0]))
    		        least_cost.put(edges[i][0], Integer.MAX_VALUE);
    		    if(edges[i][1]!='a' && !least_cost.containsKey(edges[i][1]))
    		        least_cost.put(edges[i][1], Integer.MAX_VALUE);
    		}
    		Queue<Character> queue = new ArrayDeque<>();
    		queue.offer('a');
    		least_track.put(0,queue);
    		p_queue.offer(0);
    		while(!p_queue.isEmpty())
    		{
    		    int pop = p_queue.poll(); 
    		    Queue<Character> next_char = least_track.get(pop);
    		    char next = next_char.poll();
    		    while(!next_char.isEmpty() && visited.contains(next))
    		    {
    		        next = next_char.poll();
    		    }
    		    if(!visited.contains(next))
    		    {
    		        visited.add(next);
    		        run(next);
    		    }
    		    if(next_char.size()!=0)
    		        p_queue.offer(pop);
    		    else
    		        least_track.remove(pop);
    		}
        }
    
    public void start(char[][]edges, int[] price)
    {
        build_map(edges, price);
        
        Set<Map.Entry<Character, Integer>> set = least_cost.entrySet();
        Iterator<Map.Entry<Character, Integer>> itr = set.iterator();
        while(itr.hasNext())
        {
            Map.Entry<Character, Integer> me = itr.next();
            System.out.print("\nCHARACTER: " + me.getKey() + "\tLEAST COST from a: " + me.getValue());
        }
        Set<Map.Entry<Character, Character>> previous_set = previous_vertex.entrySet();
        Iterator<Map.Entry<Character, Character>> previous_itr = previous_set.iterator();
        while(previous_itr.hasNext())
        {
            Map.Entry<Character, Character> me = previous_itr.next();
            System.out.print("\nCHARACTER: " + me.getKey() + "\tPREVIOUS VERTEX: " + me.getValue());
        }
    }

    
	public static void main(String[] args) {
		
		char[][] edges = {{'a','b'},{'a','d'},{'b','d'},{'d','e'},{'b','e'},{'b','c'},{'e','c'}};
		
		int[] price = {6,1,2,1,2,5,5};
		
		Main obj = new Main();
		
		obj.start(edges, price);
		
	}
}
