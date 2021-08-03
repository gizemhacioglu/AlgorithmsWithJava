package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decimalButton, equalsButton, delButton, clearButton, negationButton;
    JPanel panel;

    Font myFont = new Font("Times New Roman", Font.BOLD,30);

    double num1=0, num2=0, result=0;
    char operator;


    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        delButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negationButton = new JButton("Negate");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decimalButton;
        funcButtons[5] = equalsButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clearButton;
        funcButtons[8] = negationButton;

        for(int i =0; i<9; i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);

        }

        for(int i =0; i<10; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);

        }

        delButton.setBounds(50,420,130,50);
        clearButton.setBounds(210,420,130,50);
        negationButton.setBounds(130,475,140,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(funcButtons[2]);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(funcButtons[1]);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(funcButtons[0]);

        panel.add(numButtons[0]);
        panel.add(funcButtons[4]);
        panel.add(funcButtons[3]);
        panel.add(funcButtons[5]);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(negationButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i =0; i<10; i++){
            if(e.getSource() == numButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decimalButton){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equalsButton){

            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == clearButton){
            textField.setText("");
        }

        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i =0; i<string.length() - 1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        if(e.getSource() == negationButton){
            String string = textField.getText();
            textField.setText("-");
            for(int i =0; i<string.length(); i++){
                textField.setText(textField.getText() + string.charAt(i));
            }

//            double temp = Double.parseDouble(textField.getText());
//            temp *= -1;
//            textField.setText(String.valueOf(temp));
        }



    }
}
