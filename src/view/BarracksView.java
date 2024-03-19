package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import buildings.Barracks;
import engine.City;
import engine.Game;
import engine.Player;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;

public class BarracksView extends JFrame implements ActionListener{
	
	
	private City v;
	private JFrame frame;
	private Game f;
	private Player p;
	private JLabel image;
	private JLabel buildingName;
	private JLabel buildingLevel;
	private String nameInfo;
	private String levelInfo="";
	private Barracks b=null;
	private JButton build;
	private JButton upgrade;
	private JButton recruit;
	private String upgradeInfo="";
	private String recruitInfo="";
	
	
	
	public BarracksView(City x,Game s)
	{
		v=x;
		f=s;
		p=s.getPlayer();
		
		
		for(int i=0; i<v.getMilitaryBuildings().size(); i++)
		{
			if(v.getMilitaryBuildings().get(i) instanceof Barracks)
			{
				b=(Barracks)v.getMilitaryBuildings().get(i);
			}
		}
		
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setBounds(400, 200, 750, 500);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		
		image=new JLabel();
		image.setIcon(new ImageIcon("BarracksFinal.png"));
		image.setBounds(0, 0, 750, 500);
		
		
		
		build=new JButton("Build");
		build.setBounds(20, 400, 150, 40);
		build.setFocusable(false);
		build.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		build.setBackground(Color.GREEN);
		build.addActionListener(this);
		
		
		
		if(b==null)
		{
			levelInfo="Level: "+"null";
			upgradeInfo="Upgrade: "+"null";
			recruitInfo="Recruit: "+"null";
		}
		else
		{
			levelInfo="Level: "+b.getLevel()+"";
			upgradeInfo="Upgrade: "+b.getUpgradeCost()+"";
			recruitInfo="Recruit: "+b.getRecruitmentCost()+"";
		}
		
		
		upgrade=new JButton(upgradeInfo);
		upgrade.setBounds(300, 400, 150, 40);
		upgrade.setFocusable(false);
		upgrade.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		upgrade.setBackground(Color.GREEN);
		upgrade.addActionListener(this);
		
		
		
		recruit=new JButton(recruitInfo);
		recruit.setBounds(570, 400, 150, 40);
		recruit.setFocusable(false);
		recruit.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		recruit.setBackground(Color.GREEN);
		recruit.addActionListener(this);
		
		
		
		
		buildingLevel=new JLabel(levelInfo);
		buildingLevel.setBounds(400, 0, 200, 20);
		buildingLevel.setVisible(true);
		buildingLevel.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
		buildingLevel.setForeground(Color.WHITE);
		
		
		
		nameInfo="Building Type: Barracks";
		buildingName=new JLabel(nameInfo);
		buildingName.setBounds(20, 0, 300, 20);
		buildingName.setVisible(true);
		buildingName.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
		buildingName.setForeground(Color.WHITE);
		
		
		
		frame.add(recruit);
		frame.add(upgrade);
		frame.add(build);
		frame.add(buildingLevel);
		frame.add(buildingName);
		frame.add(image);
		
		
		
		
		frame.revalidate();
		frame.repaint();
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==build)
		{
			try {
				p.build("Barracks", v.getName());
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(null, "You Don't Have Enough Gold");
			}
			if(v.getName().toLowerCase().equals("cairo"))
			{
				new CairoView(v,f);
			}
			else
			{
				if(v.getName().toLowerCase().equals("sparta"))
				{
					new SpartaView(v,f);
				}
				else
				{
					 new RomeView(v,f);
				}
			}
		}
		else
		{
			if(e.getSource()==upgrade)
			{
				if(!b.equals(null))
				{
					
				try {
					
						p.upgradeBuilding(b);
					
					} catch (NotEnoughGoldException e1) {
						JOptionPane.showMessageDialog(null, "You Don't Have Enough Gold");
					} catch (BuildingInCoolDownException e1) {
						JOptionPane.showMessageDialog(null, "Building is Cooling Down");
					} catch (MaxLevelException e1) {
						JOptionPane.showMessageDialog(null, "Maximum level reached!!");
					}
				if(v.getName().toLowerCase().equals("cairo"))
				{
					new CairoView(v,f);
				}
				else
				{
					if(v.getName().toLowerCase().equals("sparta"))
					{
						new SpartaView(v,f);
					}
					else
					{
						 new RomeView(v,f);
					}
				}
				}
			}
			else
			{
				if(!b.equals(null))
				{
					try {
						p.recruitUnit("Infantry", v.getName());
					} catch (BuildingInCoolDownException e1) {
						JOptionPane.showMessageDialog(null, "Building is Cooling Down");
					} catch (MaxRecruitedException e1) {
						JOptionPane.showMessageDialog(null, "Maximum level reached!!");
					} catch (NotEnoughGoldException e1) {
						JOptionPane.showMessageDialog(null, "You Don't Have Enough Gold");
					}
					if(v.getName().toLowerCase().equals("cairo"))
					{
						new CairoView(v,f);
					}
					else
					{
						if(v.getName().toLowerCase().equals("sparta"))
						{
							new SpartaView(v,f);
						}
						else
						{
							 new RomeView(v,f);
						}
					}
				}
			}
		}
		
	}

}
