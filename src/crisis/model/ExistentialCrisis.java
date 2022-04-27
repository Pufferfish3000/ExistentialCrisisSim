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
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String playerName)
	{
		name = playerName;
	}
	
	public int getSanity()
	{
		return sanity;
	}
	
	public void setSanity(int playerSanity)
	{
		sanity = playerSanity;
	}
	
	public int getHunger()
	{
		return hunger;
	}
	
	public void setHunger(int playerHunger)
	{
		hunger = playerHunger;
	}
	
	public int getTime()
	{
		return time;
	}
	
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
	
	public int getDay()
	{
		return day;
	}
	
	public void updateDay()
	{
		day++;
	}
}
