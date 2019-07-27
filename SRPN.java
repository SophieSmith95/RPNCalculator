import java.util.*;
import java.io.*;
import java.lang.Math;

class SRPN{
private Stack<String>numbers;
private String operations = "+ - / * ^ % r d";
//private int[] random = {1562469902, 1039845534, 2025653534, 739593874, 994290584, 1198075102, 605335584, 563009619, 1076425455, 1979353639, 3124939804, 2079691068, 4051307068, 1479187748, 198581168, 2396150204, 1210671168, 1126019238, 2152850910, 6249879609, 3541823541, 3119536602, 6076960602, 2218781622, 2982871752, 3594225306, 1816006752, 1689028857, 3229276365, 8229233248};
//private int index = 0;

	public static void main(String[] args){
		SRPN srpn = new SRPN();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String equation = null;
		
		try{
			//While this is true keep accepting input.
			while(true){
				equation = reader.readLine();
				//To close if there is no input (Ctrl-D).
				if(equation == null){
					//Exit code (0) for exit.
					System.exit(0);
				}else{
				//Split the user input into individual objects and place into an array.
					String[] arr = equation.split(" ");
					//Loop through the array and put each object equal to equation
						for(int i=0; i<arr.length; i++){
							equation = arr[i];
					srpn.calculator(equation);
					}
				}
				}
		}catch(IOException e){
			System.err.println("Error");
			System.exit(1);
		}
	}


	public SRPN(){
		numbers = new Stack<String>();
	}
	
//Method used to test if the given input is an operator of not.	
	public static boolean operatorTest(String operator){
		//Looks for an operator in the user input and if there is return true.
		if ( operator.equals( "/" )|| operator.equals( "*" )|| operator.equals( "+" ) || operator.equals( "-" ) || operator.equals( "d") || operator.equals( "%" ) || operator.equals( "=" ) || operator.equals("r") || operator.equals("^")) {
			return true;
		} else {
			return false;
		}
	}
//Method used to check if the size of the stack is greater than or equal 23 and if so
//print out the error but if its less than 23 push the object onto the stack.	
	public void push(String s){
		if(numbers.size() >= 23){
			System.err.println("Stack overflow.");
			//System.out.println();
		}else{
			numbers.push(s);
		}
	}
	
//Method used to process the user input depending on if its an operator or not.		
	public void calculator(String calculation){
//If the method operatorTest returns true carry out the following switch statement
//Depending on the operator found.
		if(operatorTest(calculation) == true){
		switch(calculation){
//In each case 2 integers are popped of the stack and depending on the case an operation
//eg addition is carried out and the answer is the pushed back onto the stack.
			case "+":
				int x = Integer.valueOf(numbers.pop());
				int y = Integer.valueOf(numbers.pop());
				numbers.push(String.valueOf((long)x+(long)y));
				break;
			case "-":
				x = Integer.valueOf(numbers.pop());
				y = Integer.valueOf(numbers.pop());
				numbers.push(String.valueOf((long)y-(long)x));
				break;
			case "/":
				x = Integer.valueOf(numbers.pop());
				y = Integer.valueOf(numbers.pop());
				if(x == 0){
					System.err.println("Divide by 0.");
				}else{
					numbers.push(String.valueOf(y/x));
				}
				break;
			case "*":
				x = Integer.valueOf(numbers.pop());
				y = Integer.valueOf(numbers.pop());
				numbers.push(String.valueOf(x*y));
				break;
			case "%":
				x = Integer.valueOf(numbers.pop());
				y = Integer.valueOf(numbers.pop());
				numbers.push(String.valueOf(y%x));
				break;
			case "^":
				x = Integer.valueOf(numbers.pop());
				y = Integer.valueOf(numbers.pop());
				numbers.push(String.valueOf((int)Math.pow(y,x)));
				break;
			case "d":
				for(String num : numbers){
				System.out.println(num);
				}
				break;
			/*case "r":
  If this method were to work it would check if the value of index is less than the 
  the length of the array 'random'. If it is less than the length of the array then
  what ever the value of index is it will go to that position in the array and print
  it to the screen. The method would then add one to the index so next time the 
  method is called it would have increased one position in the array. If the value
  of index was more than the length of the array then it would reset the value of index
  to zero and would begin again at postion zero of the array.
				if(index <= random.length-1){
				System.out.println(random[index]);
				index++;
				}else{
				index = 0;
				}
				break;*/
			case "=":
				if(numbers.empty() == true){
					System.out.println(0);
				}else{
				String p = numbers.peek();
				System.out.println(p);
				}
				break;
			default:
				System.err.println("Invalid input");
				break;
				}
		}else{
//If operatorTest is false then carry out the push method.
			push(calculation);
		}
		}
}



