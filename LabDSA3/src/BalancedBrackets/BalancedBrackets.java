package BalancedBrackets;
import java.util.Stack;

public class BalancedBrackets {
	public static void main(String[] args) {
	String bracketExpression = "( [ [ { } ] ] )";
	
	if(checkBalance(bracketExpression)) {
		System.out.println("Balance Brackets");
	}else {
		System.out.println("Not Balance Brackets");
	}
}

public static  boolean checkBalance(String bracketExpression) {

	Stack<Character> stack = new Stack<>();
	for (int i = 0; i < bracketExpression.length(); i++) {

		char a = bracketExpression.charAt(i);
		if (a == '(' || a == '[' || a == '{') {
			stack.push(a);
			continue;
		}
		if (stack.isEmpty())
			return false;
		char c;
		switch (a) {
		case '}':
			c = stack.pop();
			if (c == '(' || c == '[')
				return false;

			break;
		case ')':
			c = stack.pop();
			if (c == '{' || c == '[')
				return false;
			break;
		case ']':
			c = stack.pop();
			if (c == '(' || c == '{')
				return false;
			break;
		default:
			break;
		}
	}
	return stack.isEmpty();
}
}
