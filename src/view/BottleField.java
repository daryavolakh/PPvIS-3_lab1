package view;

import java.awt.Dimension;

import javax.swing.JPanel;

public class BottleField {
	public JPanel panel = new JPanel();
	
	public BottleField()
	{
		panel.setPreferredSize(new Dimension(250,250));
		
		panel.setVisible(true);
	}
}
