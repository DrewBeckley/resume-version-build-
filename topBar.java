

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.*;
import javax.swing.JMenuItem;
import java.awt.event.*;
import program.*;
//*/
public class topBar implements ActionListener
{
	
	
	
	JMenuItem save_Location;


	public JMenuBar test()
	{
		JMenuBar mb=new JMenuBar();
		JMenu menu1=new JMenu("Menu");  
		//JMenu submenu=new JMenu("Sub Menu");  
		
		//menu items
		save_Location=new JMenuItem("Save loction");
		save_Location.addActionListener((e)->
		
		
		{
			JFileChooser hi=new JFileChooser();
			int rep=hi.showOpenDialog(null);
			if(rep==JFileChooser.APPROVE_OPTION)
			{
				String loc=hi.getSelectedFile().getAbsolutePath();
				System.out.println(loc); }
		});
		
		//x
		menu1.add(save_Location);
		mb.add(menu1);  
		return mb;
	}

	public void actionPerformed(ActionEvent e)
	{
		//if(e.getSource()==save_Location)
		//{
			//replaced by lambas
		//}
	}


	
}