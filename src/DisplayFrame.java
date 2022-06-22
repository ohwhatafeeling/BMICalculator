import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DisplayFrame extends JFrame implements ActionListener {
	JLabel labelTitle = new JLabel("BMI Calculator");
	JLabel labelWeight = new JLabel("Enter your weight in Kg: ");
	JLabel labelHeight = new JLabel("Enter your height in M :");
	JTextField textFieldWeight = new JTextField();
	JTextField textFieldHeight = new JTextField();
	JButton buttonSubmit = new JButton("Submit");
	JLabel labelResult = new JLabel();
	Calculator calculator = new Calculator();
	
	DisplayFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 500);
		this.setTitle("BMI Calculator");
		this.setLayout(new FlowLayout());
		
		labelTitle.setFont(new Font("monospaced", Font.BOLD, 50));
		
		textFieldWeight.setPreferredSize(new Dimension(150, 40));
		
		textFieldHeight.setPreferredSize(new Dimension(150, 40));
		
		buttonSubmit.addActionListener(this);
		
		
		this.add(labelTitle);
		this.add(labelWeight);
		this.add(textFieldWeight);
		this.add(labelHeight);
		this.add(textFieldHeight);
		this.add(buttonSubmit);
		this.add(labelResult);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonSubmit) {
			double weight = Double.parseDouble(textFieldWeight.getText());
			double height = Double.parseDouble(textFieldHeight.getText());
			double result = calculator.calculateBmi(weight, height);
			labelResult.setText("Your BMI is: " + result);
		}
	}
}
