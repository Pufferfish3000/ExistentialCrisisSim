package crisis.controller;
import crisis.view.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import crisis.model.ExistentialCrisis;

public class Controller 
{
	private Frame crisisFrame;
	private ExistentialCrisis game;
	private Popup pop;
	private String name;
	
	public Controller()
	{
		this.game = new ExistentialCrisis();
		this.crisisFrame = new Frame(this);
		this.name = "";
		this.pop = new Popup();
	}
	
	/**
	 * gets basic info from the player and then starts the game
	 */
	public void start()
	{
		name = pop.askQuestion("Please enter your name.");
		game.setName(name);
		playGame();
	}
	
	/**
	 * runs the game until the player runs out of sanity
	 */
	public void playGame()
	{
		
		game.runGame();
		if(game.isInsane())
		{
			endGame();
		}
		else
		{
			playGame();
		}
	}
	
	/**
	 * ends the game upon player death
	 */
	public void endGame()
	{
		
	}
	
	/**
	 * saves player responses and then prints them to a list
	 * @param responses
	 * @param filename
	 */
	private void saveListAsText(ArrayList <String> responses, String filename)
	{
		File saveFile = new File(filename);
		
		try (PrintWriter saveText = new PrintWriter(saveFile))
		{
			for (String content : responses)
			{
				saveText.println(content);
			}
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
