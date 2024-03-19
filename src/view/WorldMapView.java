package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.City;
import engine.Game;
import engine.Player;
import units.Army;
import units.Status;



public class WorldMapView extends JFrame implements ActionListener{
	
	private JFrame frame;
	private String infoPlayerString="";
	private JLabel infoName;
	private String infoGoldString="";
	private JLabel infoGold;
	private String infoFoodString="";
	private JLabel infoFood;
	private String infoTurnCountString="";
	private JLabel infoTurnCount;
	private JButton endTurn;
	private JButton mapView;
	private JButton armyinfo;
	private JButton cairo;
	private JButton sparta;
	private JButton rome;
	private JLabel image;
	private Game f;
	private Player z;
	private JPanel noChange;
	private Army h=null;
	private City m=null;
	private City c=null;
	private JButton targetCity;
	
	
	public WorldMapView(Game x, Player y)
	{
		f=x;
		z=y;
		
		
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setExtendedState(this.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		
		
		image=new JLabel();
		image.setIcon(new ImageIcon("Map View.jpg"));
		image.setBounds(0, 0, 1610, 1000);
		
		
		
		targetCity=new JButton("To TargetCity");
		targetCity.setFocusable(false);
		targetCity.setFont(new Font(Font.MONOSPACED,Font.BOLD,13));
		targetCity.setBounds(1370, 20, 150, 20);
        targetCity.addActionListener(this);
		
		
		
		
		cairo=new JButton("Cairo");
		cairo.setFocusable(false);
		cairo.setBounds(1000, 200, 200, 60);
		cairo.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
		cairo.addActionListener(this);
		
		
		
		
		
		rome=new JButton("Rome");
		rome.setFocusable(false);
		rome.setBounds(500, 550, 200, 60);
		rome.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
		rome.addActionListener(this);
		
		
		
		sparta=new JButton("Sparta");
		sparta.setFocusable(false);
		sparta.setBounds(250, 260, 200, 60);
		sparta.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
		sparta.addActionListener(this);

		
		
		
		armyinfo=new JButton("Army Info");
		armyinfo.setBounds(1120, 20, 110, 20);
		armyinfo.setFocusable(false);
		armyinfo.setFont(new Font(Font.MONOSPACED,Font.BOLD,13));
		armyinfo.addActionListener(this);
		
		
		
		endTurn=new JButton("End Turn");
		endTurn.setBounds(1250, 20, 100, 20);
		endTurn.setFocusable(false);
		endTurn.setFont(new Font(Font.MONOSPACED,Font.BOLD,13));
		endTurn.addActionListener(this);
		
		
		
		mapView=new JButton("Map View");
		mapView.setBounds(1000, 20, 100, 20);
		mapView.setFocusable(false);
		mapView.setFont(new Font(Font.MONOSPACED,Font.BOLD,13));
		mapView.addActionListener(this);
		
		
		
		
		
		infoTurnCountString="Turn Count:"+"  "+f.getCurrentTurnCount()+"";
		infoTurnCount=new JLabel(infoTurnCountString);
		infoTurnCount.setBounds(800, 0, 250, 50);
		infoTurnCount.setVisible(true);
		infoTurnCount.setFont(new Font(Font.MONOSPACED,Font.BOLD,19));
		infoTurnCount.setForeground(Color.WHITE);
		
		
		
		
		infoFoodString="Food:"+"  "+z.getFood()+"";
		infoFood=new JLabel(infoFoodString);
		infoFood.setBounds(570, 0, 200, 50);
		infoFood.setVisible(true);
		infoFood.setFont(new Font(Font.MONOSPACED,Font.BOLD,19));
		infoFood.setForeground(Color.WHITE);
		
		
		
		
		
		infoGoldString="Gold:"+"  "+z.getTreasury()+"";
		infoGold=new JLabel(infoGoldString);
		infoGold.setBounds(320, 0, 200, 50);
		infoGold.setVisible(true);
		infoGold.setFont(new Font(Font.MONOSPACED,Font.BOLD,19));
		infoGold.setForeground(Color.WHITE);
		
		
		
		
		
		
		infoPlayerString="Name:"+" "+z.getName();
		infoName=new JLabel(infoPlayerString);
		infoName.setBounds(20, 0, 300, 50);
		infoName.setVisible(true);
		infoName.setFont(new Font(Font.MONOSPACED,Font.BOLD,19));
		infoName.setForeground(Color.WHITE);
		

		
		
		
		
		noChange=new JPanel();
		noChange.setBounds(0, 0, 1700, 50);
		noChange.setFocusable(false);
		noChange.setOpaque(false);
		noChange.setBackground(Color.BLACK);
		noChange.setVisible(true);
		noChange.setLayout(null);
		
		
		
		noChange.add(armyinfo);
		noChange.add(endTurn);
		noChange.add(mapView);
		noChange.add(infoTurnCount);
		noChange.add(infoFood);
		noChange.add(infoGold);
		noChange.add(infoName);
		frame.add(targetCity);
		frame.add(sparta);
		frame.add(rome);
		frame.add(cairo);
		frame.add(noChange);
		frame.add(image);

		
		
		
		
		
		frame.revalidate();
		frame.repaint();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==endTurn)
		{

			for(int i=0; i<z.getControlledArmies().size(); i++)
			{
				if(z.getControlledArmies().get(i).getDistancetoTarget()==1)
				{
				    h=z.getControlledArmies().get(i);
				}
			}
			for(int i=0; i<f.getAvailableCities().size(); i++)
			{
				if(f.getAvailableCities().get(i).getTurnsUnderSiege()==2)
				{
					m=f.getAvailableCities().get(i);
				}
			}
			for(int i=0; i<f.getAvailableCities().size(); i++)
			{
				if(f.getAvailableCities().get(i).isUnderSiege())
				{
					c=f.getAvailableCities().get(i);
				}
			}
			
			if(m!=null)
			{
				for(int i=0; i<z.getControlledArmies().size(); i++)
				{
					if(z.getControlledArmies().get(i).getCurrentStatus()==Status.BESIEGING && z.getControlledArmies().get(i).getCurrentLocation().toLowerCase().equals(m.getName().toLowerCase()))
					{
						Army x=z.getControlledArmies().get(i);
						Army y=m.getDefendingArmy();
						f.endTurn();
						if(f.isGameOver())
						{
							new GameOver(z,f);
						}
						else
						{
							 new MakeADecisionView(x,y,z,f);
						}
						
					}
				}
			}
			else
			{
				if(h!=null)
				{
					for(int i=0; i<f.getAvailableCities().size(); i++)
					{
						if(h.getTarget().toLowerCase().equals(f.getAvailableCities().get(i).getName().toLowerCase()))
						{
							f.endTurn();
							if(f.isGameOver())
							{
								new GameOver(z,f);
							}
							else
							{
							    new ChoiceView(h,f.getAvailableCities().get(i),z,f);
							}
						
						}
					}
					
					
				}
				else
				{
					if(c!=null)
					{
						for(int i=0; i<z.getControlledArmies().size(); i++)
						{
							if(z.getControlledArmies().get(i).getCurrentStatus()==Status.BESIEGING && z.getControlledArmies().get(i).getCurrentLocation().toLowerCase().equals(c.getName().toLowerCase()))
							{
								Army x=z.getControlledArmies().get(i);
								Army y=c.getDefendingArmy();
								f.endTurn();
								if(f.isGameOver())
								{
									new GameOver(z,f);
								}
								else
								{
								    new ChooseView(x,y,z,f);
								}
								
							}
						}
					}
					else
					{
						f.endTurn();
						if(f.isGameOver())
						{
							new GameOver(z,f);
						}
						else
						{
							new WorldMapView(f,z);							
						}
					}
					
				}
				
			
			
		}
		}
		else
		{
			if(e.getSource()==mapView)
			{
				frame.setVisible(false);
				new WorldMapView(f,z);
			}
			else
			{
				if(e.getSource()==armyinfo)
				{
					new ArmyInfoView(z,f);
				}
				else
				{
					if(e.getSource()==cairo)
					{
						for(int i=0; i<z.getControlledCities().size(); i++)
						{
							if(z.getControlledCities().get(i).getName().toLowerCase().equals(cairo.getText().toLowerCase()))
							{
								new CairoView(z.getControlledCities().get(i),f);
							}
						}
						
					}
					else
					{
						if(e.getSource()==sparta)
						{
							for(int i=0; i<z.getControlledCities().size(); i++)
							{
								if(z.getControlledCities().get(i).getName().toLowerCase().equals(sparta.getText().toLowerCase()))
								{
									new SpartaView(z.getControlledCities().get(i),f);
								}
							}
						}
						else
						{
							if(e.getSource()==rome)
							{
								for(int i=0; i<z.getControlledCities().size(); i++)
								{
									if(z.getControlledCities().get(i).getName().toLowerCase().equals(rome.getText().toLowerCase()))
									{
										new RomeView(z.getControlledCities().get(i),f);
									}
								}
							}
							else
							{
								if(e.getSource()==targetCity)
								{
									 new TargetCityView(z,f);
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	
	

	
	

}
