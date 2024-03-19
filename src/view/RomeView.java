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

public class RomeView extends JFrame implements ActionListener{
	
	private City v;
	private Game f;
	private JFrame frame;
	private JLabel image;
	private JPanel noChange;
	private String infoPlayerString="";
	private JLabel infoName;
	private String infoGoldString="";
	private JLabel infoGold;
	private String infoFoodString="";
	private JLabel infoFood;
	private String infoTurnCountString="";
	private JLabel infoTurnCount;
	private Player z;
	private JButton archeryRange;
	private JButton barracks;
	private JButton stable;
	private JButton farm;
	private JButton market;
	private JButton endTurn;
	private JButton mapView;
	private JButton cityArmy;
	private JButton initiateArmy;
	private JButton relocateUnit;
	private Army h=null;
	private City m=null;
	private City c=null;
	
	
	public RomeView(City c,Game s)
	{
		v=c;
		f=s;
		z=s.getPlayer();
		
		
		
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setExtendedState(this.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		
		
		
		image=new JLabel();
		image.setIcon(new ImageIcon("Rome Final.jpg"));
		image.setBounds(0, 0, 1920, 1000);
		
		
		
		
		archeryRange=new JButton("Archery Range");
		archeryRange.setBounds(690, 550, 250, 40);
		archeryRange.setFocusable(false);
		archeryRange.setFont(new Font(Font.MONOSPACED,Font.BOLD,17));
		archeryRange.addActionListener(this);
		
		
		
		barracks=new JButton("Barracks");
		barracks.setBounds(470, 250, 250, 40);
		barracks.setFocusable(false);
		barracks.setFont(new Font(Font.MONOSPACED,Font.BOLD,17));
		barracks.addActionListener(this);

		
		
		
		farm=new JButton("Farm");
		farm.setBounds(300, 570, 250, 40);
		farm.setFocusable(false);
		farm.setFont(new Font(Font.MONOSPACED,Font.BOLD,17));
		farm.addActionListener(this);

		
		
		
		
		stable=new JButton("Stable");
		stable.setBounds(100, 400, 250, 40);
		stable.setFocusable(false);
		stable.setFont(new Font(Font.MONOSPACED,Font.BOLD,17));
		stable.addActionListener(this);

		
		
		
		
		market=new JButton("Market");
		market.setBounds(150, 200, 250, 40);
		market.setFocusable(false);
		market.setFont(new Font(Font.MONOSPACED,Font.BOLD,17));
		market.addActionListener(this);

		
		
		
		
		endTurn=new JButton("End Turn");
		endTurn.setBounds(1350, 20, 100, 20);
		endTurn.setFocusable(false);
		endTurn.setFont(new Font(Font.MONOSPACED,Font.BOLD,13));
		endTurn.addActionListener(this);
		
		
		
		mapView=new JButton("Map View");
		mapView.setBounds(1050, 20, 100, 20);
		mapView.setFocusable(false);
		mapView.setFont(new Font(Font.MONOSPACED,Font.BOLD,13));
		mapView.addActionListener(this);
		
		
		
		
		cityArmy=new JButton("City's Army");
		cityArmy.setBounds(1190, 20, 130, 20);
		cityArmy.setFocusable(false);
		cityArmy.setFont(new Font(Font.MONOSPACED,Font.BOLD,13));
		cityArmy.addActionListener(this);
		
		
		
		initiateArmy=new JButton("Initiate Army");
		initiateArmy.setBounds(1300, 600, 200, 60);
		initiateArmy.setFocusable(false);
		initiateArmy.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
		initiateArmy.addActionListener(this);
		
		
		
		
		relocateUnit=new JButton("Relocate Unit");
		relocateUnit.setBounds(1300, 700, 200, 60);
		relocateUnit.setFocusable(false);
		relocateUnit.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
		relocateUnit.addActionListener(this);
	
		
		
		
		
		
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
		
		
		noChange.add(infoTurnCount);
		noChange.add(infoFood);
		noChange.add(infoGold);
		noChange.add(infoName);
		noChange.add(endTurn);
		noChange.add(mapView);
		frame.add(relocateUnit);
		frame.add(initiateArmy);
		frame.add(cityArmy);
		frame.add(stable);
		frame.add(market);
		frame.add(farm);
		frame.add(barracks);
		frame.add(archeryRange);
		frame.add(noChange);
		frame.add(image);
		
		
		
		
		
		
		
		frame.revalidate();
		frame.repaint();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==archeryRange)
		{
			new ArcheryRangeView(v,f);
		}
		else
		{
			if(e.getSource()==barracks)
			{
				new BarracksView(v,f);
			}
			else
			{
				if(e.getSource()==stable)
				{
					new StableView(v,f);
				}
				else
				{
					if(e.getSource()==farm)
					{
						 new FarmView(v,f);
					}
					else
					{
						if(e.getSource()==market)
						{
							 new MarketView(v,f);
						}
						else
						{
							if(e.getSource()==mapView)
							{
								new WorldMapView(f,z);
							}
							else
							{
								if(e.getSource()==cityArmy)
								{
									new CityArmyInfo(v,f);
								}
								else
								{
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
											if((z.getControlledArmies().get(i).getCurrentStatus()==Status.BESIEGING) && z.getControlledArmies().get(i).getCurrentLocation().toLowerCase().equals(m.getName().toLowerCase()))
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
													if((z.getControlledArmies().get(i).getCurrentStatus()==Status.BESIEGING) && z.getControlledArmies().get(i).getCurrentLocation().toLowerCase().equals(c.getName().toLowerCase()))
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
													new RomeView(v,f);
													
												}
											}
											
										}
										
									}
									
									
									
									
								}
									else
									{
										if(e.getSource()==initiateArmy)
										{
											 new InitiateArmyView(v,f);
										}
										else
										{
											 new RelocateUnitView(v,f);
										}
									}
								}
							}
							
							
							
							
						}
					}
				}
			}
		
		
	}
	}

}
