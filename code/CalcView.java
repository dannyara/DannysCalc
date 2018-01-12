package code;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;



public class CalcView implements ActionListener{
//variables	

	private double number1 = 0.0;
	private double number2 = 0.0;

	public JFrame _view;
	JPanel _numPanel;
	JPanel _opPanel;
	JPanel _screenPanel;
	JButton[] button = new JButton[10];
	
    JButton cButton 	= new JButton("CL");
    JButton del			= new JButton("Del");
    JButton multButton = new JButton("×");
    JButton divButton  = new JButton("÷");
    JButton addButton  = new JButton("+");
    JButton subButton  = new JButton("-");
    JButton PosNeg = new JButton("±");
    JButton decimal = new JButton(".");
    JButton eq = new JButton("=");
    private final JTextArea display = new JTextArea(2,20);
   private EmptyBorder b = new EmptyBorder(10, 10, 10, 10);
   private  Font font = new Font("Calibri", Font.BOLD, 25);
   private int operation = 0;
   

	public CalcView(){
		//set Frames and panels with dimensions
		_view= new JFrame("Danny's calculator");
		_view.setLayout(new BorderLayout(0,20));
		_screenPanel = new JPanel();
		_screenPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		Container delete = new Container();
		delete.setLayout(new BoxLayout(delete,1));
	//	delete.setLayout(new GridLayout(2,1,10,10));
		_numPanel = new JPanel();
		_numPanel.setLayout(new GridLayout(4,2,20,20));
		_numPanel.setPreferredSize(new Dimension(300,300));
		_numPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		_numPanel.setBorder(b);
		
		_opPanel = new JPanel();
		_opPanel.setLayout(new GridLayout(0,1,20,10));
		_opPanel.setBorder(b);
		_opPanel.setSize(new Dimension(100,200));
		
//number buttons
		
		Dimension buttonSize=new Dimension(80,80);
		for(int i=9; i>=1; i--){
			button[i] = new JButton();
			button[i].setText(Integer.toString(i));
			button[i].setPreferredSize(buttonSize);
			button[i].setFont(font);
			button[i].addActionListener(this);
			button[i].setFocusable(false);
			_numPanel.add(button[i]);
			
			}
		
	//last row
		button[0] = new JButton("0");
		button[0].setPreferredSize(buttonSize);
		button[0].setFont(font);
		button[0].addActionListener(this);
		button[0].setFocusable(false);
		
		PosNeg.addActionListener(this);
		PosNeg.setFont(font);
		PosNeg.setFocusable(false);
		decimal.addActionListener(this);
		decimal.setFont(font);
		decimal.setFocusable(false);
		_numPanel.add(PosNeg);
		_numPanel.add(button[0]);
		_numPanel.add(decimal);
		
		
		
		//display.setLineWrap(false);
		display.setEditable(false);
		display.setMaximumSize(new Dimension(5,20));
		display.setCaretPosition(0);
		// display.setBackground(Color.white);
		display.setText("");
		display.setFont(new Font("Calibri", Font.PLAIN, 24));
		_screenPanel.add(display);
		//display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
// operation buttons
		
		divButton.setPreferredSize(buttonSize);
		divButton.setFont(font);
		_opPanel.add(divButton);
		divButton.addActionListener(this);
		divButton.setFocusable(false);
		
		multButton.setPreferredSize(buttonSize);
		multButton.setFont(font);
		_opPanel.add(multButton);
		multButton.addActionListener(this);
		multButton.setFocusable(false);
		
		subButton.setPreferredSize(buttonSize);
		subButton.setFont(font);
		subButton.addActionListener(this);
		_opPanel.add(subButton);
		subButton.setFocusable(false);
		
		addButton.setPreferredSize(buttonSize);
		addButton.setFont(font);
		addButton.addActionListener(this);
		_opPanel.add(addButton);
		addButton.setFocusable(false);
		
		eq.setPreferredSize(buttonSize);
		eq.setFont(font);
		eq.addActionListener(this);
		eq.setFocusable(false);
		_opPanel.add(eq);
		//_opPanel.addKeyListener(this);
	
		
		delete.add(cButton);
		cButton.addActionListener(this);
		cButton.setFocusable(false);
		cButton.setSize(30,30);
		delete.add(del);
		del.addActionListener(this);
		del.setFocusable(false);
		del.setSize(30, 30);
		_screenPanel.add(delete);
		
		
//add everything to jFrame		
		_view.add(_screenPanel,BorderLayout.PAGE_START);
		_view.add(_numPanel,BorderLayout.LINE_START);
		_view.add(_opPanel,BorderLayout.LINE_END);
		_view.setFont(font);
		_view.setSize(500,350);
		_view.setMinimumSize(new Dimension(400,500));
		_view.setResizable(false);
		setDesign();
		_view.setFocusable(true);
		
		// _numPanel.getInputMap().put(KeyStroke.getKeyStroke("W"),"forward");
		
		_view.pack();
		_view.setVisible(true);
		_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		 addKeyBinding(_numPanel,KeyEvent.VK_0, "0",(evt)-> { 
			 display.append("0"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_1, "1",(evt)-> { 
			 display.append("1"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_2, "2",(evt)-> { 
			 display.append("2"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_3, "3",(evt)-> { 
			 display.append("3"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_4, "4",(evt)-> { 
			 display.append("4"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_5, "5",(evt)-> { 
			 display.append("5"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_6, "6",(evt)-> { 
			 display.append("6"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_7, "7",(evt)-> { 
			 display.append("7"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_8, "8",(evt)-> { 
			 display.append("8"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_9, "9",(evt)-> { 
			 display.append("9"); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_ENTER, "enter",(evt)-> { 
			 enter();
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_PERIOD, ".",(evt)-> { 
			 if(!display.getText().contains(".")) display.append("."); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_A, "+",(evt)-> { 
			 add(); 
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_S, "-",(evt)-> { 
			 subtract();
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_X, "*",(evt)-> { 
			 multiply();
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_C, "cl",(evt)-> { 
			 clear();
			 });
		 addKeyBinding(_numPanel,KeyEvent.VK_BACK_SPACE, "del",(evt)-> { 
			 delete();
			 });
		 
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
		if(e.getSource() == decimal){
			if(!display.getText().contains(".")) display.append(".");
		}
	//operations
		if(e.getSource() == divButton) divide();
		if(e.getSource() == multButton) multiply();
		if(e.getSource() == addButton) add();
		if(e.getSource() == subButton) subtract();
		if(e.getSource() == eq) enter();
		if(e.getSource() == PosNeg) negate();
		if(e.getSource() == cButton) clear();
		if(e.getSource() == del) delete();
		
		
		
		
	}
	
	public static void addKeyBinding(JComponent c, int keyCode, String id, ActionListener al) {
		InputMap inMap = c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actMap = c.getActionMap();
		
		inMap.put(KeyStroke.getKeyStroke(keyCode, 0,false), id );
		
		actMap.put(id, new AbstractAction(){
			private static final long serialVersionUID = 1L; //added 1/12/18

			@Override
			public void actionPerformed(ActionEvent e) {
				al.actionPerformed(e);
				//System.out.println(id + " key was registered");
			}
			
		});
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
	public void delete(){
		try{
			String s = display.getText();
			display.setText(s.substring(0,s.length()-1));
			
		}catch(NullPointerException e){}
	}
	public void negate(){
			try {
	        double value = Double.parseDouble(display.getText());
	        
	            value = (-1)*value ;
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
