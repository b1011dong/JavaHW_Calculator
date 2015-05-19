package model;

public class Expressions {

	private String resultString;
	private String operandString;
	private String historyString;
	
	public Expressions()
	{
		setResultString("0");
		setOperandString("0");
		setHistoryString("");
	}

	public String getResultString() 
	{
		return resultString;
	}

	public void setResultString(String resultString) 
	{
		this.resultString = resultString;
	}

	public String getOperandString()
{
		return operandString;
	}

	public void setOperandString(String operandString) 
	{
		this.operandString = operandString;
	}

	public String getHistoryString() 
	{
		return historyString;
	}

	public void setHistoryString(String historyString) 
	{
		this.historyString = historyString;
	}
	
}
