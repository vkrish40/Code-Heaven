/******************************************************************************

                            Implementing MAX HEAP

*******************************************************************************/
import java.util.*;
public class Main
{
    int counter = 0;
    int[] heap;
    public void insert(int val)
    {
        ensurecapacity();
        heap[counter] = val;
        heapify_up();
        counter++;
    }
    public int remove()
    {
        int val = heap[0];
        heap[0] = heap[counter-1];
        heapify_down();
        counter--;
        
        return val;
        
    }
    public void peek()
    {
        System.out.println("PEEK: " + heap[0]);
    }
    public void heapify_up()
    {
        int temp = counter;
        int index = (temp-1)/2;
        while(index>=0 && heap[index]<heap[temp])
        {
            int val = heap[index];
            heap[index] = heap[temp];
            heap[temp] = val;
            temp=index;
            index = (index-1)/2;
            
        }
    }
    public void heapify_down()
    {
        int parent = 0;
        int lc_index = 2*(parent)+1;
        while(lc_index<counter-1)
        {
            int rc_index = 2*(parent)+2;
            if(rc_index<counter-1 && heap[rc_index] > heap[lc_index])
            {
                lc_index = rc_index;
            }
            if(heap[lc_index]>heap[parent])
            {
                int val = heap[parent];
                heap[parent] = heap[lc_index];
                heap[lc_index] = val;
                parent = lc_index;
                lc_index = 2*(parent) +1;
            }
            
        }
    }
    public void ensurecapacity()
    {
        if(counter>=heap.length)
        {
            heap = Arrays.copyOf(heap, 2*heap.length);
        }
    }
    public void build(int[] data)
    {
        heap = new int[data.length];
        
        insert(data[0]);
        insert(data[1]);
        insert(data[2]);
        insert(data[3]);
        insert(data[4]);
        insert(data[5]);
        insert(data[6]);
        System.out.println("Removed value: " + remove());
        System.out.println("Removed value: " + remove());
        System.out.println("Removed value: " + remove());
        System.out.println("Removed value: " + remove());
        System.out.println("Removed value: " + remove());
        System.out.println("Removed value: " + remove());
        System.out.println("Removed value: " + remove());
        insert(100);
        insert(40);
        insert(50);
        insert(10);
        insert(15);
        insert(50);
        insert(40);
        
        peek();
        
        for(int i=0;i<heap.length;i++)
            System.out.println(heap[i]);
        
    }
	public static void main(String[] args) {
	    
	    int[] data = {10,5,4,11,14,7,1}; 
	    
	    Main obj = new Main();
	    obj.build(data);
	}
}
