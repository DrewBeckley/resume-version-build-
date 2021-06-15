import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.awt.event.*;
import java.awt.Window.*;
import java.util.ArrayList;
import java.util.Arrays;
public class InvGui extends InvLogic implements ActionListener,ListSelectionListener
{
	private JPanel inv;
	private JButton saveButton;
	private JTable table;
	private JButton update_Button;
	private DefaultTableModel model;
	private JTextField amount_Field;
	private JTextField name_Field;
	private ArrayList<InvEntry> InvLog=new ArrayList<InvEntry>();
	private JLabel name_Label;
	public JPanel inv_PullUp()
	{
		inv=new JPanel();
		//GridLayout G=new GridLayout(3,1,10,10);
		inv.setLayout(null);
		inv.setBackground(Color.green);
		//System.out.println(inv.getLatout());
		menu_Group();
		inv.add(table_SetUp());
		
		return inv;
	}
	private void inv_Request()
	{
		inventory I=new inventory();
		I.run();
	}
	private void menu_Group()
	{
		int co=10;
		//name
		name_Label=new JLabel("name: ");
		name_Label.setBounds(200+co*3,10,100,20);
		inv.add(name_Label);

		int off_name=name_Label.getX()+40+co*2;
		name_Field=new JTextField();
		name_Field.setBounds(off_name,name_Label.getY(),100,20);
		name_Field.addActionListener(this);
		//System.out.println(name_Field.getLocation());
		inv.add(name_Field);


		//amount		
		
		JLabel amount_Label=new JLabel("amount: ");
		amount_Label.setBounds(name_Label.getX(),40,100,20);
		inv.add(amount_Label);
		
		//goes of of other feild
		amount_Field=new JTextField();
		amount_Field.setBounds(name_Field.getX(),amount_Label.getY(),100,20);
		amount_Field.addActionListener(this);
		inv.add(amount_Field);

		//button
		update_Button=new JButton("add entry");
		update_Button.setBounds(name_Label.getX(),amount_Label.getY()+25,150,20);
		//update_Button.setHorizontalAlignment(SwingConstants.LEADING);
		update_Button.setBackground(Color.red);
		update_Button.setForeground(Color.WHITE);
		update_Button.addActionListener(this);
		inv.add(update_Button);


		//button
		saveButton=new JButton("save data");
		saveButton.setBounds(name_Label.getX(),update_Button.getY()+25,150,20);
		//saveButton.setBackground(Color.black);
		saveButton.addActionListener((e)->saveButtonEffect());
		inv.add(saveButton);
	}
	
	
	
	
	private JScrollPane table_SetUp()
	{
		String data[][]={};	
		load_Entry();
		
		//table
		String colums[]={"item","amount"};
		model=new DefaultTableModel(data,colums);
		table=new JTable(model);
		table.setBounds(10,10,200,300);
		//table.setCellEditable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(5);
		//model.getSelect
		table.getSelectionModel().addListSelectionListener(this);
		JScrollPane panel=new JScrollPane(table);
		panel.setBackground(Color.black);
		panel.setBounds(table.getX(),table.getY(),table.getWidth(),table.getHeight());
		//fill in the empty table created above
		for(InvEntry n:InvLog)
		{
			model.addRow(new Object[]{n.getName(),n.getAmount()});
			
			//n.getAmount().toString()
		}
		model.addRow(new Object[]{"",""});
		//table.setSelectedRow(0);
		table.setRowSelectionInterval(0, 0);
		return panel;
	}
	
	
	
	
	
