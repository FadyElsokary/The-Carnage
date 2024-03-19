package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Game;
import engine.Player;

public class GameOver extends JFrame {
		JFrame frame;
		JPanel back;
		JLabel photo1;
		JLabel photo2;
		JLabel photo3;
		JTextArea GameO;
		private Player p;
		private Game f;
		
	public GameOver(Player c,Game s) {
		
		p=c;
		f=s;
		
		
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBackground(Color.DARK_GRAY);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		back = new JPanel();
		back.setVisible(true);
		back.setBounds(0, 0,1900, 1080);
		back.setBackground(Color.BLACK);
		back.setLayout(null);
		
		GameO = new JTextArea();
		GameO.setVisible(true);
		GameO.setEditable(false);
		GameO.setBackground(Color.WHITE);
		
		
		
		if(p.getControlledCities().containsAll(f.getAvailableCities()))
			{
			ImageIcon C = new ImageIcon("Victory.png");
		
			photo1 = new JLabel();
			photo1.setBounds(150,0,1800, 1080);
			photo1.setIcon(C);
			photo1.setBackground(Color.BLACK);
			
			GameO.setText("              GAME OVER !!! \n THANK YOU FOR PLAYING! ");
			GameO.setFont(new Font("Tahoma", Font.BOLD, 34));
			GameO.setBounds(550,700,490 , 110);
			
			frame.add(GameO);
			frame.add(photo1);
			
			frame.add(back);
			}
		else {
			ImageIcon L = new ImageIcon("failed us.png");
			ImageIcon LO = new ImageIcon("Defeat.png");
			
			photo2 = new JLabel();
			photo2.setBounds(0,50,1500, 540);
			photo2.setIcon(L);
			
			photo3 = new JLabel();
			photo3.setBounds(910,70,1500, 540);
			photo3.setIcon(LO);
			
			GameO.setText("              GAME OVER !!! \n THANK YOU FOR PLAYING! ");
			GameO.setFont(new Font("Tahoma", Font.BOLD, 34));
			GameO.setBounds(550,700,490 , 110);
			
			frame.add(photo2);
			frame.add(photo3);
			frame.add(GameO);
			frame.add(back);
			
		}
		
		
		frame.revalidate();
		frame.repaint();
		
		
	}
	
	
}
