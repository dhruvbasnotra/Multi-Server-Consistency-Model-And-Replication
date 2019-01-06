import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends javax.swing.JFrame{

	// these are the components we need.
    private final JSplitPane splitPane;  // this is the entire window, we split in in top and bottom
    private final JPanel topPanel, operationPanel, numberPanel;       // container panel for the top, mathOperations and numbers
    private final JSplitPane bottomPanel, mathPanel;    // container panel for the bottom which contains numbers and operations
    private final JScrollPane scrollPane; // makes the textArea scrollable in the topPanel
    private final JTextArea displayWindow;     // the textArea to display all operations done
    private final JPanel inputPanel;      // under the text a container for all the input elements
    private final JTextField displayField;   // a textField for the text the user inputs
    private final JButton endButton;         // and a "send" button
	
    private JButton jbtNum1;
    private JButton jbtNum2;
    private JButton jbtNum3;
    private JButton jbtNum4;
    private JButton jbtNum5;
    private JButton jbtNum6;
    private JButton jbtNum7;
    private JButton jbtNum8;
    private JButton jbtNum9;
    private JButton jbtNum0;
    
    private JButton jbtEqual;
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtClear;
    private JButton jbtNegative;
    
    String equation = "";

    private JTextField answerField;
//    private JTextArea displayWindow;
    
    public Calculator()
    {
    	//initialize the values
        splitPane = new JSplitPane();
        topPanel = new JPanel();         
        bottomPanel = new JSplitPane();      
        mathPanel = new JSplitPane();
        operationPanel = new JPanel();
        numberPanel = new JPanel();
        inputPanel = new JPanel();

        // now lets define the default size of our window and its layout:
        setPreferredSize(new Dimension(600, 600));     // let's open the window with a default size of 600x600 pixels
        // the contentPane is the container that holds all our components
        getContentPane().setLayout(new GridLayout());  // the default GridLayout is like a grid with 1 column and 1 row,
        // we only add one element to the window itself
        getContentPane().add(splitPane);               // due to the GridLayout, our splitPane will now fill the whole window
        
        // let's configure our splitPane:
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window vertically to a topPanel and a bottomPanel
        splitPane.setDividerLocation(200);                    // the initial position of the divider is 300 (our window is 600 pixels high)
        splitPane.setTopComponent(topPanel);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(bottomPanel);            // and at the bottom we want our "bottomPanel"

        // in our topPanel we want the scrollable textArea to display the operations done
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane();  // this scrollPane is used to make the text area scrollable
        displayWindow = new JTextArea();  // this text area will be put inside the scrollPane
        topPanel.add(scrollPane);
        scrollPane.setViewportView(displayWindow);
        
        //in our bottomPanel we want the numbers and operations buttons and the equation textField and endButton
        bottomPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window vertically to mathPanel and inputPanel
        bottomPanel.setDividerLocation(300);       // the initial position of the divider is 300 (our window is 600 pixels high)
        bottomPanel.setTopComponent(mathPanel);                  // at the top we want our "topPanel"
        bottomPanel.setBottomComponent(inputPanel);            // and at the bottom we want our "bottomPanel"

        //now we divide the mathPanel horizontally to the numberPanel and the operationPanel
        mathPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  // we want it to split the window horizontally
        mathPanel.setDividerLocation(450);                    // the initial position of the divider is 450 (our window is 600 pixels high)
        mathPanel.setRightComponent(operationPanel);
        mathPanel.setLeftComponent(numberPanel);
        
        //we add the number buttons to the numberPanel
        numberPanel.setLayout(new GridLayout(4, 3));
        numberPanel.add(jbtNum1 = new JButton("1"));
        numberPanel.add(jbtNum2 = new JButton("2"));
        numberPanel.add(jbtNum3 = new JButton("3"));
        numberPanel.add(jbtNum4 = new JButton("4"));
        numberPanel.add(jbtNum5 = new JButton("5"));
        numberPanel.add(jbtNum6 = new JButton("6"));
        numberPanel.add(jbtNum7 = new JButton("7"));
        numberPanel.add(jbtNum8 = new JButton("8"));
        numberPanel.add(jbtNum9 = new JButton("9"));
        numberPanel.add(jbtNum0 = new JButton("0"));
        numberPanel.add(jbtClear = new JButton("C"));
        numberPanel.add(jbtNegative = new JButton("+/-"));
        
        //we add the operation buttons to the operationPanel
        operationPanel.setLayout(new GridLayout(5, 1));
        operationPanel.setLayout(new GridLayout(5, 1));
        operationPanel.add(jbtAdd = new JButton("+"));
        operationPanel.add(jbtSubtract = new JButton("-"));
        operationPanel.add(jbtMultiply = new JButton("*"));
        operationPanel.add(jbtDivide = new JButton("/"));
        operationPanel.add(jbtEqual = new JButton("="));        
        
        //we add the displayField and the endButton to the inputPanel
        //first let's set the maximum size of the inputPanel, so it doesn't get too big when the user resizes the window
        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     // we set the max height to 75 and the max width to (almost) unlimited
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));   // X_Axis will arrange the content horizontally
        displayField = new JTextField();    // first the input field where the user can type his text
        answerField = new JTextField();
        endButton = new JButton("End Connection");    // and a button at the right, to send the text
        inputPanel.add(displayField);        // left will be the textField
        inputPanel.add(answerField);
        inputPanel.add(endButton);           // and right the "send" button
        
        pack();
        
        jbtNum1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "1");
	        }
	    });
        
        jbtNum2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "2");
	        }
	    });
        
        jbtNum3.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "3");
	        }
	    });
        jbtNum4.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "4");
	        }
	    });
        jbtNum5.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "5");
	        }
	    });
        jbtNum6.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "6");
	        }
	    });
        jbtNum7.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "7");
	        }
	    });
        jbtNum8.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "8");
	        }
	    });
        jbtNum9.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "9");
	        }
	    });
        jbtNum0.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + "0");
	        }
	    });
        jbtClear.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = "";
	    		displayField.setText("");
	    		answerField.setText("");
	    		displayWindow.setText("");
	        }
	    });
        jbtNegative.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	        	String numbers[] = equation.split(" ");
	        	if(numbers.length>1)
	        	{
	        		displayField.setText(equation + "-");
	        	}
	        	else
	        	{
	            	double num = Double.parseDouble(equation);
	            	double answer = num * -1;
	            	displayField.setText(String.valueOf(answer));
	        		answerField.setText(String.valueOf(answer));
	        		displayWindow.append(equation + " * -1 = " + answer + "\n");     //send it to the file
	        	}
	        }
	    });

        jbtAdd.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + " + ");
	        }
	    });
        jbtSubtract.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + " - ");
	        }
	    });
        jbtMultiply.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + " * ");
	        }
	    });
        jbtDivide.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	equation = displayField.getText();
	            displayField.setText(equation + " / ");
	        }
	    });
        jbtEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Double answer;
            	equation = displayField.getText();
            	String numbers[] = equation.split(" ");
            	
            	double num1 = Double.parseDouble(numbers[0]);
            	String operation = numbers[1];
            	double num2 = Double.parseDouble(numbers[2]);
            	
            	switch(operation)
            	{
            	case "+": 
            		answer = num1 + num2 ;
            		displayField.setText(String.valueOf(answer));
            		answerField.setText(String.valueOf(answer));
            		displayWindow.append(equation + " = " + answer + "\n");     //send it to the file
            		break;
            	case "-":
            		answer = num1 - num2;
            		displayField.setText(String.valueOf(answer));
            		answerField.setText(String.valueOf(answer));
            		displayWindow.append(equation + " = " + answer + "\n");     //send it to the file
            		break;
            	case "*":
            		answer = num1 * num2;
            		displayField.setText(String.valueOf(answer));
            		answerField.setText(String.valueOf(answer));
            		displayWindow.append(equation + " = " + answer + "\n");    //send it to the file
            		break;
            	case "/":
            		if(num2 == 0)
            		{
            			displayWindow.append("Incorrect Equation! Cannot divide by zero!!!");
            			displayField.setText("");
            			answerField.setText("");
            		}
            		else
            		{
            			answer = num1 / num2;
            			displayField.setText(String.valueOf(answer));
            			answerField.setText(String.valueOf(answer));
            			displayWindow.append(equation + " = " + answer + "\n");   //send it to the file
            		}
            		break;
            	}
            }
        });
    }

    public static void main(String args[]){
                new Calculator().setVisible(true);
    }
}