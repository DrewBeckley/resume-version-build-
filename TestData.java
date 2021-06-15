import java.util.*;
public class TestData
{
	String[] argST={"10","15","25","35","40","50","60","70","84","97"};
	Integer[] argInT={10,15,25,35,40,50,60,70,84,97};
	Double[] argDOU={10.,15.,2.5,3.5,4.0,5.0,6.0,7.0,84.,9.7};
	//Long[] argLONG={10,15,25,35,40,50,60,70,84,97};
	
	public<E> ArrayList<E> converttoAL(E[] arg)
	{
		var bi=new ArrayList<E>();
		bi.addAll(Arrays.asList(arg));
		return bi;
	}
}