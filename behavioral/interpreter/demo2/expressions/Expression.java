package behavioral.interpreter.demo2.expressions;

import behavioral.interpreter.demo2.Employee;

public interface Expression {
	
	public boolean interpret(Employee context);
}
