package controler;

public class OperandControler extends CommandControler {

	public OperandControler(String command)
	{
		super(command);
	}
	
	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public void compute() {

	}

}
