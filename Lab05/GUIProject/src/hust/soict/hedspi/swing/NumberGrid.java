package GUIProject.src.hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class NumberGrid extends JFrame {
	private JButton[] btnNumbers = new JButton[10];	   // btnNumbers array for the digit buttons
	private JButton btnDelete, btnReset;	// DEL, C buttons
	private JTextField tfDisplay;		// top display
	
	// constructor to set up GUI components
	public NumberGrid() {
		tfDisplay = new JTextField();		// display text field
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel panelButtons = new JPanel(new GridLayout(4, 3));		//  group all of the buttons and put them in a grid layout
		addButtons(panelButtons);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(200, 200);
		setVisible(true);
	}	
	
	void addButtons(JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener();
		for(int i=1; i<=9; i++) {
			btnNumbers[i] = new JButton(""+i);
			panelButtons.add(btnNumbers[i]);
			btnNumbers[i].addActionListener(btnListener);
		}
		
		btnDelete = new JButton("DEL");
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);
		
		btnNumbers[0] = new JButton("0");
		panelButtons.add(btnNumbers[0]);
		btnNumbers[0].addActionListener(btnListener);
		
		btnReset = new JButton("C");
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				tfDisplay.setText(tfDisplay.getText() + button);
			}
			else if(button.equals("DEL")) {
				String currentText = tfDisplay.getText();
				if(currentText.length() > 0) {
					tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
				}
			}
			else if(button.equals("C")) {
				tfDisplay.setText("");
			}
		}
	}
	
	public static void main(String[] args) {
		new NumberGrid();
	}
}
