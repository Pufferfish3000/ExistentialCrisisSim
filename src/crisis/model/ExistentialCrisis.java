package crisis.model;

import crisis.model.event.GameEvent;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import crisis.controller.*;
import crisis.view.*;

public class ExistentialCrisis 
{	
	private GameEvent gameEvent;
//	private Controller app;
//	private Panel view;
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
	private String displayText;
	
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
//		this.app = new Controller();
//		this.view = new Panel(app);
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
				break;
				
			case 5:
				sleep();
				displayText = "";
				break;
				
			default:
				displayText = startEvent();
				break;
		}
		return displayText;
	}
	
	public void getInput(int input)
	{
		switch(time)
		{
			case 3:
				displayText = "";
				break;
				
			case 5:
				displayText = "";
				break;
				
			default: 
				displayText = "";
				gameEvent.displayGameEvent(eventArray);
				break;
		}
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
	 * returns true if an players sanity is at or below 0
	 * @return if a play is insane
	 */
	public boolean isInsane()
	{
		if(sanity <= 0)
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
		gameEvent.displayGameEvent(eventArray);
		
		return "";
	}
	
	/**
	 * gives players the option to feed themselves
	 */
	public void food()
	{
		
	}
	
	/**
	 * gives players the option to sleep
	 */
	public void sleep()
	{
		
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
}
