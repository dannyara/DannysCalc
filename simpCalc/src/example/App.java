package example;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

	public class App  extends JFrame{
		private JFrame _view;
		private JPanel _numPanel;
		private JPanel _opPanel;
		private JPanel _screenPanel;
		JButton[] button = new JButton[9];
		public App(String[] args){
			_view= new JFrame("Danny's wack af calculator");
			_view.setLayout(new BorderLayout());
			_screenPanel = new JPanel();
			_numPanel=new JPanel();
			_numPanel.setLayout(new GridLayout());
			for(int i=0; i<9; i++){
				button[i]= new JButton();
				button[i].setText(Integer	.toString(i));
				_screenPanel.add(button[i]);
				
				
				//button[i].setFont(font);
				//button[i].addActionListener(this);
				}
			
			JTextArea display = new JTextArea(1,20);
			//_numPanel.add(comp, constraints);
			_view.add(display);
			_view.add(_numPanel);
			Font font = new Font("Times new Roman", Font.BOLD, 14);
			_view.setFont(font);
			_view.pack();
			_view.setVisible(true);
			_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
}


