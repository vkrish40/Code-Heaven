import java.util.*;

public class HelloWorld{
    
    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands)
    {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list;
        
        for(int i=0;i<commands.size();i++)
        {
            list=commands.get(i);
            int val=list.get(1);
            if(list.get(0)==0 && !map.containsKey(val))
            {
                map.put(val,list.get(2)+expiryLimit);
            }
            else if(list.get(0)==1 && map.containsKey(val) && map.get(val)>=list.get(2))
            {
                map.put(val,list.get(2)+expiryLimit);
            }
            else if(list.get(0)==1 && map.containsKey(val) && map.get(val)<list.get(2))
            {
                map.remove(val);
            }
        }
        
        int comp=commands.get(commands.size()-1).get(2);
        int count=0;
        
        for(int i : map.values())
        {
            if(i>=comp)
                count++;
        }
        
        return count;
        
    }

     public static void main(String []args){
         
         int expiryLimit = 4;
         
         List<List<Integer>> commands=new ArrayList<>();
         
         List<Integer> list1=new ArrayList<>();
         list1.add(0);
         list1.add(1);
         list1.add(1);
         
         List<Integer> list2=new ArrayList<>();
         list2.add(0);
         list2.add(2);
         list2.add(2);
         
         List<Integer> list3=new ArrayList<>();
         list3.add(1);
         list3.add(1);
         list3.add(5);
         
         List<Integer> list4=new ArrayList<>();
         list4.add(1);
         list4.add(2);
         list4.add(7);
         
         commands.add(list1);
         commands.add(list2);
         commands.add(list3);
         commands.add(list4);
         
         
        
        System.out.println("Number of active tokens: " + numberOfTokens(expiryLimit, commands));
     }
}