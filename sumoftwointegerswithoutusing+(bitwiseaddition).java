class Solution {
    public int getSum(int a, int b) {
        
        int and = a&b;
        int xor = 0;
        
        while(and!=0)
        {
            xor = a ^ b;
            and = and<<1;
            a = xor;
            b = and;
            and = a&b;
        }
        
        xor = a ^ b;
        return xor;
        
    }
}