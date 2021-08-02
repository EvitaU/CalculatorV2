import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class Calculator extends JFrame implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[13];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqlButton, delButton, clrButton, negativeButton;
    JButton sqrtButton, sinButton, cosButton, percentButton;
    JPanel panel;

    Font font = new Font("Brush Script", 0, 18);
    Color darkGray = new Color(195, 198, 195);
    Color gray = new Color(217, 217, 212);

    double num1 = 0, num2 = 0, result = 0;
    String operator;

    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(70, 30, 310, 55);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqlButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negativeButton = new JButton("+/-");
        sqrtButton = new JButton("√");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        percentButton = new JButton("%");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = eqlButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negativeButton;
        functionButtons[9] = sqrtButton;
        functionButtons[10] = sinButton;
        functionButtons[11] = cosButton;
        functionButtons[12] = percentButton;
        //loop for buttons
        for (int i = 0; i < 13; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setBackground(darkGray);
            functionButtons[i].setFocusable(false);
        }
        //loop for numbers
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setBackground(gray);
            numberButtons[i].setFocusable(false);
        }
        negativeButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);


        panel = new JPanel();
        panel.setBounds(50, 100, 340, 300);
        panel.setLayout(new GridLayout(4, 5, 5, 5));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(sqrtButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(percentButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(sinButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqlButton);
        panel.add(divButton);
        panel.add(cosButton);


        frame.add(panel);
        frame.add(negativeButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }
        if (e.getSource() == sqrtButton){
            num1 = parseDouble(textField.getText());
            operator = "√";

        }
        if (e.getSource() == sinButton){
            num1 = parseDouble(textField.getText());
            operator = "sin";

        }
        if (e.getSource() == cosButton){
            num1 = parseDouble(textField.getText());
            operator = "cos";
        }

        if (e.getSource() == percentButton){
            num1 = parseDouble(textField.getText());
            operator = "%";
            textField.setText("");
        }
        if (e.getSource() == eqlButton) {
            num2 = parseDouble(textField.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "√":
                    result = Math.sqrt(num2);
                    break;
                case "sin":
                    result = Math.sin(num2);
                    break;
                case "cos":
                    result = Math.cos(num2);
                    break;
                case "%":
                    result = num1 % num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negativeButton) {
            double temp = parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

    }
}
