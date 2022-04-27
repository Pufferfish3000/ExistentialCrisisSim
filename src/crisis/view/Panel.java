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
	
	private SpringLayout layout;
	
	public Panel(Controller app)
	{
		super();
		this.app = app;
		this.health = new JButton("Health");
		this.button2 = new JButton("UPDATE");
		this.button3 = new JButton("UPDATE");
		this.button4 = new JButton("UPDATE");
		
		this.layout = new SpringLayout();
		
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
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
