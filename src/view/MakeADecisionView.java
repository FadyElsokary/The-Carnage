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

import engine.Game;
import engine.Player;
import exceptions.FriendlyFireException;
import units.Army;

public class MakeADecisionView extends JFrame implements ActionListener{
	
	private Army a;
	private Army d;
	private JFrame frame;
	private JLabel label;
	private JButton attack;
	private JButton autoResolve;
	private Game f;
	private Player p;
	private JPanel panel;
	
	
	
	public MakeADecisionView(Army x, Army y,Player j,Game s)
	{
		a=x;
		d=y;
		f=s;
		p=j;
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setExtendedState(this.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		
		
		
		attack=new JButton("Attack");
		attack.setFocusable(false);
		attack.setBounds(300, 600, 150, 70);
		attack.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		attack.setForeground(Color.BLACK);
		attack.addActionListener(this);
		
		
		
		
		autoResolve=new JButton("AutoResolve");
		autoResolve.setFocusable(false);
		autoResolve.setBounds(900, 600, 250, 70);
		autoResolve.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		autoResolve.setForeground(Color.BLACK);
		autoResolve.addActionListener(this);
		
		
		
		
		label=new JLabel("City Has Been Under Siege For 3 Turns");
		label.setBounds(450, 100, 1000, 200);
		label.setFocusable(false);
		label.setVisible(true);
		label.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
		label.setForeground(Color.WHITE);
		
		
		panel=new JPanel();
		panel.setBounds(0, 0, 1920, 1080);
		panel.setBackground(Color.BLACK);
		panel.setFocusable(false);
		panel.setVisible(true);
		panel.setLayout(null);
		
		
		panel.add(attack);
		panel.add(autoResolve);
		panel.add(label);
		frame.add(panel);
		
		frame.revalidate();
		frame.repaint();
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
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
