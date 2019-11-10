class MinStack {

    /** initialize your data structure here. */
    
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> min_stack = new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int x) {        
        stack.push(x);
        if(min_stack.isEmpty())
            min_stack.push(x);
        else
        {
            int val = min_stack.peek();
            if(val>x)
                min_stack.push(x);
            else
                min_stack.push(val);
        }
            }
    
    public void pop() {
        
        stack.pop();
        min_stack.pop();       
        
    }
    
    public int top() {
        return stack.peek();        
    }
    
    public int getMin() {
        
        return min_stack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */