package controler;

public class PointControler extends CommandControler {

	public PointControler(String command)
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
