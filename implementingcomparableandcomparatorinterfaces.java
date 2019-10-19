/******************************************************************************

                            Implementing Comparable and Comparator interfaces

*******************************************************************************/
import java.util.*;

class Shipment implements Comparable<Shipment>
{
    int cost;
    public Shipment(int cost)
    {
        this.cost=cost;
    }
    public int compareTo(Shipment obj)
    {
        return this.cost-obj.cost;
    }
}
class Comp implements Comparator<Shipment>
{
    public int compare(Shipment obj1, Shipment obj2)
    {
        return obj2.cost-obj1.cost;
    }
}

public class Main
{
	public static void main(String[] args) {
		Shipment obj1 = new Shipment(1000);
		Shipment obj2 = new Shipment(100);
		Shipment obj3 = new Shipment(5000);
		Shipment obj4 = new Shipment(100000);
		Shipment obj5 = new Shipment(11000);
		List<Shipment> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.add(obj4);
		list.add(obj5);
		System.out.println("INCREASING ORDER USING NATURAL ORDERING: ");
		Collections.sort(list);
		Iterator<Shipment> itr = list.iterator();
		while(itr.hasNext())
		{
		    System.out.println(itr.next().cost);
		}
		System.out.println("DECREASING ORDER USING COMPARATOR: ");
		Collections.sort(list,new Comp());
		itr = list.iterator();
		while(itr.hasNext())
		{
		    System.out.println(itr.next().cost);
		}
	}
}
