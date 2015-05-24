package controler;

import model.ExpressionData;

public class ClearControler extends CommandControler {

	public ClearControler(String command)
	{
		super(command);
	}
	
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public void compute() {

		ExpressionData forClear = new ExpressionData();
		setEmptyFlag(true);
		setEqualsFlag(false);
		setOperandFlag(true);
		setOperatorFlag(false);
		setPointFlag(false);
		setHasPointFlag(false);
		setZeroFlag(true);
	}

}
