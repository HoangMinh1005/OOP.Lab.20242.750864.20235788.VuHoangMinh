package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;	// accumulated sum
	
	// Constructor to setup the GUI components and event handlers
	public AWTAccumulator() {
		setLayout(new GridLayout(2, 2));
		
		add(new Label("Enter an Integer: "));
		
		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		add(new Label("The Accumulated Sum is: "));
		
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);	// set to read-only
		add(tfOutput);
		
		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWTAccumulator();
	}
	
	private class TFInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {			//the entered number is parsed, added to the sum, 
			int numberIn = Integer.parseInt(tfInput.getText()); // and the output TextField’s text is changed to reflect the new sum
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
}
