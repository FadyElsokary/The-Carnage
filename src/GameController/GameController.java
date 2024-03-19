package GameController;

import engine.Game;
import engine.Player;
import view.StartGameView;

public class GameController {
	
	private Game playerGame;
	private Player player;
	
	public GameController()
	{
			new StartGameView(playerGame,player);
	}
	
	public static void main(String[] args)
	{
		new GameController();
	}

}
