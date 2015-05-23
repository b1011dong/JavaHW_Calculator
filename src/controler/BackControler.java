package controler;

public class BackControler extends CommandControler {

	public BackControler(String command)
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
