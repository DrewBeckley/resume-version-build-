import java.util.ArrayList;
import java.util.Arrays;
import java.util.*; 
import java.util.function.*;
public class Entries
{
    
    private String entry;
    private double amount;
    private String[] arr={"test","123"};
    private int id;
    public static ArrayList <String>EntriesArray=new ArrayList<String>();
    public static ArrayList <Double> amountsArray=new ArrayList<Double>();
    
 //   private void addToAll(boolean isAdding)

    
    
    //constructor
    public Entries(String entry,double amount)
    {
        this.entry=entry;
        EntriesArray.add(this.entry);
        this.amount=amount;
        amountsArray.add(this.amount);
    }

    //getter and setters, and toString
    
    
    //getter
    public double  getamountA(int index)
    {
        return amountsArray.get(index);
    }
    //6/11/21 learned how to use function type refrance
    //public static Function<Integer, Double> getAmount = (index)->amountsArray.get(index.intValue());
    
    //getter
    public String getEntriesA(int index)
    {
        return EntriesArray.get(index);
    }
    
    
    //setter
    public void setAmount(double setto)
    {
        this.amount=setto;
    }
    public double getAmount()
    {
        return amount;
    }
    
    
    //setter
    public void setEntry(String setto)
    {
        this.entry=setto;
    }
    //getter
    public  String getEntry()
    {
        return entry;
    }

    
    public String toString()
    {
        return entry;
    }
    
    
}