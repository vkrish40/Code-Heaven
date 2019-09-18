class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        if(people==null || people.length==0 || limit==0)
            return 0;
        Arrays.sort(people);
        int start=0;
        int end=people.length-1;
        int numBoats=0;
        
        while(start<=end)
        {
            if(people[start]+people[end]<=limit)
            {
                start++;
                end--;
            }
            else 
                end--;
            numBoats++;
        }
        return numBoats;
    }
}