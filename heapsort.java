/******************************************************************************

                            Implementing Heap Sort using build (max heap) and 
                            extraction phases.

*******************************************************************************/
import java.util.*;
public class Main
{
    public void heapifyDown(int[] arr, int pos, int counter)
    {
        int max_pos = 2*pos+1; 
        while(max_pos<counter)
        {
            if((max_pos+1)<counter)
            {
                max_pos = arr[max_pos]>=arr[max_pos+1]?(max_pos):(max_pos+1);
            }
            if(arr[pos]<arr[max_pos])
            {
                int temp = arr[pos];
                arr[pos] = arr[max_pos];
                arr[max_pos] = temp;
                pos = max_pos;
                max_pos = 2*pos+1;
            }
            else 
                return; //to break the infinite loop in case both the children are smaller than the parent
        }
    }
    
    public void start()
    {
        //int[] arr = {10,6,7,5,15,17,12};
        //int[] arr = {90,80,70,60,50,40,30,100};
        int[] arr = {6,8,1,7,3,5,2,9,4,10};
        for(int i=arr.length/2;i>=0;i--)    // Building a max heap
        {
            heapifyDown(arr, i, arr.length);
        }
        
        int counter = arr.length-1;
        while(counter>0)    //Extraction Phase after building a max heap
        {
            int temp = arr[0];
            arr[0] = arr[counter];
            arr[counter] = temp;
            heapifyDown(arr, 0, counter);
            counter--;
        }
        for(int val:arr) // Debugging (CHECKING THE SORTED OUTPUT)
        {
            System.out.println(val);
        }
    }
	public static void main(String[] args) {
	    
	    Main obj = new Main();
	    obj.start();
	}
}
