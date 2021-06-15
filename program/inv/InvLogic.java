import java.util.*;
import java.io.*;
public class InvLogic
{
	//to seperate the gui from the logic
	
	String fLocation="saveData/InvData.txt";
	public void save(ArrayList<InvEntry>InvLog)
	{
		try{
			BufferedWriter buffer=new BufferedWriter(new FileWriter(fLocation));
			//saving
			buffer.write("item name:");
			buffer.newLine();
			int y=0;
			for(InvEntry n:InvLog)
			{
				buffer.append(n.getName()+", ");
				//*.getName
				y++;
			}//*/
			buffer.newLine();
			buffer.append("amount:\n");
			for(int i=0;i<InvLog.size();i++)
			{
				//System.out.println(InvLog.get(i).getName());
				buffer.append(InvLog.get(i).getAmount()+", ");
			}
			
			
			buffer.close();
		}catch(Exception ex){
			//System.out.println("Error in save "+ex);
			var error="Error in save "+ex;
			throw new RuntimeException(error);
		}finally{
			//System.out.print("inv load");
			
		};
		
	}
}