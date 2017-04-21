package code;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalcView implements ActionListener{
//variables	

	private double number1 = 0.0;
	private double number2 = 0.0;

	 JFrame _view;
	JPanel _numPanel;
	JPanel _opPanel;
	JPanel _screenPanel;
	JButton[] button = new JButton[10];
	
	//JButton enter      = new JButton("Enter");
    JButton cButton    = new JButton("CL");
    JButton multButton = new JButton("*");
    JButton divButton  = new JButton("/");
    JButton addButton  = new JButton("+");
    JButton subButton  = new JButton("-");
    JButton PosNeg = new JButton("+/-");
    JButton decimal = new JButton(".");
    JButton eq = new JButton("=");
    JTextArea display = new JTextArea(2,22);
   private  Font font = new Font("Calibri", Font.BOLD, 25);
   private int operation = 0;
   

	public CalcView(){
		//set Frames and panels with dimensions
		_view= new JFrame("Danny's wack af calculator");
		_view.setLayout(new BorderLayout(0,20));
		_screenPanel = new JPanel();
		_numPanel = new JPanel();
		_numPanel.setLayout(new GridLayout(4,2,20,10));
		_numPanel.setPreferredSize(new Dimension(300,300));
		_numPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		_opPanel= new JPanel();
		//_opPanel.setLayout(new BoxLayout(_opPanel,BoxLayout.PAGE_AXIS));
		_opPanel.setLayout(new GridLayout(0,1,20,10));
		_opPanel.setPreferredSize(new Dimension(100,200));
		
//number buttons
		
		Dimension buttonSize=new Dimension(80,80);
		for(int i=9; i>=1; i--){
			button[i] = new JButton();
			button[i].setText(Integer.toString(i));
			button[i].setPreferredSize(buttonSize);
			_numPanel.add(button[i]);
			button[i].setFont(font);
			button[i].addActionListener(this);
			}
	//last roww
		button[0] = new JButton("0");
		button[0].setPreferredSize(buttonSize);
		button[0].setFont(font);
		button[0].addActionListener(this);
		PosNeg.addActionListener(this);
		PosNeg.setFont(font);
		decimal.addActionListener(this);
		decimal.setFont(font);
		_numPanel.add(PosNeg);
		_numPanel.add(button[0]);
		_numPanel.add(decimal);
		//_numPanel.setBorder(new Border(10,10));
		//_numPanel.setSize(200,200);
		
		//display.setEditable(false);
		display.setLineWrap(false);
		display.setCaretPosition(0);
		display.setBackground(Color.white);
		display.setText("");
		display.setFont(new Font("Calibri", Font.PLAIN, 20));
		_screenPanel.add(display);
		// display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
// operation buttons
		
		divButton.setPreferredSize(buttonSize);
		divButton.setFont(font);
		_opPanel.add(divButton);
		divButton.addActionListener(this);
		
		multButton.setPreferredSize(buttonSize);
		multButton.setFont(font);
		_opPanel.add(multButton);
		multButton.addActionListener(this);
		
		subButton.setPreferredSize(buttonSize);
		subButton.setFont(font);
		subButton.addActionListener(this);
		_opPanel.add(subButton);
		
		addButton.setPreferredSize(buttonSize);
		addButton.setFont(font);
		addButton.addActionListener(this);
		_opPanel.add(addButton);
		
		eq.setPreferredSize(buttonSize);
		eq.setFont(font);
		eq.addActionListener(this);
		_opPanel.add(eq);
	
		
		_screenPanel.add(cButton);
		cButton.addActionListener(this);
		
//add everything to jFrame		
		_view.add(_screenPanel,BorderLayout.PAGE_START);
		_view.add(_numPanel,BorderLayout.LINE_START);
		_view.add(_opPanel,BorderLayout.LINE_END);
		_view.setFont(font);
		_view.setSize(500,350);
		_view.setMinimumSize(new Dimension(400,500));
		setDesign();
		_view.pack();
		_view.setVisible(true);
		_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


// click operation  
	@Override
	public void actionPerformed(ActionEvent e) {
	
	//numbers
		if(e.getSource() == button[0]) display.append("0");
		if(e.getSource() == button[1]) display.append("1");
		if(e.getSource() == button[2]) display.append("2");
		if(e.getSource() == button[3]) display.append("3");
		if(e.getSource() == button[4]) display.append("4");
		if(e.getSource() == button[5]) display.append("5");
		if(e.getSource() == button[6]) display.append("6");
		if(e.getSource() == button[7]) display.append("7");
		if(e.getSource() == button[8]) display.append("8");
		if(e.getSource() == button[9]) display.append("9");
		if(e.getSource() == decimal) display.append(".");
	//operations
		if(e.getSource() == divButton) divide();
		if(e.getSource() == multButton) multiply();
		if(e.getSource() == addButton) add();
		if(e.getSource() == subButton) subtract();
		if(e.getSource() == eq) enter();
		if(e.getSource() == PosNeg) negate();
		if(e.getSource() == cButton) clear();
		
		
		
		
	}

	public void enter(){
	
		number2 = Double.parseDouble(display.getText());
		switch(operation){
		case 1: 
			// display.setText(Double.toString((Math.round((number1 / number2) * 100)) / 100));
			 display.setText(Double.toString(number1 / number2));
			 display.setCaretPosition(0);
			 break;
		case 2:
			display.setText(Double.toString(number1 * number2));
			display.setCaretPosition(0);
			break;
		case 3:
			display.setText(Double.toString(number1 - number2));
			display.setCaretPosition(0);
			break;
		case 4:
			display.setCaretPosition(0);
			display.setText(Double.toString(number1 + number2));
		}
	}
	public void clear(){
		try{
			display.setText("");
				 operation = 0;
				 number1 = 0;
				 number2 = 0;
			} catch(NullPointerException e){}
		}
	public void negate(){
			try {
	        double value = Double.parseDouble(display.getText());
	        
	            value = -1*value ;
	            display.setText(Double.toString(value));
	       
			} catch(NumberFormatException e) {
		}
	}
	public void divide(){
		try{
			number1 = Double.parseDouble(display.getText());
			display.setText("");
			operation = 1;
			
		}catch(NullPointerException e){}
	}
	public void multiply(){
		try{
			number1 = Double.parseDouble(display.getText());
			display.setText("");
			
			operation = 2;
		}catch(NullPointerException e){}
	}
	public void subtract(){
		try{
			number1 = Double.parseDouble(display.getText());
			display.setText("");
			operation = 3;
		} catch(NullPointerException e){}
	}
	public void add(){
		try{
			number1 = Double.parseDouble(display.getText());
			display.setText("");
			operation = 4;
					
		} catch(NullPointerException e){}
	}
	
	public final void setDesign() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {   
        }
    }
}
