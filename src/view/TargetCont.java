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
import units.Army;

public class TargetCont extends JFrame implements ActionListener{
	
	private Army a;
	private Game f;
	private Player p;
	private JFrame frame;
	private JPanel panel;
	private JButton b;
	private ArrayList<JButton> buttons=new ArrayList<JButton>();
	private ArrayList<City> temp=new ArrayList<City>();
	
	
	
	public TargetCont(Army y,Game s)
	{
		a=y;
		f=s;
		p=s.getPlayer();
		
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setBounds(550, 300, 400,200 );
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		panel=new JPanel();
		panel.setBounds(0, 0, 400, 200);
		panel.setLayout(new GridLayout(0,2));
		
		
		for(int i=0;i<f.getAvailableCities().size(); i++)
		{
		    if(!(p.getControlledCities().contains(f.getAvailableCities().get(i))))
		    {
		    	temp.add(f.getAvailableCities().get(i));
		    	b=new JButton();
				b.addActionListener(this);
				buttons.add(b);
				b.setText(f.getAvailableCities().get(i).getName());
				panel.add(b);
		    }
			
		}
		
		
        frame.add(panel);
		
		
		
		frame.revalidate();
		frame.repaint();
		
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		int k=buttons.indexOf(b);
		City v=temp.get(k);
		f.targetCity(a, v.getName());
		frame.setVisible(false);
		
	}

}
