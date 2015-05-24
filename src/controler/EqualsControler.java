package controler;

import model.ExpressionData;

public class EqualsControler extends OperatorControler {

	public EqualsControler(String command)
	{
		super(command);
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
			
			ExpressionData.setHistory(history);
			setOperatorFlag(false);
		}
		else if( ExpressionData.getHistory() == "")
		{
		}
		else if( ExpressionData.getOperator().equals("/") && isZeroFlag() )
		{
			System.out.println("Divide by Zero Exeption!");
			
			operand = "Error!";
			ExpressionData.setOperand( operand );
		}
		else
		{
			try
			{
				result = calculate();
			}
			catch(Exception ex)
			{
				System.out.println("Error occurs during calculating!");
			}
			
			history += operand;
			ExpressionData.setOperand("");
			
			ExpressionData.setHistory(history);
			
			ExpressionData.setResult( result );
			
			setEqualsFlag(true);
			setOperandFlag(false);
			setOperatorFlag(true);
			setZeroFlag(true);
			setPointFlag(false);
			setHasPointFlag(false);
		}
	}

}
