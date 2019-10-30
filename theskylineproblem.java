import java.util.*;

class building implements Comparable<building>
{
    boolean start;
    boolean end;
    int pos;
    int height;
    public building(boolean start, boolean end, int pos, int height)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
        this.height = height;
    }    
    public int compareTo(building obj)
    {
        if(this.pos!=obj.pos)
            return this.pos-obj.pos;
        else if(this.start && obj.start)
            return obj.height-this.height;
        else if(this.end && obj.end)
            return this.height-obj.height;
        else if(this.start && obj.end)
            return -1;
        return 1;
    }
}

class Solution 
{
        NavigableMap<Integer,Integer> map;
    
        public List<List<Integer>> getSkyline(int[][] buildings) {

        if(buildings==null || buildings.length==0)
            return Arrays.asList();
            
        map = new TreeMap<>();
        List<List<Integer>> list = new ArrayList<>();
        building[] matrix = new building[2*buildings.length];
        
        int count = 0;
        for(int i=0;i<buildings.length;i++)
        {
            matrix[count++] = new building(true, false, buildings[i][0], buildings[i][2]);
            matrix[count++] = new building(false, true, buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(matrix);
        /*for(building temp:matrix) //Debugging (the matrix array sorted properly or not)
        {
            System.out.println(temp.start + "\t" + temp.end + "\t"+ temp.pos + "\t"+ temp.height);
        }*/ 
        map.put(0,1);
        for(int i=0;i<matrix.length;i++)
        {
            building temp = matrix[i];
            int max = map.lastKey();
            if(temp.start)
            {
                int val = map.getOrDefault(temp.height,0);
                map.put(temp.height, val+1);
                val = map.lastKey();
                if(val!=max)
                {
                    list.add(Arrays.asList(temp.pos, temp.height));
                }
            }
            else if(temp.end)
            {
                int val = map.get(temp.height)-1;
                if(val==0)
                {
                    map.remove(temp.height);
                    val = map.lastKey();
                    if(val!=max)
                    {
                        list.add(Arrays.asList(temp.pos, val));
                    }
                }
                else
                {
                    map.put(temp.height, val);
                }
                
            }
        }            
        return list;      
    }
}