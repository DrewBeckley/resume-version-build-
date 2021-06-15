import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
//import javax.swing.JTabbedPane;
//wip
public class Cal
{
	public JTabbedPane Cal_BringUp()
	{
		JTabbedPane t=new JTabbedPane();
		t.add("Costs/serving",CPS_Make());
		t.add("Costs/serving",APC_Make());
		//t.add("Cost cal",cost_Make());
		return t;
	}
	private JPanel CPS_Make()
	{
		JPanel CPS=new JPanel();
		JLabel label=new JLabel("WIP/possible expreimental tab with testing stuff.");
		label.setBounds(00,00,100,20);
		//label.setRelativeTo();
		CPS.add(label);
		return CPS;
	}
	private JPanel APC_Make()
	{
		JPanel APC=new JPanel();
		return APC;
	}
	private JPanel cost_Make()
	{
		JPanel Cost_cal=new JPanel();
		return Cost_cal;
	}

}