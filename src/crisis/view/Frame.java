package crisis.view;

import javax.swing.*;
import java.awt.*;
import crisis.controller.Controller;

public class Frame  extends JFrame
{
	private Controller app;
	private Panel crisisPanel;
	
	public Frame(Controller app)
	{
		super();
		
		this.app = app;
		this.crisisPanel = new Panel(this.app);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setTitle("Existential Crisis Simulator");
		this.setSize(800,600);
		this.setContentPane(crisisPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
