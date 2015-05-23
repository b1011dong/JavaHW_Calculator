package controler;

public class ClearControler extends CommandControler {

	public ClearControler(String command)
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
