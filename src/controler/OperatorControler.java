package controler;

import model.ExpressionData;

public abstract class OperatorControler extends CommandControler {

	public OperatorControler(String command)
	{
		super(command);
	}
	
	@Override
	public boolean isValid() {
		
		if ( isPointFlag() ) return false;
		
		return true;
	}
	
	public abstract void compute();
	
}
