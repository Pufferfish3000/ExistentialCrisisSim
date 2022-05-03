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
	
	private JTextArea healthField;
	private JTextArea mainField;
	
	private SpringLayout layout;
	
	public Panel(Controller app)
	{
		super();
		this.app = app;
		this.health = new JButton("Health");
		this.button2 = new JButton("UPDATE");
		this.button3 = new JButton("UPDATE");
		this.button4 = new JButton("UPDATE");
		
<<<<<<< Updated upstream
		this.healthArea = new JTextArea(10,5);
		this.mainArea = new JTextArea (12, 25);
		
		this.layout = new SpringLayout();
		layout.putConstraint(SpringLayout.NORTH, healthArea, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, healthArea, -112, SpringLayout.EAST, button4);
		layout.putConstraint(SpringLayout.SOUTH, healthArea, -6, SpringLayout.NORTH, button4);
		layout.putConstraint(SpringLayout.EAST, healthArea, 0, SpringLayout.EAST, button4);
=======
		this.healthField = new JTextArea(27,15);
		this.mainField = new JTextArea(27,42);
		
		this.layout = new SpringLayout();
		layout.putConstraint(SpringLayout.WEST, button2, 56, SpringLayout.EAST, health);
		layout.putConstraint(SpringLayout.EAST, button2, -71, SpringLayout.WEST, button3);
		layout.putConstraint(SpringLayout.SOUTH, health, 0, SpringLayout.SOUTH, button2);
		layout.putConstraint(SpringLayout.WEST, button3, 438, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, mainField, 26, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, button4, 40, SpringLayout.SOUTH, healthField);
		layout.putConstraint(SpringLayout.SOUTH, button4, -29, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, button3, 40, SpringLayout.SOUTH, mainField);
		layout.putConstraint(SpringLayout.SOUTH, button3, -29, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, button2, 40, SpringLayout.SOUTH, mainField);
		layout.putConstraint(SpringLayout.SOUTH, button2, -29, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, health, 0, SpringLayout.NORTH, button2);
		layout.putConstraint(SpringLayout.WEST, health, 38, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, health, -622, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.EAST, button3, -50, SpringLayout.WEST, button4);
		layout.putConstraint(SpringLayout.WEST, button4, 621, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, button4, -46, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, healthField, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, mainField, 0, SpringLayout.NORTH, healthField);
		layout.putConstraint(SpringLayout.EAST, healthField, -35, SpringLayout.EAST, this);
>>>>>>> Stashed changes

		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(800,600));
		this.setLayout(layout);
		
		this.add(health);
		this.add(button2);
		this.add(button3);
		this.add(button4);
<<<<<<< Updated upstream
		
		this.add(healthArea);
		this.add(mainArea);
=======
		this.add(healthField);
		this.add(mainField);
>>>>>>> Stashed changes
	}
	
	private void setupLayout()
	{
	}
	
	private void setupListeners()
	{
		
	}
}
