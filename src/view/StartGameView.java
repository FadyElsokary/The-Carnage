package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import engine.Game;
import engine.Player;

public class StartGameView extends JFrame implements ActionListener{
	
	private JFrame frame;
	private JButton button1;
	private JLabel label;
	private JTextField name;
	private JLabel text;
	private JLabel title;
	private JComboBox<String> dropBox;
	private JLabel image;
	private Game g;
	private Player p;
	
	public StartGameView(Game f,Player s)
	{
		g=f;
		p=s;
		
		
		frame=new JFrame();
		frame.setTitle("The Carnage");
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		
		label=new JLabel("Choose One Of The Cities To Start With");
		label.setBounds(450, 500, 450, 50);
		label.setFocusable(false);
		label.setFont(new Font(Font.MONOSPACED,Font.BOLD,19));
		label.setForeground(Color.WHITE);
		frame.add(label);
		
		
		
		
		title=new JLabel();
		title.setText("The Carnage");
		title.setBounds(450, 70, 750, 100);
		title.setFocusable(false);
		title.setFont(new Font(Font.MONOSPACED,Font.ITALIC,90));
		title.setForeground(Color.WHITE);
		frame.add(title);
		
		
		name=new JTextField();
		name.setBounds(555, 400, 400, 50);
		name.setBackground(Color.WHITE);
		name.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
		name.setForeground(Color.DARK_GRAY);
		frame.add(name);
		
		
		
		text=new JLabel();
		text.setText("Write Your Name Here");
		text.setBounds(645, 350, 250, 25);
		text.setFocusable(false);
		text.setFont(new Font(Font.MONOSPACED,Font.BOLD,19));
		text.setForeground(Color.WHITE);
		frame.add(text);
		
		
		
		
		button1 = new JButton("Start Game");
		button1.setFocusable(false);
		button1.setBounds(700, 700, 100, 50);
		button1.addActionListener(this);
		frame.add(button1);
		
		
		String[] choices= {"Cairo","Rome","Sparta"};
	    dropBox=new JComboBox<String>(choices);
		dropBox.setBounds(900, 510, 100, 30);
		frame.add(dropBox);
		

		image=new JLabel();
		image.setIcon(new ImageIcon("Start 2 Final.png"));
		image.setBounds(0, 0, 1910, 1080);
		frame.add(image);
		
		

		frame.revalidate();
		frame.repaint();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1)
		{
			String x=name.getText();
			String y=(String) dropBox.getSelectedItem();
			try {
				if(!x.equals(""))
				{
					g=new Game(x,y);
					p=g.getPlayer();
					frame.setVisible(false);
					new WorldMapView(g,p);
				}
				
			} catch (IOException e1) {
				
			}
			
		}
		
	}
	
	

}
