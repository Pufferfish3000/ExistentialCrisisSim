package crisis.model.event;
import java.util.ArrayList;
import crisis.model.*;

public class HiddenGameEvent extends GameEvent 
{
	private ExistentialCrisis game;
	private String [] data;
	private int hungerValue;
	private int sleepValue;
	private int sanityValue;
	
	public void HiddenGameEvent()
	{
		this.hungerValue = game.getHunger();
		this.sleepValue = game.getSleep();
		this.sanityValue = game.getSanity();
	}
	
	/**
	 * updates player data to given numbers
	 * @param eventData
	 */
	public void startHiddenGameEvent(String[] eventData)
	{
		data = eventData;
		sanityValue = (sanityValue + (Integer.parseInt(data[0])));
		sleepValue = (sleepValue + (Integer.parseInt(data[1])));
		hungerValue = (hungerValue + (Integer.parseInt(data[2])));
		updateData(sanityValue, sleepValue, hungerValue);
	}
}
