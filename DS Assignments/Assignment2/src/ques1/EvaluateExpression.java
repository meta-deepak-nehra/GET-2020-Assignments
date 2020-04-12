package ques1;

import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression 
{
	static Stack<String> operand = new Stack<String>();
	static Stack<String> operator = new Stack<String>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the infix expression : ");
		String str = sc.nextLine();

		String returnString = evaluateValue(str);

		System.out.println("String after evaluation is : " + returnString);
		sc.close();
	}

	static String evaluateValue(String str) {
		operator.push("#");
		int i=0;
		while( i<str.length() ) {
			// for white spaces and tabs to avoid them
			if( str.charAt(i) == 32 ) {
				i++;
			} else {
				if( Character.isDigit(str.charAt(i)) ) {
					String num = "";
					while( i<str.length() && Character.isDigit(str.charAt(i)) ) {
						num += str.charAt(i);
						i++;
					}
					operand.push(num);
				} else {

					if( isOperator( str.charAt(i) ) ) {
						String opt = "";
						while( i<str.length() && isOperator(str.charAt(i)) ) {
							opt += str.charAt(i);
							i++;
						}
						if( isValidOperator(opt) ) {
							if( prece(opt)>prece(operator.peek()) ) {
								operator.push(opt);
							} else {
								while( prece(opt)<=prece(operator.peek()) ) {
									String value = operation( operand.pop(),operand.pop(),operator.pop() );
									
									// for the case where values are not similar
									if(value.equalsIgnoreCase("error")) {
										System.out.println("There is an error while performing the operation");
										return "Error";
									}
									operand.push(value);
								}
								operator.push(opt);
							}
						} else {
							System.out.println("Operator is not valid.");
						}
					}
				}
			}
		}

		while( operator.peek()!="#" ) {
			String value = operation( operand.pop(),operand.pop(),operator.pop() );
			operand.push(value);
		}
		return operand.pop();
	}

	static String operation( String b, String a, String op ) {
		switch( op ) {
		case "+":
			String str = Integer.toString( Integer.parseInt(a) + Integer.parseInt(b) );
			return str;
		case "-":
			str = Integer.toString( Integer.parseInt(a) - Integer.parseInt(b) );
			return str;
		case "*":
			str = Integer.toString( Integer.parseInt(a) * Integer.parseInt(b) );
			return str;
		case "/":
			str = Integer.toString( Integer.parseInt(a) / Integer.parseInt(b) );
			return str;
		case "==":
			if( isInteger(a) && isInteger(b) ) {
				if( Integer.parseInt(a) == Integer.parseInt(b) ) {
					return "true";
				} else {
					return "false";
				}
			}
			else if( isBoolean(a) && isBoolean(b) ) {
				if( a.equalsIgnoreCase(b) ){
					return "true";
				} else {
					return "false";
				}
			} else {
				return "error";
			}
		case "<":
			if( Integer.parseInt(a) < Integer.parseInt(b) ) {
				return "true";
			}
			return "false";
		case ">":
			if( Integer.parseInt(a) > Integer.parseInt(b) ) {
				return "true";
			}
			return "false";
		case ">=":
			if( Integer.parseInt(a) >= Integer.parseInt(b) ) {
				return "true";
			}
			return "false";
		case "<=":
			if( Integer.parseInt(a) <= Integer.parseInt(b) ) {
				return "true";
			}
			return "false";
		case "!=":
			if( Integer.parseInt(a) != Integer.parseInt(b) ) {
				return "true";
			}
			return "false";
		case "&&":
			if( isBoolean(a) && isBoolean(b) ) {
				if( Boolean.parseBoolean(a) && Boolean.parseBoolean(b) ) {
					return "true";
				} else {
					return "false";
				}
			}
			return "error";
		case "||":
			if( isBoolean(a) && isBoolean(b) ) {
				if( Boolean.parseBoolean(a) || Boolean.parseBoolean(b) ) {
					return "true";
				} else {
					return "false";
				}
			}
			return "error";
		default :
			System.out.println("No such operator possible");
			return "error";
		}

	}
	
	static boolean isInteger(String checkInt) {
		try {
	        Integer.parseInt(checkInt);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
		return true;
	}

	static boolean isBoolean(String checkBool) {
		if( checkBool.equalsIgnoreCase("true") || checkBool.equalsIgnoreCase("false") ) {
			return true;
		}
		return false;
	}

	static boolean isOperator(char ch) {
		if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='<' || ch=='>' || ch=='!' || ch=='&' || ch=='|' || ch=='=' ) {
			return true;
		}
		return false;
	}

	static boolean isValidOperator(String var) {
		if( var.equalsIgnoreCase("+") || var.equalsIgnoreCase("-") || var.equalsIgnoreCase("*") || var.equalsIgnoreCase("/") || var.equalsIgnoreCase("==") || var.equalsIgnoreCase("!=") || var.equalsIgnoreCase("<=") || var.equalsIgnoreCase(">=") || var.equalsIgnoreCase("&&") || var.equalsIgnoreCase("||") || var.equalsIgnoreCase("<") || var.equalsIgnoreCase(">") ) {
			return true;
		}
		return false;
	}

	static int prece(String op) {
		switch(op) {
		case "*":
		case "/":
			return 7;
		case "+":
		case "-":
			return 6;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 5;
		case "==":
		case "!=":
			return 4;
		case "&&":
			return 3;
		case "||":
			return 2;
		case "#":
			return 0;
		default :
			System.out.println("Not a valid operator");
			return -1;

		}
	}
}
