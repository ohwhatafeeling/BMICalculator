import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class DisplayFrame extends JFrame implements ActionListener {
	JLabel labelTitle;
	JLabel labelWeight;
	JLabel labelHeight;
	JFormattedTextField textFieldWeight;
	JFormattedTextField textFieldHeight;
	JButton buttonSubmit;
	JLabel labelScore;
	JLabel labelResult;
	JPanel panelInner;
	JPanel panelResult;
	Calculator calculator = new Calculator();
	MaskFormatter mfWeight;
	MaskFormatter mfHeight;
	
	DisplayFrame() throws ParseException {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 500);
		this.setResizable(false);
		this.setTitle("BMI Calculator");
		this.setLayout(new FlowLayout());
		
		labelTitle = new JLabel("BMI Calculator");
		labelTitle.setFont(new Font("monospaced", Font.BOLD, 40));
		
		labelWeight = new JLabel("Enter your weight in Kg: ");
		
		mfWeight = new MaskFormatter("##.#");
		mfWeight.setPlaceholderCharacter('0');
		
		textFieldWeight = new JFormattedTextField(mfWeight);
		textFieldWeight.setPreferredSize(new Dimension(150, 40));
		
		labelHeight = new JLabel("Enter your height in M :");
		
		mfHeight = new MaskFormatter("#.##");
		mfHeight.setPlaceholderCharacter('0');
		
		textFieldHeight = new JFormattedTextField(mfHeight);
		textFieldHeight.setPreferredSize(new Dimension(150, 40));
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.addActionListener(this);
		
		labelScore = new JLabel();
		labelScore.setPreferredSize(new Dimension(450, 50));
		labelScore.setFont(new Font(null, Font.BOLD, 20));
		labelScore.setHorizontalAlignment(JLabel.CENTER);
		
		labelResult = new JLabel();
		labelResult.setPreferredSize(new Dimension(450, 50));
		labelResult.setFont(new Font(null, Font.ITALIC, 16));
		labelResult.setHorizontalAlignment(JLabel.CENTER);
		
		panelInner = new JPanel();
		panelInner.setPreferredSize(new Dimension(450, 100));
		panelInner.add(labelWeight);
		panelInner.add(textFieldWeight);
		panelInner.add(labelHeight);
		panelInner.add(textFieldHeight);
		
		panelResult = new JPanel();
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
			if (weight == 0 && height == 0) {
				labelScore.setText("Please enter your weight and height");
			} else if (weight == 0) {
				labelScore.setText("Please enter your weight");
			} else if (height == 0) {
				labelScore.setText("Please enter your height");
			} else {
				double score = calculator.calculateBmi(weight, height);
				labelScore.setText("Your BMI is: " + scoreRounded(score));
				setResultColor(score);
			}
		}
	}
	
	public void setResultColor(double score) {
		if (score < 18.5) {
			panelResult.setBackground(Color.BLUE);
			labelResult.setText("You are underweight");
		} else if (score < 25.0) {
			panelResult.setBackground(Color.GREEN);
			labelResult.setText("You are healthy");
		} else if (score < 30) {
			panelResult.setBackground(Color.ORANGE);
			labelResult.setText("You are overweight");
		} else {
			panelResult.setBackground(Color.RED);
			labelResult.setText("You are obese");
		}
	}
	
	public String scoreRounded(double score) {
		DecimalFormat scoreFormat = new DecimalFormat("#.00");
		return scoreFormat.format(score);
	}
	
}
