package controler;

import model.ExpressionData;

public class PlusControler extends OperatorControler {

	public PlusControler(String command)
	{
		super(command);
	}
	
	@Override
	public void compute() {
		
		String history = ExpressionData.getHistory();
		String operand = ExpressionData.getOperand();
		String result = ExpressionData.getResult();
		
		if( isOperatorFlag() )
		{
			history = history.substring( 0, history.length() - 1 );
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
			ExpressionData.setOperand("0");
		}
		
		history += getCommand();
		ExpressionData.setHistory(history);
		
		operand = "0";
		ExpressionData.setOperand( operand );
		
		ExpressionData.setResult( result );
		
		setEqualsFlag( false );
		setOperandFlag( false );
		setOperatorFlag(true);
	}

}
