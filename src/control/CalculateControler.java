package control;

import java.beans.Expression;

import model.ExpressionData;

public class CalculateControler {
	
	private ExpressionData exp;
	private String command;
	
	private CommandControler cmdCon;

	/* ========== Flags ========== */
	
	/**
	 * If it's true then '=' was input right before this command
	 */
	private boolean equalsFlag;
	
	/**
	 * If it's true then current state is operand
	 */
	private boolean operandFlag;
	
	/**
	 * If it's true then operator was input right before this command
	 */
	private boolean operatorFlag;
	
	/**
	 * If it's true then current operand already has a floating point
	 */
	private boolean pointFlag;
	
	/**
	 * If it's true then current operand is 0
	 */
	private boolean zeroFlag;
	
	
	public CalculateControler(ExpressionData exp)
	{
		setExp(exp);
		cmdCon = new CommandControler(null);
		setEqualsFlag(false);
		setOperandFlag(true);
		setOperatorFlag(false);
		setPointFlag(false);
		setZeroFlag(true);
	}
	
	
	/* ========== Functional Operations ========== */
	
	public boolean isValid()
	{
		if(command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/") || command.equals("="))
		{
			if(isOperandFlag())
			{
				
			}
		}
		else if(command.equals("B"))
		{
			
		}
		else if(command.equals("C"))
		{
			
		}
		else if(command.equals("."))
		{
			
		}
		else
		{
			
		}
		
		return false;
	}
	
	public void compute(String command)
	{
		
	}
	
	/* ========== Getters and Setters ========== */
	
	public ExpressionData getExp() {
		return exp;
	}

	public void setExp(ExpressionData exp) {
		this.exp = exp;
	}
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	

	private boolean isEqualsFlag() {
		return equalsFlag;
	}

	private void setEqualsFlag(boolean equalsFlag) {
		this.equalsFlag = equalsFlag;
	}

	private boolean isOperandFlag() {
		return operandFlag;
	}

	private void setOperandFlag(boolean operandFlag) {
		this.operandFlag = operandFlag;
	}

	private boolean isOperatorFlag() {
		return operatorFlag;
	}

	private void setOperatorFlag(boolean operatorFlag) {
		this.operatorFlag = operatorFlag;
	}

	private boolean isPointFlag() {
		return pointFlag;
	}

	private void setPointFlag(boolean pointFlag) {
		this.pointFlag = pointFlag;
	}

	private boolean isZeroFlag() {
		return zeroFlag;
	}

	private void setZeroFlag(boolean zeroFlag) {
		this.zeroFlag = zeroFlag;
	}
	
}
