package answer.part1;

public class Ex04 {
	public static void main(String[] args) {
		int a = 0,b = 0,c = 0;
		//a	
		//if(a>b) then c =0; 	
			//then cannot be resolved to a variable
		//b 
		//if a>b { c = 0;}
			//Syntax error on token "if", ( expected after this token
			//Syntax error, insert ") Statement" to complete IfStatement
		//c
		if (a>b) c = 0; 
		//d
		//if (a>b) c = 0 else b = 0;
			//Syntax error, insert ";" to complete Statement
	}
}
