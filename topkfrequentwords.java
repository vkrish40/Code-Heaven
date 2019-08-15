import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String,Integer> hm=new HashMap<>();
        
        for(int i=0;i<words.length;i++)
        {
            if(hm.containsKey(words[i]))
            {
                hm.put(words[i],((int)hm.get(words[i]))+1);
            }
            else
            {
                hm.put(words[i],1);
            }
        }
        
        Queue<String> pq = new PriorityQueue<>((w1,w2)-> hm.get(w1)==hm.get(w2)?w1.compareTo(w2):hm.get(w2)-hm.get(w1));
        
        for(String a : hm.keySet())
        {
            pq.offer(a);
        }
        //System.out.println(pq.toString());
        List<String> res= new ArrayList<>();
        for(int i=1;i<=k;i++)
        {
            res.add(pq.poll()); 
        }
        
        return res;
    }
}