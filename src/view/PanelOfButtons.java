package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelOfButtons {
	public JPanel panel = new JPanel();
	public JButton buttonHelp = new JButton("help");
	public JLabel labelPoints = new JLabel("points: ");
	public JLabel pointsValue = new JLabel("0");
	
	public PanelOfButtons()
	{
		panel.add(labelPoints);
		panel.add(pointsValue);
		panel.add(buttonHelp);
		panel.setVisible(true);
	}
	
	public JButton getHelpButton()
	{
		return buttonHelp;
	}
	
	public void changePoints()
	{
		getPoints();
		setPoints();
	}
	
	public int getPoints()
	{
		int points = Integer.parseInt(pointsValue.getText());
		return points;
	}
	
	public void setPoints()
	{
		int prevValue = getPoints();
		pointsValue.setText(String.valueOf(prevValue + 1));
	}
}
