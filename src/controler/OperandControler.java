package controler;

import javax.swing.JOptionPane;

import model.ExpressionData;

public class OperandControler extends CommandControler {

	public OperandControler(String command)
	{
		super(command);
	}
	
	@Override
	public boolean isValid() {
		
		if( isEqualsFlag() )
			return false;
		
		return true;
	}

	@Override
	public void compute() {
		
		String operand = ExpressionData.getOperand();
		String operator = "";
		
		if( ExpressionData.getHistory() == "" )
			operator += "+";
		else
			operator += ExpressionData.getHistory().charAt( ExpressionData.getHistory().length() - 1 );
			
		if( isZeroFlag() && !isHasPointFlag() )
			operand = getCommand();
		else
		{
			operand += getCommand();
		}
		
		if( isZeroFlag() && getCommand().equals("0") )
			setZeroFlag( true );
		else
			setZeroFlag(false);
		
		setOperatorFlag(false);
		setEqualsFlag(false);
		setOperandFlag(true);
		setPointFlag(false);
		
		ExpressionData.setOperator(operator);
		ExpressionData.setOperand(operand);
	}

}
