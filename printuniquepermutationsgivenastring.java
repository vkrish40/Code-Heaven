/******************************************************************************

Print Unique Permutations Given A String.
  
*******************************************************************************/
import java.util.*;
public class Main
{
    static Set<Integer> visited;
    static int counter = 0;
    public static void permutation(char[] ch_str, int len, int pos, char[] build)
    {
        if(pos>=len)
        {
            System.out.println(new String(build));
            counter++;
            return;
        }
        char temp = '.';
        for(int i=0;i<len;i++)
        {
            if(temp==ch_str[i])
                continue;
            if(!visited.contains(i))
            {
                temp = ch_str[i];
                visited.add(i);
                build[pos] = ch_str[i];
                permutation(ch_str, len, pos+1, build);
                visited.remove(i);
            }
        }
    }
	public static void main(String[] args) {
	  
	    String str = "11234";
	    visited = new HashSet<>();
	    char[] ch_str = str.toCharArray();
	    char[] ans = new char[ch_str.length];
	    Arrays.sort(ch_str);
		permutation(ch_str, ch_str.length, 0, ans);
		System.out.println("Total Count: " + counter);
		
	}
}
