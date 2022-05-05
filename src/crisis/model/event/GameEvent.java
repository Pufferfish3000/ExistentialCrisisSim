package crisis.model.event;

import java.util.ArrayList;
import java.util.HashMap;

import crisis.model.*;
import crisis.view.*;
import crisis.controller.*;

public class GameEvent 
{
//	private Controller app = new Controller();
	private String [] data;
	private String output;
	private int hungerValue;
	private int sleepValue;
	private int sanityValue;
	private HashMap <String, String> buttonText = new HashMap<String, String>();
	
	public GameEvent()
	{
//		this.app = new Controller();
//		this.view = new Panel(app);
//		this.hungerValue = game.getHunger();
//		this.sleepValue = game.getSleep();
//		this.sanityValue = game.getSanity();
		this.output = "";
	}
	
	/**
	 * displays event based on parameters
	 * @param eventDescript
	 * @param eventChoices
	 * @param eventOutcomes
	 */
	public String displayGameEvent(String[] eventData)
	{
		data = eventData;
		buttonText.put("1", data[1]);
		buttonText.put("2", data[2]);
		buttonText.put("3", data[3]);
		buttonText.put("4", data[4]);
		output = data[0];
		output += "\n";
		output += ("1: " + buttonText.get("1") + " 2: " + buttonText.get("2") + " 3: " + buttonText.get("3") + " 4: " + buttonText.get("4")) + "\n";
		
		return output;
		
	}
	
	public String gameEventInput(String [] eventData, int playerInput)
	{
		switch(playerInput)
		{
			case 1:
				output = eventData[5];
				sanityValue = (sanityValue + (Integer.parseInt(eventData[6])));
				sleepValue = (sleepValue + (Integer.parseInt(eventData[7])));
				hungerValue = (hungerValue + (Integer.parseInt(eventData[8])));
				System.out.println(eventData[6]);
				updateData(sanityValue, sleepValue, hungerValue);
				break;
			
			case 2:
				output = eventData[9];
				sanityValue = (sanityValue + (Integer.parseInt(eventData[10])));
				sleepValue = (sleepValue + (Integer.parseInt(eventData[11])));
				hungerValue = (hungerValue + (Integer.parseInt(eventData[12])));
				updateData(sanityValue, sleepValue, hungerValue);
				break;
			
			case 3:
				output = eventData[13];
				sanityValue = (sanityValue + (Integer.parseInt(eventData[14])));
				sleepValue = (sleepValue + (Integer.parseInt(eventData[15])));
				hungerValue = (hungerValue + (Integer.parseInt(eventData[16])));
				updateData(sanityValue, sleepValue, hungerValue);
				break;
				
			case 4:
				output = eventData[17];
				sanityValue = (sanityValue + (Integer.parseInt(eventData[18])));
				sleepValue = (sleepValue + (Integer.parseInt(eventData[19])));
				hungerValue = (hungerValue + (Integer.parseInt(eventData[20])));
				updateData(sanityValue, sleepValue, hungerValue);
				break;
		}
		output += "\n";
		return output;
	}
	
	/**
	 * updates player data to new values
	 * @param newSanity
	 * @param newSleep
	 * @param newHunger
	 */
	public void updateData(int newSanity, int newSleep, int newHunger)
	{
//		game.setSanity(newSanity);
//		game.setSleep(newSleep);
//		game.setHunger(newHunger);
	}
	
}
