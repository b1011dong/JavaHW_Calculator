package controler;

import model.ExpressionData;

public class OperatorControler extends CommandControler {

	public OperatorControler(String command)
	{
		super(command);
	}
	
	@Override
	public boolean isValid() {
		
		if( ExpressionData.getOperand().equals("") && !isEqualsFlag() && !isOperatorFlag() )
			return false;
		return true;
	}
	
	@Override
	public void compute() {
		
		String history = ExpressionData.getHistory();
		String operand = ExpressionData.getOperand();
		String result = ExpressionData.getResult();
		
		if( isPointFlag() )
		{
			operand = operand.substring(0, operand.length() - 1);
			
			setPointFlag(false);
			setHasPointFlag(false);
		}
		
		if( isOperatorFlag() && !isEqualsFlag() )
		{
			history = history.substring( 0, history.length() - 1 );
			history += getCommand();
		}
		else if( ExpressionData.getOperator().equals("/") && isZeroFlag() && !isEqualsFlag() )
		{
			System.out.println("Divide by Zero Exeption!");
			
			operand = "Error!";
		}
		else if( isEqualsFlag() && isZeroFlag() )
		{
			history += getCommand();
		}
		else
		{
			System.out.println("Here?");
			
			try
			{
				result = calculate();
				
				history += operand;
			}
			catch(Exception ex)
			{
				System.out.println("Error occurs during calculating!");
				operand = "Error occurs during calculation!";
			}
			
			history += getCommand();
		}
		
		operand = "";
		
		ExpressionData.setHistory(history);
		
		ExpressionData.setOperand( operand );
		
		ExpressionData.setResult( result );
		
		setEqualsFlag( false );
		setOperandFlag( false );
		setOperatorFlag(true);
		setZeroFlag(true);
		setPointFlag(false);
		setHasPointFlag(false);
	}
	
}
