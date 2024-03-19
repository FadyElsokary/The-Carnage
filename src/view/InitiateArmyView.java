package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.City;
import engine.Game;
import engine.Player;
import units.Unit;

public class InitiateArmyView extends JFrame implements ActionListener{
	
	private Player p;
	private City v;
	private Game f;
	private JFrame frame;
	private JPanel panel;
	private JButton b;
	private ArrayList<JButton> buttons=new ArrayList<JButton>();
	
	
	public InitiateArmyView(City x,Game s)
	{
		v=x;
		f=s;
		p=s.getPlayer();
		
		
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setBounds(350, 100, 800,700 );
		frame.setVisible(true);
		frame.setLayout(null);
		
		

		
		panel=new JPanel();
		panel.setBounds(0, 0, 800, 700);
		panel.setLayout(new GridLayout(0,3));
		
		
		
		for(int i=0;i<v.getDefendingArmy().getUnits().size(); i++)
		{
		    b=new JButton();
			b.addActionListener(this);
			buttons.add(b);
			b.setText("Unit"+(i+1)+"");
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
		Unit u=v.getDefendingArmy().getUnits().get(k);
		p.initiateArmy(v, u);
		frame.setVisible(false);
		
		
		
	}

}
