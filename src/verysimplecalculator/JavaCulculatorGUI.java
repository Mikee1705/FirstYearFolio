import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaCulculatorGUI extends JFrame implements ActionListener {
    // Components for the calculator
    private JTextField display;
    private JButton[] numberButtons = new JButton[10]; // 0-9
    private JButton[] operationButtons = new JButton[5]; // +, -, *, /, %
    private JButton addButton, subButton, mulButton, divButton, modButton;
    private JButton decButton, equButton, clrButton, delButton;
    private JPanel panel;

    // Variables to store the current calculation
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    // Constructor to set up the GUI
    public JavaCulculatorGUI() {
        // Set the frame properties
        setTitle("Simple Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Text field to display results
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        display.setEditable(false);
        add(display);

        // Initialize buttons for operations
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");

        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = mulButton;
        operationButtons[3] = divButton;
        operationButtons[4] = modButton;

        // Initialize buttons for other functions
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("DEL");

        // Create number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Add action listeners to operation buttons
        for (JButton btn : operationButtons) {
            btn.addActionListener(this);
        }
        decButton.addActionListener(this);
        equButton.addActionListener(this);
        clrButton.addActionListener(this);
        delButton.addActionListener(this);

        // Set up the panel to hold the buttons in a grid layout
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(modButton);

        // Add the panel and other buttons to the frame
        add(panel);
        clrButton.setBounds(50, 420, 145, 50);
        delButton.setBounds(205, 420, 145, 50);

        add(clrButton);
        add(delButton);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if(e.getSource() == modButton){
            num1 = Double.parseDouble(display.getText());
            operator= '%';
            display.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
                case '%' -> result = num1 % num2;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            display.setText("");
        }
        if (e.getSource() == delButton) {
            String text = display.getText();
            display.setText(text.substring(0, text.length() - 1));
        }
    }
    public static void main(String[] args) {
        new JavaCulculatorGUI();
    }
}
