package crisis.controller;
import crisis.view.Frame;
import crisis.model.ExistentialCrisis;

public class Controller 
{
	private Frame crisisFrame;
	private ExistentialCrisis game;
	
	public Controller()
	{
		this.game = new ExistentialCrisis();
		this.crisisFrame = new Frame(this);
	}
	
	public void start()
	{
		playGame();
	}
	
	public void playGame()
	{
		//if statement last thing executed in method
		if(game.isInsane())
		{
			endGame();
		}
		else
		{
			playGame();
		}
	}
	
	public void endGame()
	{
		
	}
}
