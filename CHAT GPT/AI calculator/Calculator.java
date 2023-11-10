import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    // Create components
    private TextField textField;
    private Button[] numberButtons;
    private Button addButton, subButton, mulButton, divButton, eqButton, clearButton;
    private double num1, num2, result;
    private char operator;

    public Calculator() {
        // Initialize the frame
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Create text field for display
        textField = new TextField();
        add(textField, BorderLayout.NORTH);

        // Create button panel
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Initialize buttons
        numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(Integer.toString(i));
            numberButtons[i].addActionListener(this);
        }

        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");
        eqButton = new Button("=");
        clearButton = new Button("C");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add buttons to the panel
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(addButton);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subButton);
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(mulButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(eqButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(divButton);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Initialize variables
        num1 = 0;
        num2 = 0;
        operator = ' ';

        // Window close listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Display the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Character.isDigit(command.charAt(0))) {
            textField.setText(textField.getText() + command);
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            operator = command.charAt(0);
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
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
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
        } else if (command.equals("C")) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = ' ';
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
