package crisis.model;

public class ExistentialCrisis 
{	
	private String name;
	private int sanity;
	private int hunger;
	private int time;
	private int day;
	
	public ExistentialCrisis()
	{
		this.name = "DEFAULT NAME";
		this.sanity = 100;
		this.hunger = 100;
		this.time = 0;
		this.day = 0;
	}
	
	/**
	 * runs certain methods based on what time it is in game
	 */
	public void runGame()
	{
		switch(time)
		{
		case 3:
			food();
			break;
			
		case 5:
			sleep();
			break;
			
		default:
			startEvent();
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
	 * gets a random number 0 and between the number you give it
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
	public void startEvent()
	{
		
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
			
}
