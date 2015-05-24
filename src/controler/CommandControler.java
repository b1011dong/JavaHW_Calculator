package controler;

import model.ExpressionData;

public abstract class CommandControler{

	private String command;
	
	/* ========== Flags ========== */
	
	/**
	 * If it's true then history is empty
	 */
	private static boolean emptyFlag;
	
	/**
	 * If it's true then '=' was input right before this command
	 */
	private static boolean equalsFlag;
	
	/**
	 * If it's true then current state is operand
	 */
	private static boolean operandFlag;
	
	/**
	 * If it's true then operator was input right before this command
	 */
	private static boolean operatorFlag;
	
	/**
	 * If it's true then current operand already has a floating point
	 */
	private static boolean hasPointFlag;
	
	/**
	 * If it's true then point input right before this command
	 */
	private static boolean pointFlag;
	
	/**
	 * If it's true then current operand is 0
	 */
	private static boolean zeroFlag;
	
	
	/* ========== Constructors ========== */
	
	public CommandControler() {
		setEmptyFlag(true);
		setEqualsFlag(false);
		setOperandFlag(true);
		setOperatorFlag(false);
		setPointFlag(false);
		setZeroFlag(true);
	}
	
	public CommandControler(String command) {
		setCommand(command);
	}
	
	
	/* ========== Abstract Methods ========== */
	
	public abstract boolean isValid();
	public abstract void compute();
	
	
	/* ========== Functional Methods ========== */
	
	public String calculate()
	{
		Double result = null;
		
		if( ExpressionData.getOperator().equals("+") ) {
			result = Double.parseDouble( ExpressionData.getResult() ) + Double.parseDouble( ExpressionData.getOperand() );
		}
		else if( ExpressionData.getOperator().equals("-") ) {
			result = Double.parseDouble( ExpressionData.getResult() ) - Double.parseDouble( ExpressionData.getOperand() );
		}
		else if( ExpressionData.getOperator().equals("*") ) {
			result = Double.parseDouble( ExpressionData.getResult() ) * Double.parseDouble( ExpressionData.getOperand() );
		}
		else if( ExpressionData.getOperator().equals("/") ) {
			result = Double.parseDouble( ExpressionData.getResult() ) / Double.parseDouble( ExpressionData.getOperand() );
		}
		
		return Double.toString( result );
	}
	
	
	/* ========== Getters ans Setters ========== */
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
	
	public static boolean isEqualsFlag() {
		return equalsFlag;
	}

	public static void setEqualsFlag(boolean _equalsFlag) {
		equalsFlag = _equalsFlag;
	}

	public static boolean isOperandFlag() {
		return operandFlag;
	}

	public static void setOperandFlag(boolean _operandFlag) {
		operandFlag = _operandFlag;
	}

	public static boolean isOperatorFlag() {
		return operatorFlag;
	}

	public static void setOperatorFlag(boolean _operatorFlag) {
		operatorFlag = _operatorFlag;
	}

	public static boolean isPointFlag() {
		return pointFlag;
	}

	public static void setPointFlag(boolean _pointFlag) {
		pointFlag = _pointFlag;
	}

	public static boolean isZeroFlag() {
		return zeroFlag;
	}

	public static void setZeroFlag(boolean _zeroFlag) {
		zeroFlag = _zeroFlag;
	}
	
	public static boolean isEmptyFlag() {
		return emptyFlag;
	}

	public static void setEmptyFlag(boolean _emptyFlag) {
		emptyFlag = _emptyFlag;
	}

	public static boolean isHasPointFlag() {
		return hasPointFlag;
	}

	public static void setHasPointFlag(boolean hasPointFlag) {
		CommandControler.hasPointFlag = hasPointFlag;
	}
	
}
