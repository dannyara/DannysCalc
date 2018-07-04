package src;

import java.util.Scanner;

public class TerminalCalc{
public static char operation;
public static int val1, val2;
public static double ans;
	public static void main(String[] args) {
		
		boolean resetCalc = true;
		System.out.println("Welcome to Terminal Calculator!");
		
		while(resetCalc == true){

			Scanner keyboardInput = new Scanner(System.in);
			try{
				getInput(keyboardInput);
			}catch(Exception e) {
				System.out.println("error!!1 \n Try Again");
				keyboardInput.reset();
				getInput(keyboardInput);
			}
			ans = getAnswer(operation);
			String equation = val1 + " " + operation + " "+ val2 + " = "; 
			if(ans == (int)ans) 
				equation += (int)ans;
			else equation += ans;
			
			System.out.println(equation);
			
			
		Scanner reset =new Scanner(System.in);
		
		System.out.println("reset? y/n ");
		String toContinue = reset.next();
		try{
			if(toContinue.equals("y")) resetCalc=true;
			else{ 
				reset.close();
				keyboardInput.close();
				resetCalc = false;
				
				System.exit(-1);
				
			}
		}catch (Exception e){
			
			System.out.println("didn't choose anything");
			reset.close();
		}
		
		}
	}
	
	public static int mult(int x, int y){
		return x*y;
	}
	public static double div(int x, int y){
		return ((double)x/y);	
	}
	
	static  void getInput(Scanner sc) {
		System.out.println("Enter equation below (use spaces)");
	//	try{
		
			val1 = sc.nextInt();
			operation = sc.next().charAt(0);
			val2 = sc.nextInt();
			
		//} catch (Exception e){
		//	System.out.println("error, try again \r Exception thrown was: " + e);
			
	//	}
		
	 }
	 
	 static double getAnswer(char op) {
		 switch (op){
			
			case '+':
				return (double)val1+val2;
				
			
			case '-':
				return (double)(val1-val2);
				
			
			case '*':
				return (mult(val1,val2));
				
			
			case '/':
				if(val1%val2==0) return (double)(val1/val2);
				else return (double)(div(val1,val2));
			
			case '^':
				return(double)(Math.pow(val1, val2));
				
			
			default: 
				System.out.println("invalid equation, try again");	
				return 0;
		}
		
	 }


}

