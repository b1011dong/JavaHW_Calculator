package controler;

import model.ExpressionData;

public class PointControler extends CommandControler {

	public PointControler(String command)
	{
		super(command);
	}
	
	@Override
	public boolean isValid() {
		
		if( isPointFlag() )
			return false;
		if( isHasPointFlag() )
			return false;
		if( isEqualsFlag() )
			return false;
		if( ExpressionData.getOperand().equals("") )
			return false;
		
		return true;
	}

	@Override
	public void compute() {

		String operand = ExpressionData.getOperand();
		
		operand += ".";
		
		setPointFlag(true);
		setHasPointFlag(true);
		setEqualsFlag(false);
		setOperatorFlag(false);
		
		ExpressionData.setOperand(operand);
	}
}
