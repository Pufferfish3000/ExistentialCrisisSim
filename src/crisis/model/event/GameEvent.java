package crisis.model.event;

import java.util.ArrayList;

public class GameEvent 
{
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	public void GameEvent()
	{
	}
	
	/**
	 * displays event based on parameters
	 * @param eventDescript
	 * @param eventChoices
	 * @param eventOutcomes
	 */
	public void displayGameEvent(String[] eventData)
	{
		//display event descript and choices
		System.out.println(eventData[2]);
	}
}
