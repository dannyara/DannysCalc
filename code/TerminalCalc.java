package code;

import java.util.Scanner;

public class TerminalCalc {
private static char op;
public static int val1, val2;
	public static void main(String[] args) {
		
		boolean check=true;
		System.out.println("Welcome to Terminal Calculator!");
		while(check==true){
				
			Scanner keyboardInput= new Scanner(System.in);
			
			System.out.println("Enter equation below (use spaces)");
			
			op=' ';
			val1= keyboardInput.nextInt();
			
			op=keyboardInput.next().charAt(0);
			val2=keyboardInput.nextInt();
			String equation = val1 + " "+op+ " "+val2 + " = ";
			System.out.print(equation);
			
			switch (op){
			case '+':
				System.out.println(val1+val2);
				break;
			case '-':
				System.out.println(val1-val2);
				break;
			case '*':
				System.out.println(mult(val1,val2));
				break;
			case '/':
				if(val1%val2==0) System.out.println(val1/val2);
				else System.out.println(div(val1,val2));
				break;
			
			default: 
				System.out.println("invalid equation, try again");	
		}
		
		Scanner reset=new Scanner(System.in);
		System.out.println("Want to reset?"+"\n" +" y/n ");

		if(reset.next().equals("y")) check=true;
		else{ 
			keyboardInput.close();
			reset.close();
			check=false;
		}
		
		
		}
	}
	
	public static int mult(int x, int y){
		return x*y;
	}
	public static double div(int x, int y){
		return ((double)x/y);	
	}
	
}

