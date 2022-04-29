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
}
