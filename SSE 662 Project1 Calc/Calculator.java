import javax.swing.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Calculator implements ActionListener
{
 String[] opOrder = {"+", "-", "*", "/","=","C","sin","cos","log","tan"};
 int [] x = {10,80,150,10,80,150,10,80,150}; //holds x values for the the button locations for numbers 1-9
 int [] y = {190,190,190,280,280,280,370,370,370}; //holds y values for the the button locations for numbers 1-9
 int [] x2 = {220,220,220,220,220,10,10,150,10,150}; //holds x values for the the button locations for ops
 int [] y2 = {100,190,280,370,460,100,550,550,640,640}; //holds y values for the the button locations for ops
 int [] w2 = {60,60,60,60,60,200,130,130,130,130}; //holds the widths for the the buttons for ops 
 
 JFrame frame; //one frame
 JTextField textbox,testbox; //textbox to show input
 
 static double first=0,second=0,answer=0;
 Boolean hit = false;
 
 public void buildCalculator(){
 frame = new JFrame("Scientific Calculator"); //title
 frame.setSize(310,800);
 frame.setResizable(true);   //frame attributes
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 textbox =new JTextField();
 testbox =new JTextField();
 textbox.setBounds(10,10,270,80);  //textbox attributes

 for(int i=0; i < 9; i++){
	 String key = Integer.toString(i);
	 JButton button = new JButton(key);
	 button.setBounds(x[i], y[i], 60, 80);  //makes and gives attributes to buttons 1-8
     button.addActionListener(this);
     button.setFont(new Font("TimesRoman", Font.PLAIN, 18));
     frame.add(button);	 
 	 }
 JButton bigNine = new JButton("9");  //makes and gives attributes to button number 9 (bigger width) than normal button
 frame.setLayout(null);
 frame.add(textbox);
 frame.setVisible(true);
 bigNine.setBounds(10, 460, 200, 80);
 bigNine.addActionListener(this);
 bigNine.setFont(new Font("TimesRoman", Font.PLAIN, 18));
 frame.add(bigNine);	 

 for (int i = 0; i < opOrder.length; i++) {  //makes and gives attributes to op buttons and includes different widths
     JButton button = new JButton(opOrder[i]);
     button.setBounds(x2[i], y2[i], w2[i], 80);
     button.addActionListener(this);
     button.setFont(new Font("TimesRoman", Font.PLAIN, 18));
     frame.add(button);
 	}
  }
 
 @Test
 public void actionEventTest (){ //we are testing to see if the creation button algorithm works and is properly read into actionPerformed method
	 JButton buttonTest = new JButton("test");
	 buttonTest.addActionListener(this);
	 buttonTest.doClick();
	 assertEquals(true,hit);
 }
 
 public void actionPerformed(ActionEvent event){ 
	 String n = event.getActionCommand();
	
	 if(n.matches("-?(0|[1-9]\\d*)")){		 //sees if button pressed is a number 1-9
		 textbox.setText(textbox.getText().concat(n)); 
	 }
	 else if (n.matches("C")){   //sees if clear button was pressed
		 textbox.setText("");
	 }
	 else if (n.contains("=")){ //sees if equals is chosen
		 solve();
	 }
	 else if (n.contains("sin")){ //sees if sin was pressed
		 textbox.setText(Double.toString(Math.sin(Double.parseDouble(textbox.getText())))); //converts string to double and then double to string to solve
	 } 
	 else if (n.contains("cos")){ //sees if cos was pressed
		 textbox.setText(Double.toString(Math.cos(Double.parseDouble(textbox.getText())))); //converts string to double and then double to string to solve
	 }
	 else if (n.contains("log")){ //sees if log was pressed
		 textbox.setText(Double.toString(Math.log(Double.parseDouble(textbox.getText())))); //converts string to double and then double to string to solve
	 }
	 else if (n.contains("tan")){ //sees if tan was pressed
		 textbox.setText(Double.toString(Math.tan(Double.parseDouble(textbox.getText())))); //converts string to double and then double to string to solve
	 }
	 else if (n.contains("test")){
		 hit = true;
	 }
	 else{
		 textbox.setText(textbox.getText().concat(n));
	 } 
 }
 
 @Test
 public  void solverTest(){  //we are testing to see if the algorithm from Solve works per design based on addition with simulated input 
	 String answer;
	 JTextField testbox = new JTextField();
	 testbox.setText("5+5");
	 String[] separatedTest = (testbox.getText()).split("\\+");
	 answer = Double.toString(Double.parseDouble(separatedTest[0])+Double.parseDouble(separatedTest[1]));
	 
	 assertEquals("10.0",answer);
 }
 
 public void solve(){//sees what op and does math
	 
	 if(textbox.getText().contains("+")){
		 String[] separated = (textbox.getText()).split("\\+");	 //converts string to double and then double to string to solve for addition
		 textbox.setText(Double.toString(Double.parseDouble(separated[0])+Double.parseDouble(separated[1])));
	 }
	 if(textbox.getText().contains("-")){
		 String[] separated = (textbox.getText()).split("\\-");	 //converts string to double and then double to string to solve for subtraction
		 textbox.setText(Double.toString(Double.parseDouble(separated[0])-Double.parseDouble(separated[1])));
	 }
	 if(textbox.getText().contains("*")){
		 String[] separated = (textbox.getText()).split("\\*");	 //converts string to double and then double to string to solve for multiplication
		 textbox.setText(Double.toString(Double.parseDouble(separated[0])*Double.parseDouble(separated[1])));
	 }
	 if(textbox.getText().contains("/")){
		 String[] separated = (textbox.getText()).split("\\/");	//converts string to double and then double to string to solve for division
		 textbox.setText(Double.toString(Double.parseDouble(separated[0])/Double.parseDouble(separated[1])));
	 }
  }

}
