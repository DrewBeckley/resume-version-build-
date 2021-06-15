import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenuBar;
import java.awt.Window.*;
//import program.*;
import java.util.*;
import java.util.stream.*;
import program.*;
import program.file.*;
import program.inv.*;


class startup implements Runnable
{
	private JFrame main_Frame;
	public JTabbedPane main_Tpane;

	
	public void run(){
		
		Thread.currentThread().setName("Statup");
		Thread.currentThread().setPriority(1);
		
		
		//System.out.println(Thread.currentThread().getPriority());
		
		
		
		System.out.println(  "Thread " + Thread.currentThread().getId() + " is running");
		//*/
		//System.out.print("");
			//Stream.iterate(50,i->i++).limit(50).forEach(i->System.out.println(i--));
		//.collect(Collectors.joining())
		
		//*/
		
		gui();
	}

	private void gui() {
		//Main bro = new Main();
		main_Frame = new JFrame("hello world");
		main_Frame.setResizable(false);
		main_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bringUp();
		//System.out.print(main_Frame.getClass().getSimpleName());
	}

	private void bringUp() {
		
		
		addContent();
		// System.out.println("X is "+main_Tpane.getX()+",Y is "+main_Tpane.getX()+"is its width is
		// "+main_Tpane.getWidth()+", and Height is "+main_Tpane.getHeight());
		// size is(390,370)

	}

	private void addContent() {
		
		Cal L = new Cal();
		main_Frame.setSize(400, 400 + (370 - 349));
		main_Frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		// JTabbedPane
		main_Tpane = new JTabbedPane();
		main_Tpane.setBackground(Color.lightGray);

		InvGui G = new InvGui();
		FileGui C = new FileGui();
		main_Tpane.add("Files", C.file_Make());
		main_Tpane.add("Inventory", G.inv_PullUp());
		main_Tpane.add("Calculator", L.Cal_BringUp());
		main_Frame.add(main_Tpane);
		
		topBar bar=new topBar();
		main_Frame.setJMenuBar(bar.test());
		
		main_Frame.setVisible(true);
		main_Tpane.setSelectedIndex(0);
		
	}

}
