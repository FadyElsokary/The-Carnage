package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.City;
import engine.Game;
import engine.Player;
import exceptions.FriendlyCityException;
import exceptions.FriendlyFireException;
import exceptions.TargetNotReachedException;
import units.Army;

public class ChoiceView extends JFrame implements ActionListener{
	
	private Army a;
	private Army d;
	private City defendingCity;
	private Player p;
	private Game f;
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JButton laySeige;
	private JButton attack;
	private JButton autoResolve;
	
	
	public ChoiceView(Army a,City x,Player l,Game m)
	{
		this.a=a;
		this.d=x.getDefendingArmy();
		defendingCity=x;
		p=l;
		f=m;
		
		
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setExtendedState(this.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		
		
		
		label=new JLabel("You Have To Make A Decision");
		label.setBounds(350, 100, 1000, 200);
		label.setFocusable(false);
		label.setVisible(true);
		label.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
		label.setForeground(Color.WHITE);
		
		
		
		
		
		laySeige=new JButton("LaySeige");
		laySeige.setBounds(200, 500, 150, 50);
		laySeige.setFocusable(false);
		laySeige.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		laySeige.addActionListener(this);
		
		
		
		
		attack=new JButton("Attack");
		attack.setBounds(700, 500, 150, 50);
		attack.setFocusable(false);
		attack.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		attack.addActionListener(this);
		
		
		
		
		
		autoResolve=new JButton("Auto Resolve");
		autoResolve.setBounds(1200, 500, 150, 50);
		autoResolve.setFocusable(false);
		autoResolve.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		autoResolve.addActionListener(this);
		
		
		
		
		panel=new JPanel();
		panel.setBounds(0, 0, 1920, 1080);
		panel.setBackground(Color.BLACK);
		panel.setFocusable(false);
		panel.setVisible(true);
		panel.setLayout(null);
		
		
		
		
		panel.add(laySeige);
		panel.add(autoResolve);
		panel.add(attack);
		panel.add(label);
		frame.add(panel);
		
		
		
		
		frame.revalidate();
		frame.repaint();
		
		
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	       if(e.getSource()==laySeige)
	       {
	    	   try {
				p.laySiege(a, defendingCity);
				frame.setVisible(false);
		    	new WorldMapView(f,p);
			} catch (TargetNotReachedException e1) {
				JOptionPane.showMessageDialog(null, "Target not reached");
				
			} catch (FriendlyCityException e1) {
				JOptionPane.showMessageDialog(null, "You can't attack a friendly city");
				
			}
	    	   frame.setVisible(false);
	    	   new WorldMapView(f,p);
	       }
	       else
	       {
	    	   if(e.getSource()==attack)
	    	   {
	    		   
	    		   new BattleView(a,d,p,f);
	    	   }
	    	   else
	    	   {
	    		   try {
					f.autoResolve(a, d);
					if(f.isGameOver())
					{
						 new GameOver(p,f);
					}
					else
					{
						if(a.getUnits().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "You Lost The Battle");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "You Won The Battle");

						}
						frame.setVisible(false);
				    	   new WorldMapView(f,p);

					}
				} catch (FriendlyFireException e1) {
					JOptionPane.showMessageDialog(null, "Cannot attack a friendly unit");
					
				}
	    		   frame.setVisible(false);
		    	   new WorldMapView(f,p);

	    	   }
	       }
		
	}
	

}
