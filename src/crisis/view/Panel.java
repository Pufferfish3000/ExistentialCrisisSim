package crisis.view;
import crisis.controller.Controller;
import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel
{
	private Controller app;
	private JButton health;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JTextArea healthArea;
	private JTextArea mainArea;
	
	private SpringLayout layout;
	
	public Panel(Controller app)
	{
		super();
		this.app = app;
		this.health = new JButton("Health");
		this.button2 = new JButton("UPDATE");
		this.button3 = new JButton("UPDATE");
		this.button4 = new JButton("UPDATE");
		
		this.healthArea = new JTextArea(10,5);
		this.mainArea = new JTextArea (12, 25);
		
		this.layout = new SpringLayout();
		layout.putConstraint(SpringLayout.NORTH, healthArea, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, healthArea, -112, SpringLayout.EAST, button4);
		layout.putConstraint(SpringLayout.SOUTH, healthArea, -6, SpringLayout.NORTH, button4);
		layout.putConstraint(SpringLayout.EAST, healthArea, 0, SpringLayout.EAST, button4);

		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		
		this.add(health);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		
		this.add(healthArea);
		this.add(mainArea);
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, button4, 0, SpringLayout.NORTH, health);
		layout.putConstraint(SpringLayout.WEST, button4, 19, SpringLayout.EAST, button3);
		layout.putConstraint(SpringLayout.SOUTH, button4, 0, SpringLayout.SOUTH, health);
		layout.putConstraint(SpringLayout.NORTH, button3, 0, SpringLayout.NORTH, health);
		layout.putConstraint(SpringLayout.WEST, button3, 18, SpringLayout.EAST, button2);
		layout.putConstraint(SpringLayout.SOUTH, button3, 0, SpringLayout.SOUTH, health);
		layout.putConstraint(SpringLayout.NORTH, button2, 0, SpringLayout.NORTH, health);
		layout.putConstraint(SpringLayout.WEST, button2, 15, SpringLayout.EAST, health);
		layout.putConstraint(SpringLayout.SOUTH, button2, 0, SpringLayout.SOUTH, health);
		layout.putConstraint(SpringLayout.WEST, health, 9, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, health, -69, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.SOUTH, health, -10, SpringLayout.SOUTH, this);
	}
	
	private void setupListeners()
	{
		
	}
}
