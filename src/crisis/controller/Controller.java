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
	
	public void start()
	{
		name = pop.askQuestion("Please enter your name.");
		game.setName(name);
		playGame();
	}
	
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
	
	public void endGame()
	{
		
	}
	
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
	
	public void handleError(Exception error)
	{
		String details = "your error is " + error.getMessage();
		pop.displayMessage(details);
	}
}
