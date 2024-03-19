package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.City;
import engine.Player;
import exceptions.MaxCapacityException;
import units.Army;
import units.Status;
import units.Unit;

public class RelocateCont extends JFrame implements ActionListener{
	
	private Player p;
	private Unit u;
	private JFrame frame;
	private JPanel panel;
	private JButton b;
	private ArrayList<JButton> buttons=new ArrayList<JButton>();
	private City v;
	
	
	
	public RelocateCont(Unit x,Player s,City c)
	{
		u=x;
		p=s;
		v=c;
		
		
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setBounds(350, 100, 800,700);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		
		panel=new JPanel();
		panel.setBounds(0, 0, 400, 200);
		panel.setLayout(new GridLayout(0,2));
		
		
		
		for(int i=0;i<p.getControlledArmies().size(); i++)
		{
			if(p.getControlledArmies().get(i).getCurrentStatus()==Status.IDLE && p.getControlledArmies().get(i).getCurrentLocation().equals(v.getName()))
		    b=new JButton();
			b.addActionListener(this);
			buttons.add(b);
			b.setText("Army: "+(i+1)+"");
			panel.add(b);
		}
		
		
		
		frame.add(panel);
		
		
		
		frame.revalidate();
		frame.repaint();
		
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		int k=buttons.indexOf(b);
		Army c=p.getControlledArmies().get(k);
		try {
			c.relocateUnit(u);
		} catch (MaxCapacityException e1) {
			JOptionPane.showMessageDialog(null, "Maximum capacity reached");
		}
		frame.setVisible(false);
		
	}

}
