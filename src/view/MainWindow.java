package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow {
	JFrame frame = new JFrame("Something");
	JPanel panel = new JPanel();
	PanelOfButtons panelOfButtons = new PanelOfButtons();
	BottleField field = new BottleField();
	public MainWindow()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(1000,600);
		frame.setResizable(false);
		
		panel.setLayout(new BorderLayout());
		panel.add(field.panel);
		panel.add(panelOfButtons.panel);
		frame.getContentPane().add(panel);
		//frame.pack();
	}
	
	public void show()
	{
		frame.setVisible(true);
	}
}
