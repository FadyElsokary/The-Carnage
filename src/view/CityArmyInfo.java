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
import units.Infantry;
import units.Status;
import units.Unit;

public class CityArmyInfo extends JFrame{
	
	private Player p;
	private City v;
	private Game f;
	private JFrame frame;
	private String idleArmiesString="";
	private JTextArea infoIdleArmies;
	private JLabel idleArmies;
	private JPanel idleArmiesPanel;
	private JPanel cityArmyPanel;
	private JTextArea infoCityArmy;
	private JLabel cityArmyLabel;
	private String infoCityArmyString="";


	
	
	
	
	public CityArmyInfo(City x,Game s)
	{
		v=x;
		f=s;
		p=s.getPlayer();
		
		
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setBounds(275, 50, 925, 800);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		
		for(int i=0; i<p.getControlledArmies().size(); i++)
		{
			if((p.getControlledArmies().get(i).getCurrentStatus()==Status.IDLE) && (p.getControlledArmies().get(i).getCurrentLocation().equals(v.getName())))
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
		}
		
		
		
		for(int i=0; i<v.getDefendingArmy().getUnits().size(); i++)
		{
			Unit u=v.getDefendingArmy().getUnits().get(i);
			if(u instanceof Archer)
			{
				infoCityArmyString=infoCityArmyString+"Unit: "+(i+1)+""+"\n"+"Archer"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";
			}
			else
			{
				if(u instanceof Infantry)
				{
					infoCityArmyString=infoCityArmyString+"Unit: "+(i+1)+""+"\n"+"Infantry"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";

				}
				else
				{
					infoCityArmyString=infoCityArmyString+"Unit: "+(i+1)+""+"\n"+"Cavalry"+" "+"Level:"+u.getLevel()+""+" "+"Current Soldier Count:"+u.getCurrentSoldierCount()+""+" "+"Max Soldier Count:"+u.getMaxSoldierCount()+""+"\n";

				}
			}
		}
		
		
		
		
		infoCityArmy=new JTextArea(infoCityArmyString);
		infoCityArmy.setBounds(0, 100, 460, 800);
		infoCityArmy.setVisible(true);
		infoCityArmy.setEditable(false);
		infoCityArmy.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		infoCityArmy.setForeground(Color.WHITE);
		infoCityArmy.setBackground(Color.BLACK);
		
		
		
		
		
		cityArmyLabel=new JLabel("City Defending Army");
		cityArmyLabel.setBounds(110, 0, 300, 50);
		cityArmyLabel.setVisible(true);
		cityArmyLabel.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		cityArmyLabel.setForeground(Color.WHITE);
		
		
		
		
		
		infoIdleArmies=new JTextArea(idleArmiesString);
		infoIdleArmies.setBounds(0, 100, 460, 800);
		infoIdleArmies.setVisible(true);
		infoIdleArmies.setEditable(false);
		infoIdleArmies.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		infoIdleArmies.setForeground(Color.WHITE);
		infoIdleArmies.setBackground(Color.BLACK);
		
		
		
		
		idleArmies=new JLabel("Idle Armies In City");
		idleArmies.setBounds(125, 0, 260, 50);
		idleArmies.setVisible(true);
		idleArmies.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		idleArmies.setForeground(Color.WHITE);
		
		
		
		idleArmiesPanel=new JPanel();
		idleArmiesPanel.setBounds(465, 0, 460, 800);
		idleArmiesPanel.setVisible(true);
		idleArmiesPanel.setLayout(null);
		idleArmiesPanel.setOpaque(true);
		idleArmiesPanel.setFocusable(false);
		idleArmiesPanel.setBackground(Color.BLACK);
		
		
		
		
		cityArmyPanel=new JPanel();
		cityArmyPanel.setBounds(0, 0, 460, 800);
		cityArmyPanel.setVisible(true);
		cityArmyPanel.setLayout(null);
		cityArmyPanel.setOpaque(true);
		cityArmyPanel.setFocusable(false);
		cityArmyPanel.setBackground(Color.BLACK);
		
		
		
		idleArmiesPanel.add(idleArmies);
		idleArmiesPanel.add(infoIdleArmies);
		cityArmyPanel.add(cityArmyLabel);
		cityArmyPanel.add(infoCityArmy);
		frame.add(idleArmiesPanel);
		frame.add(cityArmyPanel);
		
		
		
		
		frame.revalidate();
		frame.repaint();
		
	}
	
	

}