	//any button functio that would be along block lamba
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==update_Button)
		{
			
			if(name_Field.getText().length()>2 &&  amount_Field.getText().length()>0)
			{
				if(table.getSelectedRow()==model.getRowCount()-1)
				{
					model.removeRow(model.getRowCount()-1);
					model.addRow(new Object[]{name_Field.getText(),amount_Field.getText()});
					name_Field.setText("done");
					amount_Field.setText("");
					model.addRow(new Object[]{"",""});
				}
				else
				{
					table.setValueAt(name_Field.getText(), table.getSelectedRow(), 0);
					table.setValueAt(amount_Field.getText(), table.getSelectedRow(), 1);
				}
			}
		}
	}

	//utility method
	private void printTable()
	{
		//inv_Request();

		for(int c=0;c<table.getColumnCount()-1;c++)
		{
			for(int I=0;I<table.getRowCount();I++)
			{
				//System.out.print("I am pressed");
				System.out.println(table.getValueAt(I,c)+" is "+table.getValueAt(I, c+1));
				//if(table.getValueAt(I,c).equals(na))
			}
			

		}
		//*/
		//save_entry();
		//c!=table.getColumnCount()
	}

	private void saveButtonEffect()					
	{
		System.out.println("saving");
		//printTable();
		
		//todo:if same as before then move on outter wise update to match
		for(int I=0;I<table.getRowCount()-1;I++)
		{
			
			try{
				
				//var be=nameList.stream().map(Double::parseDouble).collect(Collectors.asList());
				
				//this will convert every thing to string because it is a mix of doubles and Strings in table due to implimention
				if(table.getValueAt(I,0).equals(InvLog.get(I).getName()))
				{
					//System.out.println("match item "+I);
					//continue;
				}
				else
				{
					String test=table.getValueAt(I,0).toString();			
					System.out.println("miss match item index "+I+" and will become "+test);
					
					InvLog.get(I).setName(table.getValueAt(I,0).toString());
				}
				
				String v=table.getValueAt(I,1).toString();
				//String[] postMod=temp.stream().map(Object::toString).collect(Collectors.joining(", ")).split(", ");
				var y=String.valueOf(InvLog.get(I).getAmount());
				if(v.equals(y))
				{
					//System.out.println("match amount "+I);
					continue;
				}
				else
				{
					System.out.println("miss match amount "+I);
					System.out.println(table.getValueAt(I,1).getClass());
					//v.
					System.out.println(InvLog.get(I).getAmount()+"\n\n");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			System.out.println("finished");
		}

	}
	
	
	
	
	
	
	
	
	
	
	public void valueChanged(ListSelectionEvent e)
	{
		try{
			//System.out.print(table.getValueAt(table.getSelectedRow(),1).toString());
			if(table.getSelectedRow()!=table.getRowCount()-1)
			{
				update_Button.setText("update entry");
				name_Field.setText(
					table.getValueAt(table.getSelectedRow(),0).toString()
					);
				amount_Field.setText(
					table.getValueAt(table.getSelectedRow(),1).toString());
			}
			else
			{
				update_Button.setText("add entry");
			}
		}catch(Exception ex){
			//ex.printStackTrace();
			System.out.println("no selection on table selected.");
		}
	}
	
	
	
	
	
	
	
	
	String fLocation="saveData/InvData.txt";
	//String fLocation="Data.txt";
	
	public void save_entry()
	{
		super.save(InvLog);
	}
	
	
	public void load_Entry()
	{
		
		ArrayList<String> nameList=new ArrayList<String>();
		ArrayList<String> amountList=new ArrayList<String>();
		try{
			BufferedReader test=new BufferedReader(new FileReader(fLocation));
			String[] temp={};
			//reader print setup
			String num="";
			while((num=test.readLine())!=null)
			{
				//String tester=test.readLine();
				//System.out.println(num);
				switch(num)
				{
					case "item name:":
						num=test.readLine();
						//prossesing
						String sub=num.substring(0,num.length()-1);
						//System.out.println(sub);
						temp=sub.split(", ");
						//nameList.clear();
						int i=0;
						for(String n: temp)
						{
						
							nameList.add(n);
							//if(!nameList.get(i).equals(""))
							//{
							//}
							//else
							//{
							//System.out.println(temp[i]);
							//nameList.add(n);
							//}
							i++;
						}
						//System.out.println(nameList);
						break;
						
					//fix
					case "amount:":
						num=test.readLine();
						//System.out.println(num);
						String consub=num.substring(0,num.length()-1);
						//System.out.println(consub+" is");
						temp=consub.split(", ");
						//System.out.println(temp);
						//listOfContentList.clear();
						for(String n: temp)
						{
							amountList.add(n);
							//System.out.println(n);
						}
						//System.out.println(amountList);
						break;
					};
					
					
			}
			test.close();
			int i=0;
			try{
				
				for(String n:nameList)
				{
					double Do;
					Do=Double.parseDouble(amountList.get(i));
						//fix
					InvLog.add(new InvEntry(nameList.get(i), Do));
					i++;
				}
			
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("continuing thought error loading items"+"("+amountList.size()+" size).");
			//System.exit(0);
			}
			//System.out.println("reading finish");
		}catch(Exception ex){
			//System.out.println(ex+" in load_Entry");
			String x=ex+" in load_Entry";
			throw new RuntimeException(x);
		
		}
	}
}

