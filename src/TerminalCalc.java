package src;

import java.util.Scanner;

public class TerminalCalc{
public static char operation;
public static double val1, val2;
public static double ans;
public static Scanner keyboardInput;
public static void main(String[] args) {
		boolean resetCalc = true;
		
		System.out.println("Welcome to Terminal Calculator!");
		
		while(resetCalc == true){
			boolean isValidEquation = true;
			keyboardInput = new Scanner(System.in);
			try{ 
				getInput(keyboardInput); 
			}
			catch(Exception e) {
				System.out.println("error!!1 \n Try Again");
				System.out.println(e);
				isValidEquation = false;
			}
			
			if(isValidEquation) {
				ans = getAnswer(operation);
				System.out.println(toString(val1, val2, operation));
				reset(resetCalc);
			}
		
		}
	}
	
	public static double mult(double x, double y){
		return x*y;
	}
	public static double div(double x, double y){
		return ((double)x/y);	
	}
	
	static  void getInput(Scanner sc) {
		System.out.println("Enter equation below (use spaces)");

		//if(val1 == (int)val1) val1 = sc.nextInt();
		 val1 = sc.nextDouble();
		
		operation = sc.next().charAt(0);
			
		//if(val2 == (int)val2)	val2 = sc.nextInt();
		 val2 = sc.nextDouble();
			
		
	 }
	 
	 static double getAnswer(char op) {
		 switch (op){
			
			case '+':
				return val1+val2;
				
			
			case '-':
				return (val1-val2);
				
			
			case '*':
				return (mult(val1,val2));
				
			
			case '/':
				if(val1%val2==0) return (val1/val2);
				else return (div(val1,val2));
			
			case '^':
				return(double)(Math.pow(val1, val2));
				
			
			default: 
				System.out.println("invalid equation, try again");	
				return 0;
		}
		
	 }
	 static StringBuilder toString(double v1, double v2, char op) {
		 StringBuilder equation = new StringBuilder(); 
		 
		 if(v1 == (int)v1) equation.append((int)v1);
		 else equation.append(v1);
		
		 equation.append(" "+ op + " " );
		 
		 if(v2 == (int)v2) equation.append((int)v2);
		 else equation.append(v2);
		 
		 equation.append(" = ");
		 
		 if(ans == (int)ans) 
				equation.append((int)ans);
		 else equation.append( ans);
			
		 return equation;
	 }
	 static void reset(boolean resetCalc) {
	 System.out.println("reset? y/n ");	
		Scanner reset = new Scanner(System.in);
		String toContinue = reset.next();
		
			if(toContinue.equals("y")) resetCalc=true;
			else if(toContinue.equals("n")){ 
				reset.close();
				keyboardInput.close();
				resetCalc = false;
				System.exit(0);
			}
			else {
			System.out.println("didn't catch that, try again");
			reset(resetCalc);
		}
	 }

}

