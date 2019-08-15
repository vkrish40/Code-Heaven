import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         
        
        PriorityQueue<Integer> res=new PriorityQueue<>(); 
        int index;
        double median=0;
        
        for(int i=0;i<nums1.length;i++)
        {
            res.offer(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++)
        {
            res.offer(nums2[i]);
        }
        int len=res.size();
        
        if(len%2==1)
        {
            for(int i=1;i<=len/2;i++)
                res.poll();
            median=res.poll();
        }
        else
        {
            for(int i=1;i<len/2;i++)
                res.poll();
            median=(double)(res.poll()+res.poll())/2;
        }
              
        /*
        Alternate approach but quite high time complexity
        
        List<Integer> ans=new ArrayList<>();
        
        while((res.size())!=0)
        {
            ans.add(res.poll());
        }
        
        System.out.println("LIST: " + ans);
        
        if(ans.size()%2==1)
        {
            index=(ans.size())/2;
            median=ans.get(index);
        }
        else
        {
            index=(ans.size())/2;
            System.out.println("Index:" + index);
                   
            median=(double)(ans.get(index-1)+ans.get(index))/2;
        }*/
        
        return median;           
    }
}