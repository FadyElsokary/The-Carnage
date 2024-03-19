package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Unit;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.SwingConstants;

import engine.Game;
import engine.Player;
import exceptions.FriendlyFireException;

public class BattleView extends JFrame implements ActionListener{
		
		JFrame frame;
		int AttackerNo;
		int DefenderNo;
		ArrayList<String> LogString;
		ArrayList <JButton> attacker;
		ArrayList <JButton> defender;
		JButton AttackButton;
		JLabel x;
		JButton AutoButton;
		Panel panel_1;
		Panel panel_2;
		JPanel contLog;
		JTextArea pl1;
		JTextArea pl2;
		JTextArea log;
		Army atta ;
		Army defa ;
		private Player p;
		private Game f;
		
		
	public BattleView(Army a,Army d,Player c,Game s) {
		
		p=c;
		f=s;
		
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBackground(Color.DARK_GRAY);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setBackground(Color.RED);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.atta=a;
		this.defa=d;
		
		
		LogString = new ArrayList<String>();
		attacker = new ArrayList <JButton>();
		defender = new ArrayList <JButton>();

		x = new JLabel();
		x.setBounds(0, 0,1800, 1080);
		x.setIcon(new ImageIcon ("war2.jpg"));
		
		
		ImageIcon C = new ImageIcon("Cavalary.png");
		ImageIcon I = new ImageIcon("INFN.png");
		ImageIcon A = new ImageIcon("ARCH.png");
		
		
		AttackButton = new JButton();
		AttackButton.setText("Attack");
		ImageIcon X = new ImageIcon("Attack.png");
		AttackButton.setBounds(1180, 370, 400, 200);
		ImageIcon Attack = new ImageIcon(X.getImage().getScaledInstance(AttackButton.getWidth(), AttackButton.getHeight(), Image.SCALE_SMOOTH));
		AttackButton.setIcon(Attack);
		AttackButton.setToolTipText("Attack");
		AttackButton.setContentAreaFilled(false);
		AttackButton.setFocusable(false);
		AttackButton.addActionListener(this);
		
		AutoButton = new JButton("Auto Attack");
		ImageIcon T = new ImageIcon("Attacko.png");
		AutoButton.setBounds(1180, 630, 400, 181);
		ImageIcon AAttack = new ImageIcon(T.getImage().getScaledInstance(AutoButton.getWidth(), AutoButton.getHeight(), Image.SCALE_SMOOTH));
		AutoButton.setIcon(AAttack);
		AutoButton.setToolTipText("Auto Attack");
		AutoButton.setContentAreaFilled(false);
		AutoButton.addActionListener(this);
		
		
		
		
		panel_1 = new Panel();
		panel_1.setVisible(true);
		panel_1.setBounds(100, 26,1000, 420);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(new GridLayout());
		
		pl1 = new JTextArea();
		pl1.setVisible(true);
		pl1.setEditable(false);
		pl1.setBackground(Color.WHITE);
		pl1.setText("Player's Army: ");
		pl1.setFont(new Font("Tahoma", Font.BOLD, 12));
		pl1.setBounds(0,197,100 , 30);
		
		panel_2 = new Panel();
		panel_2.setVisible(true);
		panel_2.setBounds(100, 460, 1000, 400);
		panel_2.setBackground(Color.GRAY);
		panel_2.setLayout(new GridLayout());
		
		pl2 = new JTextArea();
		pl2.setVisible(true);
		pl2.setEditable(false);
		pl2.setBackground(Color.WHITE);
		pl2.setText("Defender's Army: ");
		pl2.setFont(new Font("Tahoma", Font.BOLD, 11));
		pl2.setBounds(0,597,100 , 30);
		
		

		log = new JTextArea();
		log.setVisible(true);
		log.setEditable(false);
		log.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
		log.setText("Log of the Battle:\n");
		log.setBackground(Color.WHITE);
		log.setBounds(1110, 26,350 , 330);
		JScrollPane sp = new JScrollPane(log,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setVisible(true);
		frame.add(sp);
		
		contLog = new JPanel();
		contLog.setVisible(true);
		contLog.setBounds(1180, 26,350 , 330);
		contLog.setBackground(Color.WHITE);
		contLog.setLayout(new BorderLayout(0,0));
		contLog.add(log,BorderLayout.CENTER);
		
		
		fillPanel(a, d);
		
 
		
		
		frame.add(panel_1);
		frame.add(panel_2);
		frame.add(contLog);
		frame.add(pl1);
		frame.add(pl2);
		frame.add(log);
		frame.add(AutoButton);
		frame.add(AttackButton);
		frame.add(x);
		
		frame.revalidate();
	    frame.repaint();
		
		
	}
	
	
	public void fillPanel(Army a, Army d ) {
		
		ImageIcon C = new ImageIcon("Cavalary.png");
		ImageIcon I = new ImageIcon("INFN.png");
		ImageIcon A = new ImageIcon("ARCH.png");
		
		
		if(atta.getUnits().isEmpty() || defa.getUnits().isEmpty())
		{
			if(atta.getUnits().isEmpty())
				JOptionPane.showMessageDialog(null, "You LOST!!");
			if( defa.getUnits().isEmpty())
				JOptionPane.showMessageDialog(null, "You WON!!");
		}
		else
		{
		
		for(int i =0; i<a.getUnits().size();i++) 
		{   
		a.getUnits().get(i).setParentArmy(a);
			if(a.getUnits().get(i) instanceof Archer) {
				JButton Arch =new JButton();
				Arch.setBackground(Color.BLUE);
				Arch.setVisible(true);
				Arch.setBounds(0, 0, 250, 250);
				ImageIcon Archrr =new ImageIcon(A.getImage().getScaledInstance(Arch.getWidth(), Arch.getHeight(), Image.SCALE_SMOOTH));
				Arch.setIcon(Archrr);
				Arch.setToolTipText("Archer:\n"+"Level:"+a.getUnits().get(i).getLevel()+"\n "+"currentSoldierCount:"+a.getUnits().get(i).getCurrentSoldierCount());
				panel_1.add(Arch);
				Arch.addActionListener(this);
				attacker.add(Arch);
				
			}
			else {
				if(a.getUnits().get(i) instanceof Infantry) {
				JButton Inf =new JButton();
				Inf.setVisible(true);
				Inf.setBounds(0, 0, 300, 430);
				ImageIcon Infantry =new ImageIcon(I.getImage().getScaledInstance(Inf.getWidth(), Inf.getHeight(), Image.SCALE_SMOOTH));
				Inf.setIcon(Infantry);
				Inf.setBackground(Color.MAGENTA);
				Inf.setToolTipText("Infantry:\n"+"Level"+a.getUnits().get(i).getLevel()+"\n "+"currentSoldierCount:"+a.getUnits().get(i).getCurrentSoldierCount());
				panel_1.add(Inf);
				Inf.addActionListener(this);
				attacker.add(Inf);	
				}
				else {
					if(a.getUnits().get(i) instanceof Cavalry) {
						JButton Cal =new JButton();
						Cal.setVisible(true);
						Cal.setBounds(0, 0, 300, 200);
						ImageIcon Cava =new ImageIcon(C.getImage().getScaledInstance(Cal.getWidth(), Cal.getHeight(), Image.SCALE_SMOOTH));
						Cal.setIcon(Cava);
						Cal.setToolTipText("Cavalry:\n"+"Level"+a.getUnits().get(i).getLevel()+"\n "+"currentSoldierCount:"+a.getUnits().get(i).getCurrentSoldierCount());
						panel_1.add(Cal);
						Cal.addActionListener(this);
						attacker.add(Cal);
					}
				}
		}
	}
	
		if(atta.getUnits().isEmpty() || defa.getUnits().isEmpty())
		{
			if(atta.getUnits().isEmpty())
				JOptionPane.showMessageDialog(null, "You LOST!!");
			if( defa.getUnits().isEmpty())
				JOptionPane.showMessageDialog(null, "You WON!!");
		}
		else
		{
			
	for(int i =0; i<d.getUnits().size();i++) 
		{  
		d.getUnits().get(i).setParentArmy(d);
			if(d.getUnits().get(i) instanceof Archer) {
				JButton Archd =new JButton();
				Archd.setVisible(true);
				Archd.setBackground(Color.BLUE);
				Archd.setBounds(0, 0, 250, 250);
				ImageIcon Archrr =new ImageIcon(A.getImage().getScaledInstance(Archd.getWidth(), Archd.getHeight(), Image.SCALE_SMOOTH));
				Archd.setIcon(Archrr);
				Archd.setToolTipText("Archer:\n"+"Level:"+d.getUnits().get(i).getLevel()+"\n "+"currentSoldierCount:"+d.getUnits().get(i).getCurrentSoldierCount());
				panel_2.add(Archd);
				Archd.addActionListener(this);
				defender.add(Archd);
			}
			else {
				if(d.getUnits().get(i) instanceof Infantry) {
					JButton Infd =new JButton();
					Infd.setVisible(true);
					Infd.setBackground(Color.MAGENTA);
					Infd.setBounds(0, 0, 300, 430);
					ImageIcon Infantry =new ImageIcon(I.getImage().getScaledInstance(Infd.getWidth(), Infd.getHeight(), Image.SCALE_SMOOTH));
					Infd.setIcon(Infantry);
					Infd.setToolTipText("Infantry:\n"+"Level:"+d.getUnits().get(i).getLevel()+"\n"+"currentSoldierCount:"+d.getUnits().get(i).getCurrentSoldierCount());
					panel_2.add(Infd);
					Infd.addActionListener(this);
					defender.add(Infd);	
				}
				else {
					if(d.getUnits().get(i) instanceof Cavalry) {
					JButton Cald =new JButton();
					Cald.setVisible(true);
					Cald.setBounds(0, 0, 300, 200);
					ImageIcon Cava =new ImageIcon(C.getImage().getScaledInstance(Cald.getWidth(), Cald.getHeight(), Image.SCALE_SMOOTH));
					Cald.setIcon(Cava);
					Cald.setToolTipText("Cavalry:\n"+"Level:"+d.getUnits().get(i).getLevel()+"\n"+"currentSoldierCount:"+d.getUnits().get(i).getCurrentSoldierCount());
					panel_2.add(Cald);
					Cald.addActionListener(this);
					defender.add(Cald);
							}
						}
					}
				}
			}
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i =0;i<attacker.size();i++)
		{
			if(e.getSource()==attacker.get(i)) 
			{
				AttackerNo=i;
				UpdateLog(" You Have Chosen an Attacker");
				
			}
		}
		
		for(int i =0;i<defender.size();i++)
		{
			if(e.getSource()==defender.get(i)) 
			{
				DefenderNo=i;
				UpdateLog(" You Have Chosen an Defender");
			}
		}
		
		if(e.getSource()==AttackButton)
		{	
			
			
			if(atta.getUnits().isEmpty() || defa.getUnits().isEmpty())
			{
				if(atta.getUnits().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "You LOST!!");
					new WorldMapView(f,p);
				}
				if( defa.getUnits().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "You WON!!");
					new WorldMapView(f,p);
				}
			}
			
			
		else 
		{
			try {
				atta.getUnits().get(AttackerNo).attack(defa.getUnits().get(DefenderNo));
				//UpdateLog("Attacker Soilder Count became :"+atta.getUnits().get(AttackerNo).getCurrentSoldierCount()+"");
				//UpdateLog("Defender Soilder Count became :"+defa.getUnits().get(DefenderNo).getCurrentSoldierCount()+"");
				
				
				
			} catch (FriendlyFireException e1) {
				
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			
			
			if(atta.getUnits().get(AttackerNo).getCurrentSoldierCount()==0) {
				attacker.get(AttackerNo).setEnabled(false);
			}
			
			new BattleView(atta, defa,p,f);
			frame.dispose();
			
			if(defa.getUnits().get(DefenderNo).getCurrentSoldierCount()==0) {
				defender.get(DefenderNo).setEnabled(false);
			}
			
			new BattleView(atta, defa,p,f);
			frame.dispose();
			
			if(atta.getUnits().isEmpty() || defa.getUnits().isEmpty())
			{
				if(atta.getUnits().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "You LOST!!");
					new WorldMapView(f,p);
				}
				if( defa.getUnits().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "You WON!!");
					new WorldMapView(f,p);
				}
			}
			else {
				
			try {
				int Z =(int) (Math.random() * atta.getUnits().size());
				int W =(int) (Math.random() * defa.getUnits().size());
				Unit X =atta.getUnits().get(Z);
				Unit Y = defa.getUnits().get(W);
				Y.attack(X);
				UpdateLog("Attacker Soilder Count became :"+X.getCurrentSoldierCount()+"");
				UpdateLog("Defender Soilder Count became :"+Y.getCurrentSoldierCount()+"");
				
				if(X.getCurrentSoldierCount()==0) {
					attacker.get(Z).setEnabled(false);
				}
				new BattleView(atta, defa,p,f);
				frame.dispose();
				
				if(Y.getCurrentSoldierCount()==0) {
					defender.get(W).setEnabled(false);
				}
				
				new BattleView(atta, defa,p,f);
				frame.dispose();
				
				if(atta.getUnits().isEmpty() || defa.getUnits().isEmpty())
				{
					if(atta.getUnits().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "You LOST!!");
						new WorldMapView(f,p);
					}
					if( defa.getUnits().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "You WON!!");
					    new WorldMapView(f,p);
				    }
				}
				
			} catch (FriendlyFireException e1) {
				
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
			}
			if(atta.getUnits().isEmpty() || defa.getUnits().isEmpty())
			{
				if(atta.getUnits().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "You LOST!!");
					new WorldMapView(f,p);
				}
				if( defa.getUnits().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "You WON!!");
					new WorldMapView(f,p);
				}
			}
		}
	}
	
	public void UpdateLog(String c) 
	{
		String LogText = "";
		LogText += "Log of the Battle:\n";
		LogText += "'''''\n";
		LogString.add(c);
		for (int i =0;i<LogString.size();i++) {
			LogText += "- " + LogString.get(i) + "\n";
		}
		LogText += "\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		log.setText(LogText);
		this.revalidate();
	    this.repaint();
	}
	
	
}

