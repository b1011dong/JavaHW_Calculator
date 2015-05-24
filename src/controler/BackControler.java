package controler;

import model.ExpressionData;

public class BackControler extends CommandControler {

	public BackControler(String command)
	{
		super(command);
	}
	
	@Override
	public boolean isValid() {
		if( ExpressionData.getOperand().equals("") )
			return false;
		return true;
	}

	@Override
	public void compute() {

		String operand = ExpressionData.getOperand();
		ExpressionData.setOperand( operand.substring(0, operand.length() - 1) );
	}

}
