package crisis.view;

import javax.swing.*;
import java.awt.*;
import crisis.controller.Controller;

/**
 * GUI Frame class for the ExistentialCrisisSimulator
 * @author ccol0217
 *
 */
public class Frame  extends JFrame
{
	/**
	 * Reference to the Controller instance.
	 */
	private Controller app;
	/**
	 * Panel instance.
	 */
	private Panel crisisPanel;
	
	/**
	 * Builds an instance of the Frame with a reference to the Controller instance.
	 * @param app
	 */
	public Frame(Controller app)
	{
		super();
		
		this.app = app;
		this.crisisPanel = new Panel(this.app);
		setupFrame();
	}
	/**
	 * Configures JFrame window, and sets information for the frame.
	 */
	private void setupFrame()
	{
		this.setTitle("Existential Crisis Simulator");
		this.setSize(800,600);
		this.setContentPane(crisisPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
