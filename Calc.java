package code;
import java.util.*;
import java.util.Scanner;



public class Calc {
	
	
	public static void main(String[] args) {
		new CalcView();
		
		boolean r=true;
		
		while(r==true ){
			
		Scanner input= new Scanner(System.in);
		System.out.println("Enter equation below (use spaces)");
		int val1,val2;
		char op=' ';
		val1= input.nextInt();
		System.out.println(val1);
		op=input.next().charAt(0);
		val2=input.nextInt();
		System.out.print(""+val1+op+val2+" = ");
		
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
			System.out.println("oops, try again");	
		}
		
		Scanner reset=new Scanner(System.in);
		System.out.println("Want to reset? y/n ");
		if(reset.next().equals("y")) r=true;
		else{ 
			input.close();
			reset.close();
			r=false;
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
