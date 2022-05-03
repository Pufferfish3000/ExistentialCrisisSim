package crisis.model.event;

import java.util.ArrayList;

public class GameEvent 
{
	private String [] data;
	private int playerInput;
	public void GameEvent()
	{
		playerInput = -1;
	}
	
	/**
	 * displays event based on parameters and waits for player decision
	 * @param eventDescript
	 * @param eventChoices
	 * @param eventOutcomes
	 */
	public void displayGameEvent(String[] eventData)
	{
		data = eventData;
		//display event data
		switch(playerInput)
		{
			case 1:
				
				break;
			
			case 2:
				break;
			
			case 3:
				break;
				
			case 4:
				break;
				
			default:
				System.gc(); //runs garbage collector to prevent stack overflow error
				displayGameEvent(data);
				break;
		}
	}
}
