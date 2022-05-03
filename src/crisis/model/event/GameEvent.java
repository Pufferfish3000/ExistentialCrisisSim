package crisis.model.event;

import java.util.ArrayList;
import crisis.model.*;

public class GameEvent 
{
	private ExistentialCrisis game;
	private String [] data;
	private int playerInput;
	private int hungerValue;
	private int sleepValue;
	private int sanityValue;
	
	public void GameEvent()
	{
		this.hungerValue = game.getHunger();
		this.sleepValue = game.getSleep();
		this.sanityValue = game.getSanity();
		this.playerInput = -1;
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
		//display data[0]
		//button 1 = data[1]
		switch(playerInput)
		{
			case 1:
				//display data[5]
				sanityValue = (sanityValue + (Integer.parseInt(data[6])));
				sleepValue = (sleepValue + (Integer.parseInt(data[7])));
				hungerValue = (hungerValue + (Integer.parseInt(data[8])));
				updateData(sanityValue, sleepValue, hungerValue);
				break;
			
			case 2:
				//display data[9]
				sanityValue = (sanityValue + (Integer.parseInt(data[10])));
				sleepValue = (sleepValue + (Integer.parseInt(data[11])));
				hungerValue = (hungerValue + (Integer.parseInt(data[12])));
				updateData(sanityValue, sleepValue, hungerValue);
				break;
			
			case 3:
				//display data[13]
				sanityValue = (sanityValue + (Integer.parseInt(data[14])));
				sleepValue = (sleepValue + (Integer.parseInt(data[15])));
				hungerValue = (hungerValue + (Integer.parseInt(data[16])));
				updateData(sanityValue, sleepValue, hungerValue);
				break;
				
			case 4:
				//display data[17]
				sanityValue = (sanityValue + (Integer.parseInt(data[18])));
				sleepValue = (sleepValue + (Integer.parseInt(data[19])));
				hungerValue = (hungerValue + (Integer.parseInt(data[20])));
				updateData(sanityValue, sleepValue, hungerValue);
				break;
				
			default:
				System.gc(); //runs garbage collector to prevent stack overflow error
				displayGameEvent(data);
				break;
		}
		
	}
	
	/**
	 * updates player data to new values
	 * @param newSanity
	 * @param newSleep
	 * @param newHunger
	 */
	public void updateData(int newSanity, int newSleep, int newHunger)
	{
		game.setSanity(newSanity);
		game.setSleep(newSleep);
		game.setHunger(newHunger);
	}
	
}
