import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayFrame extends JFrame implements ActionListener {
	JLabel labelTitle = new JLabel("BMI Calculator");
	JLabel labelWeight = new JLabel("Enter your weight in Kg: ");
	JLabel labelHeight = new JLabel("Enter your height in M :");
	JTextField textFieldWeight = new JTextField();
	JTextField textFieldHeight = new JTextField();
	JButton buttonSubmit = new JButton("Submit");
	JLabel labelScore = new JLabel();
	JLabel labelResult = new JLabel();
	JPanel panelInner = new JPanel();
	JPanel panelResult = new JPanel();
	Calculator calculator = new Calculator();
	
	DisplayFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 500);
		this.setResizable(false);
		this.setTitle("BMI Calculator");
		this.setLayout(new FlowLayout());
		
		labelTitle.setFont(new Font("monospaced", Font.BOLD, 50));
		
		textFieldWeight.setPreferredSize(new Dimension(150, 40));
		
		textFieldHeight.setPreferredSize(new Dimension(150, 40));
		
		buttonSubmit.addActionListener(this);
		
		panelInner.setPreferredSize(new Dimension(450, 100));
		panelInner.add(labelWeight);
		panelInner.add(textFieldWeight);
		panelInner.add(labelHeight);
		panelInner.add(textFieldHeight);
		
		panelResult.setPreferredSize(new Dimension(450, 100));
		panelResult.add(labelScore);
		panelResult.add(labelResult);
		
		this.add(labelTitle);
		this.add(panelInner);
		this.add(buttonSubmit);
		this.add(panelResult);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonSubmit) {
			double weight = Double.parseDouble(textFieldWeight.getText());
			double height = Double.parseDouble(textFieldHeight.getText());
			double result = calculator.calculateBmi(weight, height);
			labelScore.setText("Your BMI is: " + result);
			setResultColor(result);
		}
	}
	
	public void setResultColor(double result) {
		if (result < 18.5) {
			panelResult.setBackground(Color.BLUE);
			labelResult.setText("You are underweight");
		} else if (result < 25.0) {
			panelResult.setBackground(Color.GREEN);
			labelResult.setText("You are healthy");
		} else if (result < 30) {
			panelResult.setBackground(Color.ORANGE);
			labelResult.setText("You are overweight");
		} else {
			panelResult.setBackground(Color.RED);
			labelResult.setText("You are obese");
		}
	}
}
