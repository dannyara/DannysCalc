package code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalcView implements ActionListener{
	private JFrame _view;
	private JPanel _numPanel;
	private JPanel _opPanel;
	private JPanel _screenPanel;
	private JButton[] button = new JButton[10];
	//JButton enter      = new JButton("Enter");
    JButton cButton    = new JButton("C");
    JButton multButton = new JButton("*");
    JButton divButton  = new JButton("/");
    JButton addButton  = new JButton("+");
    JButton subButton  = new JButton("-");
    JButton PosNeg = new JButton("+/-");
    JButton decimal = new JButton(".");
   private  Font font = new Font("Times new Roman", Font.BOLD, 25);
   

	public CalcView(){
		_view= new JFrame("Danny's wack af calculator");
		_view.setLayout(new BorderLayout(0,20));
		_screenPanel = new JPanel();
		_numPanel = new JPanel();
		_numPanel.setLayout(new GridLayout(4,2,20,10));
		_opPanel= new JPanel();
		//_opPanel.setLayout(new BoxLayout(_opPanel,BoxLayout.PAGE_AXIS));
		_opPanel.setLayout(new GridLayout(0,1,20,10));
		Dimension buttonSize=new Dimension(100,100);
		for(int i=9; i>=1; i--){
			button[i] = new JButton();
			button[i].setText(Integer.toString(i));
			button[i].setPreferredSize(buttonSize);
			_numPanel.add(button[i]);
			button[i].setFont(font);
			button[i].addActionListener(this);
			}
		
		button[0] = new JButton();
		button[0].setText(Integer.toString(0));
		//button[0].setPreferredSize(new Dimension(120,120));
		button[0].setSize(buttonSize);
		_numPanel.add(PosNeg);
		_numPanel.add(button[0]);
		_numPanel.add(decimal);
		
		
		JTextArea display = new JTextArea(5,40);
		display.setEditable(false);
		display.setLineWrap(false);
		display.setBackground(Color.white);
		display.update(null);
		
		_screenPanel.add(display);
		JButton eq= new JButton("=");
		eq.setPreferredSize(new Dimension(150,150));
		//_opPanel.setPreferredSize(buttonSize);;
		divButton.setPreferredSize(buttonSize);
		_opPanel.add(divButton);
		
		multButton.setPreferredSize(buttonSize);
		_opPanel.add(multButton);
		
		subButton.setPreferredSize(buttonSize);
		_opPanel.add(subButton);
		
		addButton.setPreferredSize(buttonSize);_opPanel.add(addButton);
		_opPanel.add(addButton);
		
		eq.setPreferredSize(buttonSize);
		_opPanel.add(eq);
	
		_view.add(_screenPanel,BorderLayout.PAGE_START);
		_view.add(_numPanel,BorderLayout.LINE_START);
		_view.add(_opPanel,BorderLayout.LINE_END);
		_view.setFont(font);
		_view.setSize(300,400);
		_view.pack();
		
		_view.setVisible(true);
		_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
