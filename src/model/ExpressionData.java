package model;

public class ExpressionData {

	private static String result;
	private static String operand;
	private static String history;
	private static String operator;
	
	/**
	 * 
	 * @param result
	 * @param operand
	 * @param history
	 * @param operator
	 */
	public ExpressionData(String result, String operand, String history, String operator)
	{
		setResult(result);
		setOperand(operand);
		setHistory(history);
		setOperator(operator);
	}
	
	public ExpressionData()
	{
		setResult("0.0");
		setOperand("");
		setHistory("");
		setOperator("+");
	}

	public static String getResult() {
		return result;
	}

	public static void setResult(String _result) {
		result = _result;
	}

	public static String getOperand() {
		return operand;
	}

	public static void setOperand(String _operand) {
		operand = _operand;
	}

	public static String getHistory() {
		return history;
	}

	public static void setHistory(String _history) {
		history = _history;
	}

	public static String getOperator() {
		return operator;
	}

	public static void setOperator(String operator) {
		ExpressionData.operator = operator;
	}
	
	
	
}
