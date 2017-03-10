package com.sparkcentral.calculator.calculatorApp;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.springframework.stereotype.Component;

@Component
public class CalculatorViewHelper {
	protected final JButton buttons[], add, minus, multiply, divide,
    equal, cancel, squareRoot, square, oneDevidedBy,
    cos, sin, tan;
	protected final JFrame frame;
    protected final JPanel panel;
    protected final JTextArea text;
     
	 
    public CalculatorViewHelper() {
	        frame = new JFrame("CalculatorApp");
	        frame.setResizable(false);
	        panel = new JPanel(new FlowLayout());

	        text = new JTextArea(2, 25);
	        buttons = new JButton[10];
	        for (int i = 0; i < 10; i++) {
	        	buttons[i] = new JButton(String.valueOf(i));
	        }

	        add = new JButton("+");
	        minus = new JButton("-");
	        multiply = new JButton("*");
	        divide = new JButton("/");
	        equal = new JButton("=");
	        squareRoot = new JButton("√");
	        square = new JButton("x*x");
	        oneDevidedBy = new JButton("1/x");
	        cos = new JButton("Cos");
	        sin = new JButton("Sin");
	        tan = new JButton("Tan");

	        cancel = new JButton("C");

	    }
    public Double reader() {
        Double num;
        String str;
        str = text.getText();
        num = Double.valueOf(str);

        return num;
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
        	text.setText("");
        } else {
        	text.setText(Double.toString(num));
        }
    }
}
