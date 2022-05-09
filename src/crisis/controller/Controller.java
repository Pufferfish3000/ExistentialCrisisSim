package crisis.controller;
import crisis.view.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import crisis.model.ExistentialCrisis;

/**
 * Controller class, starts the main parts of thr project
 * @author bbyr8994
 *
 */
public class Controller 
{
	private Frame crisisFrame;
	private Panel crisisPanel;
	private ExistentialCrisis game;
	private Popup pop;
	private String name;
	private boolean progress;

	/*
	 * constructs a new Controller
	 */
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
		if(game.isInsane())
		{
			endGame();
		}
		else
		{
			return game.playerInput(buttonNumber) + game.runGame() + game.checkOverflow();
		}
		return ("GAME OVER \n");
		
	}
	
	/**
	 * gets player health bar
	 * @return a String representing the player's health bar
	 */
	public String healthbar()
	{
		return game.displayHealthbar();
	}
}
