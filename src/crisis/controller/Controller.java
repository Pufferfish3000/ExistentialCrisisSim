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
	private Panel crisisPanel;
	private ExistentialCrisis game;
	private Popup pop;
	private String name;
	private boolean progress;

	public Controller()
	{
		this.game = new ExistentialCrisis();
		this.crisisFrame = new Frame(this, game.runGame());
		this.name = "";
		this.pop = new Popup();
		this.progress = false;
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
			//game.runGame();
	}

	
	/**
	 * ends the game upon player death
	 */
	public void endGame()
	{
		game.saveAsText(game.getDay(), "SCORE.txt");
	}
	
	public String choose(int buttonNumber)
	{
		game.playerInput(buttonNumber);
		
		if(game.isInsane())
		{
			endGame();
		}
		else
		{
			playGame();
		}
		
		return game.getDisplayText();
	}
}
