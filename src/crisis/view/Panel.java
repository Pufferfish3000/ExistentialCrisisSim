package crisis.view;
import crisis.controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 	Panel for the ExistentialCrisisSimulator
 * @author ccol0217
 *
 */
public class Panel extends JPanel
{
	private Controller app;
	/**
	 * The first button option
	 */
	private JButton health;
	/**
	 * The second Button Option
	 */
	private JButton button2;
	/**
	 * the third button option
	 */
	private JButton button3;
	/**
	 * The fourth button option
	 */
	private JButton button4;
	/**
	 * The field for stats
	 */
	private JTextArea healthField;
	/**
	 * The field for main information and progression.
	 */
	private JTextArea mainField;
	/**
	   * Layout manager for the panel. Uses constraints between components to
	   * align or spring from edges.
	   */
	private SpringLayout layout_1;
	
	private JScrollPane crisisPane;
	
	public Panel(Controller app, String info)
	{
		super();
		this.app = app;
		this.health = new JButton("1");
		this.button2 = new JButton("2");
		this.button3 = new JButton("3");
		this.button4 = new JButton("4");
				
		this.crisisPane = new JScrollPane();
		this.layout_1 = new SpringLayout();
		
		this.healthField = new JTextArea("",27,15);
		this.mainField = new JTextArea("",27,42);
		mainField.setText(info);
		this.layout_1 = new SpringLayout();
		
	
	
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * Helper method to add all components to panel, and adjust gui Settings.
	 */
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(800,600));
		this.setLayout(layout_1);
		
		this.add(health);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		
		this.add(crisisPane);
		
		crisisPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		crisisPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		crisisPane.setViewportView(mainField);
		
		healthField.setLineWrap(true);
		healthField.setWrapStyleWord(true);
		healthField.setEnabled(false);
		
		mainField.setLineWrap(true);
		mainField.setWrapStyleWord(true);
		mainField.setEnabled(false);
		
	
		this.add(healthField);
	}
	/**
	 * Helper method to add constraints for GUI components.
	 */
	private void setupLayout()
	{
		layout_1.putConstraint(SpringLayout.WEST, button3, 438, SpringLayout.WEST, this);
		layout_1.putConstraint(SpringLayout.NORTH, button4, 40, SpringLayout.SOUTH, healthField);
		layout_1.putConstraint(SpringLayout.SOUTH, button4, -29, SpringLayout.SOUTH, this);
		layout_1.putConstraint(SpringLayout.SOUTH, button3, -29, SpringLayout.SOUTH, this);
		layout_1.putConstraint(SpringLayout.SOUTH, button2, -29, SpringLayout.SOUTH, this);
		layout_1.putConstraint(SpringLayout.WEST, health, 38, SpringLayout.WEST, this);
		layout_1.putConstraint(SpringLayout.EAST, health, -622, SpringLayout.EAST, this);
		layout_1.putConstraint(SpringLayout.EAST, button3, -50, SpringLayout.WEST, button4);
		layout_1.putConstraint(SpringLayout.WEST, button4, 621, SpringLayout.WEST, this);
		layout_1.putConstraint(SpringLayout.EAST, button4, -46, SpringLayout.EAST, this);
		layout_1.putConstraint(SpringLayout.NORTH, healthField, 10, SpringLayout.NORTH, this);
		layout_1.putConstraint(SpringLayout.EAST, healthField, -35, SpringLayout.EAST, this);
		
		layout_1.putConstraint(SpringLayout.SOUTH, crisisPane, 0, SpringLayout.SOUTH, healthField);
		layout_1.putConstraint(SpringLayout.WEST, button2, 56, SpringLayout.EAST, health);
		layout_1.putConstraint(SpringLayout.EAST, button2, -71, SpringLayout.WEST, button3);
		layout_1.putConstraint(SpringLayout.NORTH, health, 0, SpringLayout.NORTH, button2);
		layout_1.putConstraint(SpringLayout.SOUTH, health, -29, SpringLayout.SOUTH, this);
		layout_1.putConstraint(SpringLayout.NORTH, button2, 0, SpringLayout.NORTH, button3);
		layout_1.putConstraint(SpringLayout.NORTH, button3, 0, SpringLayout.NORTH, button4);
		layout_1.putConstraint(SpringLayout.NORTH, crisisPane, 15, SpringLayout.NORTH, this);
		layout_1.putConstraint(SpringLayout.WEST, crisisPane, 15, SpringLayout.WEST, this);
		layout_1.putConstraint(SpringLayout.EAST, crisisPane, -15, SpringLayout.WEST, healthField);
	}
	
	/**
	 * Attaches listeners to the GUI components of the program.
	 */
	private void setupListeners()
	{
		/**
		 * Attaches a listener to the first button option.
		 */
		health.addActionListener(new ActionListener()
								{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String response = app.choose(1);
				updateMain(response);
			}
		});
		/**
		 * Attaches a listner to the second button option
		 */
		button2.addActionListener(new ActionListener()
								{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String response = app.choose(2);
				updateMain(response);
				
			}
		});
		/**
		 * Attaches a listener to the third button option.
		 */
		button3.addActionListener(new ActionListener()
								{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String response = app.choose(3);
				updateMain(response);
			}
		});
		/**
		 * attaches a listener to the fourth button option.
		 */
		button4.addActionListener(new ActionListener()
								{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String response = app.choose(4);
				updateMain(response);
			}
		});
	}
	/**
	 * Helper method used to update the mainField.
	 * @param update
	 */
	public void updateMain(String update)
	{
		mainField.append(update);
	}
	
	/**
	 * Helper method used to update the healthField
	 * @param update
	 */
	public void updateHealth(String update)
	{
		healthField.setText("/n");
		healthField.setText(update);
	}
}
