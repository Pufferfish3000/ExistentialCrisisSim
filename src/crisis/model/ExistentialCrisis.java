package crisis.model;

import crisis.model.event.GameEvent;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import crisis.controller.*;
import crisis.view.*;
import java.util.HashMap;

public class ExistentialCrisis 
{	
	private GameEvent gameEvent;
	private Popup pop;
	private String name;
	private int sanity;
	private int hunger;
	private int sleepy;
	private int time;
	private int day;
	private int fileName;
	private String[] eventArray;
	private ArrayList <String> eventData;
	private int [] newhealth;
	private String displayText;
	private String displayHealth;
	private HashMap <Integer, String> timeMap;
	
	public ExistentialCrisis()
	{
		this.name = "DEFAULT NAME";
		this.sanity = 100;
		this.hunger = 100;
		this.time = 0;
		this.day = 0;
		this.pop = new Popup();
		this.eventArray = new String[12];
		this.fileName = 1;
		this.eventData = new ArrayList<String>();
		this.gameEvent = new GameEvent();
		this.sleepy = 100;
		this.displayText = "";
		this.displayHealth = "";
		this.newhealth = new int[3];
		this.timeMap = new HashMap <Integer, String>();
		timeMap.put(0, "03:00 AM");
		timeMap.put(1, "07:00 AM");
		timeMap.put(2, "11:00 AM");
		timeMap.put(3, "03:00 PM");
		timeMap.put(4, "07:00 PM");
		timeMap.put(5, "11:00 PM");
	}
	
	/**
	 * runs certain methods based on what time it is in game
	 */
	public String runGame()
	{
		switch(time)
		{
			case 3:
				displayText = "";
				food();
				time++;
				break;
				
			case 5:
				sleep();
				displayText = "";
				time = 0;
				break;
				
			default:
				displayText = startEvent();
				time++;
				break;
		}
		return displayText;
	}
	
	public String playerInput(int input)
	{
		switch(time)
		{
			case 3:
				displayText = "";
				break;
				
			case 5:
				displayText = "";
				day++;
				break;
				
			default: 
				displayText = gameEvent.gameEventInput(eventArray, input);
				break;
		}
		
		updateHealth();
		return displayText;
	}
	
	/**
	 * gets the name of the player
	 * @return the player name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * sets the name of the player
	 * @param playerName
	 */
	public void setName(String playerName)
	{
		name = playerName;
	}
	
	/**
	 * get the players current sanity
	 * @return player sanity
	 */
	public int getSanity()
	{
		return sanity;
	}
	
	/**
	 * sets the sanity of the player
	 * @param playerSanity
	 */
	public void setSanity(int playerSanity)
	{
		sanity = playerSanity;
	}
	
	/**
	 * gets the players hunger
	 * @return player hunger
	 */
	public int getHunger()
	{
		return hunger;
	}
	
	/**
	 * sets the players hunger
	 * @param playerHunger
	 */
	public void setHunger(int playerHunger)
	{
		hunger = playerHunger;
	}
	
	/**
	 * gets the current time in game as a number between 0 - 4
	 * @return current in game time
	 */
	public int getTime()
	{
		return time;
	}
	
	public String getDisplayText()
	{
		return displayText;
	}
	
	/**
	 * when called it checks the current time, sets to 0 and calls
	 * updateDay if greater or equal to 5, otherwise it increments
	 * time by 1
	 */
	public void updateTime()
	{
		if(time >= 5)
		{
			time = 0;
			updateDay();
		}
		else
		{
			time++;
		}	
	}
	
	/**
	 * get the current in game day
	 * @return current in game day 
	 */
	public int getDay()
	{
		return day;
	}
	
	/**
	 * when called, increments the in game day by one
	 */
	public void updateDay()
	{
		day++;
	}
	
	/**
	 * gets a random number 0 and between one less than the number you give it
	 * @param chance
	 * @return a number between 0 and chance
	 */
	public int gameRandom(int chance)
	{
		int r = (int) (Math.random() * (100 - 1)) + 1;
		r = r % chance;
		return r;
	}
	
	/**
	 * returns true if any of the players health values is at or below 0
	 * @return if a play is insane
	 */
	public boolean isInsane()
	{
		if(sanity <= 0 || hunger <=0 || sleepy <= 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * starts an event
	 */
	public String startEvent()
	{
		fileName = gameRandom(2);
		eventData = loadTextToList("src/crisis/model/event/" + fileName + ".txt");
		eventArray = eventData.toArray(new String[0]);
		return gameEvent.displayGameEvent(eventArray);
	}
	
	/**
	 * gives players the option to feed themselves
	 */
	public void food()
	{
		hunger += 50;
	}
	
	/**
	 * gives players the option to sleep
	 */
	public void sleep()
	{
		sleepy += 50;
	}
	
	/**
	 * gets player sleep value
	 * @return player sleep
	 */
	public int getSleep()
	{
		return sleepy;
	}
	
	/**
	 * sets player sleep value
	 * @param newSleep
	 */
	public void setSleep(int newSleep)
	{
		sleepy = newSleep;
	}
			
	/**
	 * saves player responses and then prints them to a list
	 * @param responses
	 * @param filename
	 */
	public void saveAsText(int responses, String filename)
	{
		File saveFile = new File(filename);
		
		try (PrintWriter saveText = new PrintWriter(saveFile))
		{
			saveText.println(responses);
		}
		catch(IOException errorFromIO)
		{
			handleError(errorFromIO);
		}
		catch(Exception genericError) 
		{
			handleError(genericError);
		}
	}
	
	/**
	 * takes information from a file and loads it into a list
	 * @param filename
	 * @return an arraylist of what was in the file
	 */
	private ArrayList<String> loadTextToList(String filename)
	{
		ArrayList<String> fileContents = new ArrayList<String>();
		
		File source = new File(filename);
		
		try(Scanner fileScanner = new Scanner(source))
		{
			while (fileScanner.hasNextLine())
			{
				fileContents.add(fileScanner.nextLine());
			}
		}
		catch(IOException fileError)
		{
			handleError(fileError);
		}
		catch(Exception error)
		{
			handleError(error);
		}
		
		return fileContents;
	}
	
	/**
	 * handles error for try catch
	 * @param error
	 */
	public void handleError(Exception error)
	{
		String details = "your error is " + error.getMessage();
		pop.displayMessage(details);
	}
	
	public String displayHealthbar()
	{
		displayHealth = "DAY: " + day + "\n";
		displayHealth += "TIME: " + timeMap.get(time) + "\n";
		displayHealth += "SANITY: " + sanity + "\n";
		displayHealth += "HUNGER: " + hunger + "\n";
		displayHealth += "AWARENESS: " + sleepy + "\n";
		
		return displayHealth;	
	}
	
	public void updateHealth()
	{
		newhealth = gameEvent.gethealthValues();
		sanity = sanity + newhealth[0];
		sleepy = sleepy + newhealth[1];
		hunger = hunger + newhealth[2];
	}
	
	public String checkOverflow()
	{
		if(sanity > 100)
		{
			sanity = 100;
		}
		if(hunger > 100)
		{
			hunger = 100;
		}
		if(sleepy > 100)
		{
			sleepy = 100;
		}
		return "";
	}
}
