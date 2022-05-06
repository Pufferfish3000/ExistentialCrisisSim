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
	private int [] healthValues;
	private HashMap <String, String> buttonText = new HashMap<String, String>();
	
	public GameEvent()
	{
		this.hungerValue = 0;
		this.sleepValue = 0;
		this.sanityValue = 0;
		this.healthValues = new int[3];
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
		output += "\n";
		return output;
		
	}
	
	public String gameEventInput(String [] eventData, int playerInput)
	{
		switch(playerInput)
		{
			case 1:
				output = eventData[5];
				sanityValue = Integer.parseInt(eventData[6]);
				sleepValue = Integer.parseInt(eventData[7]);
				hungerValue = Integer.parseInt(eventData[8]);
				updateData(sanityValue, sleepValue, hungerValue);
				break;
			
			case 2:
				output = eventData[9];
				sanityValue = Integer.parseInt(eventData[10]);
				sleepValue = Integer.parseInt(eventData[11]);
				hungerValue = Integer.parseInt(eventData[12]);
				updateData(sanityValue, sleepValue, hungerValue);
				break;
			
			case 3:
				output = eventData[13];
				sanityValue = Integer.parseInt(eventData[14]);
				sleepValue = Integer.parseInt(eventData[15]);
				hungerValue = Integer.parseInt(eventData[16]);
				updateData(sanityValue, sleepValue, hungerValue);
				break;
				
			case 4:
				output = eventData[17];
				sanityValue = Integer.parseInt(eventData[18]);
				sleepValue = Integer.parseInt(eventData[19]);
				hungerValue = Integer.parseInt(eventData[20]);
				updateData(sanityValue, sleepValue, hungerValue);
				break;
		}
		output += "\n";
		output += "\n";
		output += "\n";
		output += "\n";
		output += "\n";
		return output;
	}
	
	/**
	 * updates player data to new values
	 * @param newSanity
	 * @param newSleep
	 * @param newHunger
	 */
	public int [] updateData(int newSanity, int newSleep, int newHunger)
	{
		healthValues[0] = newSanity;
		healthValues[1] = newSleep;
		healthValues[2] = newHunger;
		
		return healthValues;
	}
	
	public int [] gethealthValues()
	{
		return healthValues;
	}
	
}
