import java.awt.event.*;
import java.util.Iterator;

import javax.naming.ldap.Rdn;
import javax.swing.*;

import java.awt.*;

public class Calculator implements ActionListener {
	
	// Creating GUI
	JFrame frame;
	JTextField textfield;
	JButton [] numberButtons = new JButton[10];
	JButton [] functionButtons = new  JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, eqButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	double num1=0, num2=0, result=0;
	char operator;
	
	Calculator() {
		//frame
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
//		frame.setTitle("Calculator");
		
		
		
		//textfield
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		// create buttons
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		// set buttons to functionButton
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = eqButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i=0; i<9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);

		}
		
		// set number buttons
		for(int i=0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);

		}
		
		// del and clr 
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		// create panel
		
		panel = new JPanel();
		panel.setBounds(50, 100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		// put all buttons on panel
			//1st row
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(divButton);
			//2nd row
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(mulButton);
			//3rd row
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(subButton);
			//4TH ROW
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(eqButton);
		panel.add(addButton);
		
		// add to frame
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(panel);
		frame.add(textfield);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Number 0....9
		for(int i=0; i<10; i++) {
			if(e.getSource()==numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
			
			// decimal button
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		//addition
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='+';
			textfield.setText("");
		}
		
		// Subtraction
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='-';
			textfield.setText("");
		}
		
		//Multi
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='*';
			textfield.setText("");
		}
		
		// Division
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
		}
		
		// Equal
		if(e.getSource()==eqButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			// Switch for math operation
			switch(operator) {
			//Case 1 : Addition
			case'+':
				result=num1+num2;
				break;
			//Case 2 : Sub
			case'-':
				result=num1-num2;
				break;
			//Case 3 : Multi
			case'*':
				result=num1*num2;
				break;
			//Case 4: Division
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		
		//Clear Button
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		//Delete Button
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0; i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp)); 
		}
	}

}
