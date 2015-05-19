package model;

public class ExpressionData {

	private String result;
	private String operand;
	private String history;
	private String operator;
	
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getOperand() {
		return operand;
	}

	public void setOperand(String operand) {
		this.operand = operand;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
