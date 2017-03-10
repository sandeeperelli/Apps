package com.sparkcentral.calculator.calculatorApp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CalculatorAppView implements ActionListener {
    @Autowired
    CalculatorViewHelper helper;
    @Autowired
    CalFunctions func;  
   

    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9" };

   

    public void initilize() {
        helper.frame.setVisible(true);
        helper.frame.setSize(350, 280);
        helper.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helper.frame.add(helper.panel);

        helper.panel.add(helper.text);
        for (int i = 0; i < 10; i++) {
            helper.panel.add(helper.buttons[i]);
            helper.buttons[i].addActionListener(this);
        }

        
        helper.panel.add(helper.add);
        helper.panel.add(helper.minus);
        helper.panel.add(helper.multiply);
        helper.panel.add(helper.divide);
        helper.panel.add(helper.square);
        helper.panel.add(helper.squareRoot);
        helper.panel.add(helper.oneDevidedBy);
        helper.panel.add(helper.cos);
        helper.panel.add(helper.sin);
        helper.panel.add(helper.tan);

        helper.panel.add(helper.equal);
        helper.panel.add(helper.cancel);

        helper.add.addActionListener(this);
        helper.minus.addActionListener(this);
        helper.multiply.addActionListener(this);
        helper.divide.addActionListener(this);
        helper.square.addActionListener(this);
        helper.squareRoot.addActionListener(this);
        helper.oneDevidedBy.addActionListener(this);
        helper.cos.addActionListener(this);
        helper.sin.addActionListener(this);
        helper.tan.addActionListener(this);

        helper.equal.addActionListener(this);
        helper.cancel.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == helper.buttons[i]) {
            	helper.text.replaceSelection(buttonValue[i]);
                return;
            }
        }

        if (source == helper.add) {
            helper.writer(func.calculateBi(CalFunctions.BiOperatorModes.add, helper.reader()));
        }

        if (source == helper.minus) {
            helper.writer(func.calculateBi(CalFunctions.BiOperatorModes.minus, helper.reader()));
        }

        if (source ==helper.multiply) {
            helper.writer(func.calculateBi(CalFunctions.BiOperatorModes.multiply,
                helper.reader()));
        }

        if (source == helper.divide) {
            helper.writer(func
                .calculateBi(CalFunctions.BiOperatorModes.divide, helper.reader()));
        }

        if (source == helper.square) {
            helper.writer(func.calculateMono(CalFunctions.MonoOperatorModes.square,
                helper.reader()));
        }

        if (source == helper.squareRoot) {
            helper.writer(func.calculateMono(CalFunctions.MonoOperatorModes.squareRoot,
                helper.reader()));
        }

        if (source ==helper. oneDevidedBy) {
            helper.writer(func.calculateMono(
            		CalFunctions.MonoOperatorModes.oneDevidedBy, helper.reader()));
        }

        if (source == helper.cos) {
            helper.writer(func.calculateMono(CalFunctions.MonoOperatorModes.cos,
                helper.reader()));
        }

        if (source == helper.sin) {
            helper.writer(func.calculateMono(CalFunctions.MonoOperatorModes.sin,
                helper.reader()));
        }

        if (source == helper.tan) {
            helper.writer(func.calculateMono(CalFunctions.MonoOperatorModes.tan,
                helper.reader()));
        }

        if (source ==helper. equal) {
            helper.writer(func.calculateEqual(helper.reader()));
        }

        if (source == helper.cancel) {
            helper.writer(func.reset());
        }

        helper.text.selectAll();
    }

   
}
