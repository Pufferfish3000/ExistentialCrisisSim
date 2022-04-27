package crisis.controller;
import crisis.view.Frame;

public class Controller 
{
	private Frame crisisFrame;
	
	public Controller()
	{
		this.crisisFrame = new Frame(this);
	}
}
