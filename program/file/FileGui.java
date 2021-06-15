import javax.swing.*;
import javax.swing.JButton.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.util.stream.*;
public class FileGui extends FileLogic implements ActionListener
{
	//jframe,pane,pannels
	private  JPanel fileS;
	ArrayList<String>listOfRecipeList=new ArrayList<String>();
	ArrayList<String>listOfContentList=new ArrayList<String>();
	private  JList displayList;
	JTextField new_file_itle;
	//buttons an other compentents
	private JButton open_File;
	private  JTextArea editEntryArea;
	private JButton Save_Button;
	JButton rename_Button;
	JButton view_Button;
	JButton new_File;
	JButton delete_Button;
	JLabel instrtion;
	int selection;
	int margin=10;
	int ButtonY=253;
	
	
	
	public JPanel file_Make()
	{
		//System.out.println("start");
		load_Entry();
		fileS=new JPanel();
		fileS.setLayout(null);
		mainPage();
		//from testing
		//selection=0;
		//activeFile(0,true);
		return fileS;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	private void mainPage()
	{
		//Jlist
		displayList=new JList(listOfRecipeList.toArray());
		displayList.setBounds(margin,margin+30,250,200);
		//displayList.getDef
		fileS.add(displayList);

		
		//new file and Delete
		new_File=new JButton("new file");
		new_File.setBounds(margin,ButtonY+50,100,40);
		new_File.addActionListener(this);
		fileS.add(new_File);
		//Delete
		delete_Button=new JButton("delete");
		delete_Button.setBounds(margin+110,ButtonY+50,100,40);
		delete_Button.addActionListener(this);
		fileS.add(delete_Button);
		
		
		//button for selection of file to edit
		open_File=new JButton("open");
		open_File.setBounds(margin,ButtonY,100,40);
		open_File.addActionListener(this);
		fileS.add(open_File);
		
		
		//nonedit view
		view_Button=new JButton("veiw");
		view_Button.setBounds(margin+110,ButtonY,100,40);
		view_Button.addActionListener(this);
		fileS.add(view_Button);
		
		
		//label
		instrtion=new JLabel("select your recipe");
		instrtion.setBounds(margin,margin,300,40);
		//instrtion.setTextColor(Color.red);
		fileS.add(instrtion);
	}
	
	
	
	JButton return_Button;
	//activly editing a file
	private void activeFile(int sel,boolean canEdit)
	{
		//variables
		int sizeX=100;
		int sizeY=20;
		
		
		
		//fileS.removeAll();
		fileS.remove(open_File);
		fileS.remove(displayList);
		fileS.remove(view_Button);
		fileS.remove(new_File);
		fileS.remove(delete_Button);
		//fileS.remove(new_);
		//refresh screen
		fileS.validate();
		fileS.repaint();

		// //button 1
		Save_Button=new JButton("save");
		Save_Button.setBounds(250,100 ,sizeX, sizeY);
		
		Save_Button.addActionListener(this);
		fileS.add(Save_Button);
		
		//button 2
		rename_Button=new JButton("rename");
		rename_Button.setBounds(Save_Button.getX(),Save_Button.getY()+30 ,sizeX, sizeY);
		rename_Button.addActionListener(this);
		fileS.add(rename_Button);

		//button 3
		return_Button=new JButton("Back");
		return_Button.setBounds(Save_Button.getX(),Save_Button.getY()-30 ,sizeX, sizeY);
		return_Button.addActionListener((e->backToMenu()));
		fileS.add(return_Button);
		
		
		editEntryArea=new JTextArea();
		editEntryArea.setBounds(margin,margin+30,250,250);
		editEntryArea.setLineWrap(true);
		editEntryArea.setEditable(canEdit);
		
		
		

		
		try{
			//changing label text to match if user is edit it or just viewing
			instrtion.setText(
				getEditModeText(canEdit,listOfRecipeList.get(selection))
				);
			//"ingredients:\n\n\ninstructons:"
			//try{
			editEntryArea.setText(listOfContentList.get(selection));
			fileS.add(editEntryArea);
			//editEntryArea.setAutoscrolls(true);
			//editEntryArea.getAutoscrolls();
			
		}catch(IndexOutOfBoundsException e){
			System.out.println("error finding selection");
			System.out.println(selection+"selected, Size: "+listOfContentList.size());
			System.out.println(e);

		}
		fileS.revalidate();
		fileS.repaint();

	}		
	
	
	
	
	
	//where action are Performed
	public void actionPerformed(ActionEvent e)
	{
		//class with logic
		var logic=new FileLogic();
		if(e.getSource()==Save_Button)
		{
				//Save_Button.setLocation(101,101);
				String in=editEntryArea.getText();
			
				String t=logic.save(in);
				
				listOfContentList.set(selection,t);
				save_entry();
				//System.out.print(t);
			
			
		}
		//*/
		if(e.getSource()==open_File)
		{
			if(displayList.getSelectedIndex()!=-1)
			{
				int select;
				select=displayList.getSelectedIndex();
				selection=select;
				activeFile(select,true);
				//open_File.setText(""+select);
				
			}
			
		}
		//this is for a new file
		if(e.getSource()==new_File)
		{
			
			instrtion.setText("name your new file");
			//new_File.setText("Create");
			//textfeild appears
			new_file_itle=new JTextField();
			new_file_itle.setBounds(175,15,100,20);
			new_file_itle.addActionListener(this);
			fileS.add(new_file_itle);
			fileS.repaint();
			
		}
		//textfeild
		if(e.getSource()==new_file_itle)
		{
			
			String imput=new_file_itle.getText();
			//System.out.println(imput);
			listOfRecipeList.add(imput);
			listOfContentList.add("text here");
			save_entry();
			displayList.setListData(listOfRecipeList.toArray());
			fileS.remove(new_file_itle);
			fileS.repaint();
			fileS.revalidate();
			fileS.repaint();
			



			
		}
		//this button is for deleteing
		if(e.getSource()==delete_Button)
		{
			if(displayList.getSelectedIndex()!=-1)
			{
				
				int select;
				select=displayList.getSelectedIndex();

				listOfRecipeList.remove(select);

				listOfContentList.remove(select);
				
				save_entry();
				displayList.setListData(listOfRecipeList.toArray());
				fileS.repaint();
				


			}
		}
		if(e.getSource()==view_Button)
		{
			if(displayList.getSelectedIndex()!=-1)
			{
				int select;
				select=displayList.getSelectedIndex();
				activeFile(select,false);
				//open_File.setText(""+select);
				
			}
			
		}

		
	}
	public void backToMenu()
	{
		fileS.removeAll();
		fileS.repaint();
		mainPage();
	}
	
	public void save_entry()
	{
		super.save(listOfContentList
			,listOfRecipeList);
	}


	public void load_Entry()
	{
		try{
			var out=super.load();
			//System.out.println(out.getClass());
			//out.forEach((i,j)->System.out.println(i+": "+
			//Arrays.stream(j).peek(p->System.out.println(p)).collect(Collectors.joining(","))));
			//var 
			//name=SaveSystem.getStringArray(out,1);
			listOfRecipeList=getStringAL(out,0);

		//	System.out.println(getStringAL(out,0)+"is name(gui)");


			//var content=SaveSystem.getStringArray(out,2);
			

			
			listOfContentList=getStringAL(out,1);
			//System.out.println(getStringAL(out,1)+"is content(giu)");
			//.addAll(Arrays.asList(content));
			//throw new RuntimeException("here what you want");
		}catch(NullPointerException e){
			//System.out.println(e+" in loading in file(gui)");
			
			//System.out.println(listOfContentList+" before");
			
			//listOfRecipeList.add("hi");
		
		//listOfContentList.add("an error has ocured in the load prosses ");
		//listOfRecipeList.remove(0);
		throw new RuntimeException("loading had an error in file(gui)");
		//System.out.println(listOfRecipeList);
			
			//save(listOfContentList,listOfRecipeList);
		}
	}
	
		
}//getStringAL