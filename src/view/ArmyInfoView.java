package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.City;
import engine.Game;
import engine.Player;
import units.Archer;
import units.Army;
import units.Infantry;
import units.Status;
import units.Unit;

public class ArmyInfoView extends JFrame{
	
	private Player p;
	private JFrame frame;
	private JPanel idleArmiesPanel;
	private JPanel marchingArmiesPanel;
	private JPanel besigingArmiesPanel;
	private JLabel idleArmies;
	private JLabel marchingArmies;
	private JLabel besigingArmies;
	private String idleArmiesString="";
	private JTextArea infoIdleArmies;
	private String marchingArmiesString="";
	private String besigingArmisString="";
	private JTextArea infoMarchingArmies;
	private JTextArea infoBesigingArmies;
	private Game b;
	private City target;
	
	public ArmyInfoView(Player x,Game y)
	{
		p=x;
		b=y;
		
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setBounds(70, 50, 1390, 800);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
	//	Army h=new Army(p.getControlledCities().get(0).getName());
	//	h.setCurrentStatus(Status.IDLE);
	//	h.setTarget("sparta");
	//	h.getUnits().add(new Archer(1, 60, 0.4, 0.5, 0.6));
	//	p.getControlledArmies().add(h);
		
		
		
		for(int i=0; i<p.getControlledArmies().size(); i++)
		{
			if(p.getControlledArmies().get(i).getCurrentStatus()==Status.IDLE)
			{
			   idleArmiesString=idleArmiesString+"Army"+(i+1)+""+":"+"\n";
			   for(int j=0; j<p.getControlledArmies().get(i).getUnits().size(); j++)
			  {
				Unit u=p.getControlledArmies().get(i).getUnits().get(j);
				if(u instanceof Archer)
				{
					idleArmiesString=idleArmiesString+"Archer"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";
				}
				else
				{
					if(u instanceof Infantry)
					{
						idleArmiesString=idleArmiesString+"Infantry"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";

					}
					else
					{
						idleArmiesString=idleArmiesString+"Cavalry"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";

					}
				}
			  }
			
		    }
			else
			{
				if(p.getControlledArmies().get(i).getCurrentStatus()==Status.MARCHING)
				{
					marchingArmiesString=marchingArmiesString+"Army"+(i+1)+""+":"+" "+"\n"+"Targeted City:"+p.getControlledArmies().get(i).getTarget()+" "+"Turns Left To Reach Targeted City:"+p.getControlledArmies().get(i).getDistancetoTarget()+""+"\n";
					 for(int j=0; j<p.getControlledArmies().get(i).getUnits().size(); j++)
					  {
						Unit u=p.getControlledArmies().get(i).getUnits().get(j);
						if(u instanceof Archer)
						{
							marchingArmiesString=marchingArmiesString+"Archer"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";
						}
						else
						{
							if(u instanceof Infantry)
							{
								marchingArmiesString=marchingArmiesString+"Infantry"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";

							}
							else
							{
								marchingArmiesString=marchingArmiesString+"Cavalry"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";

							}
						}
					  }
				}
				else
				{
					for(int z=0; z<b.getAvailableCities().size(); z++)
					{
						if(b.getAvailableCities().get(z).getName().toLowerCase().equals(p.getControlledArmies().get(i).getTarget().toLowerCase()))
						{
							target=b.getAvailableCities().get(z);
						}
					}
					besigingArmisString=besigingArmisString+"Army"+(i+1)+""+":"+" "+"\n"+"Besiging City:"+p.getControlledArmies().get(i).getTarget()+" "+"Turns Under Seige:"+target.getTurnsUnderSiege()+""+"\n";
					 for(int j=0; j<p.getControlledArmies().get(i).getUnits().size(); j++)
					  {
						Unit u=p.getControlledArmies().get(i).getUnits().get(j);
						if(u instanceof Archer)
						{
							besigingArmisString=besigingArmisString+"Archer"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";
						}
						else
						{
							if(u instanceof Infantry)
							{
								besigingArmisString=besigingArmisString+"Infantry"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";

							}
							else
							{
								besigingArmisString=besigingArmisString+"Cavalry"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";

							}
						}
					  }
				}
			}
		}
		
		
		infoMarchingArmies=new JTextArea(marchingArmiesString);
		infoMarchingArmies.setBounds(0, 100, 460, 800);
		infoMarchingArmies.setVisible(true);
		infoMarchingArmies.setEditable(false);
		infoMarchingArmies.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		infoMarchingArmies.setForeground(Color.WHITE);
		infoMarchingArmies.setBackground(Color.BLACK);
		
		
		
		
		
		infoIdleArmies=new JTextArea(idleArmiesString);
		infoIdleArmies.setBounds(0, 100, 460, 800);
		infoIdleArmies.setVisible(true);
		infoIdleArmies.setEditable(false);
		infoIdleArmies.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		infoIdleArmies.setForeground(Color.WHITE);
		infoIdleArmies.setBackground(Color.BLACK);
		
		
		
		infoBesigingArmies=new JTextArea(besigingArmisString);
		infoBesigingArmies.setBounds(0, 100, 460, 800);
		infoBesigingArmies.setVisible(true);
		infoBesigingArmies.setEditable(false);
		infoBesigingArmies.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		infoBesigingArmies.setForeground(Color.WHITE);
		infoBesigingArmies.setBackground(Color.BLACK);
		
		
		
		
		idleArmies=new JLabel("Idle Armies");
		idleArmies.setBounds(155, 0, 160, 50);
		idleArmies.setVisible(true);
		idleArmies.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		idleArmies.setForeground(Color.WHITE);
		
		
		
		marchingArmies=new JLabel("Marching Armies");
		marchingArmies.setBounds(135, 0, 180, 50);
		marchingArmies.setVisible(true);
		marchingArmies.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		marchingArmies.setForeground(Color.WHITE);
		
		
		
		besigingArmies=new JLabel("Besiging Armies");
		besigingArmies.setBounds(145, 0, 180, 50);
		besigingArmies.setVisible(true);
		besigingArmies.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		besigingArmies.setForeground(Color.WHITE);
		
		
		
		
		besigingArmiesPanel=new JPanel();
		besigingArmiesPanel.setBounds(930, 0, 460, 800);
		besigingArmiesPanel.setVisible(true);
		besigingArmiesPanel.setLayout(null);
		besigingArmiesPanel.setOpaque(true);
		besigingArmiesPanel.setFocusable(false);
		besigingArmiesPanel.setBackground(Color.BLACK);
		
		
		
		marchingArmiesPanel=new JPanel();
		marchingArmiesPanel.setBounds(465, 0, 460, 800);
		marchingArmiesPanel.setVisible(true);
		marchingArmiesPanel.setLayout(null);
		marchingArmiesPanel.setOpaque(true);
		marchingArmiesPanel.setFocusable(false);
		marchingArmiesPanel.setBackground(Color.BLACK);
		
		
		
		
		
		idleArmiesPanel=new JPanel();
		idleArmiesPanel.setBounds(0, 0, 460, 800);
		idleArmiesPanel.setVisible(true);
		idleArmiesPanel.setLayout(null);
		idleArmiesPanel.setOpaque(true);
		idleArmiesPanel.setFocusable(false);
		idleArmiesPanel.setBackground(Color.BLACK);
		
		
		
		
		idleArmiesPanel.add(idleArmies);
		idleArmiesPanel.add(infoIdleArmies);
		marchingArmiesPanel.add(marchingArmies);
		marchingArmiesPanel.add(infoMarchingArmies);
		besigingArmiesPanel.add(besigingArmies);
		besigingArmiesPanel.add(infoBesigingArmies);
		frame.add(besigingArmiesPanel);
		frame.add(marchingArmiesPanel);
		frame.add(idleArmiesPanel);
		
		
		frame.revalidate();
		frame.repaint();
	}

}
