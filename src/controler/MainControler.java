package controler;

import model.*;

public class MainControler {
	
	private String command;
	
	
	/* ========== Constructors ========== */
	
	public MainControler()
	{
		CommandControler.setEqualsFlag(false);
		CommandControler.setOperandFlag(true);
		CommandControler.setOperatorFlag(false);
		CommandControler.setPointFlag(false);
		CommandControler.setHasPointFlag(false);
		CommandControler.setZeroFlag(true);
	}
	
	public MainControler(String command)
	{
		setCommand(command);
	}
	
	
	/* ========== Functional Operations ========== */
	
	public boolean compute(String command)
	{
		CommandControler con;
		
		setCommand( command );
		
		if( getCommand().equals("+") ) {
			con = new PlusControler( getCommand() );
		}
		else if( getCommand().equals("-") ) {
			con = new MinusControler( getCommand() );
		}
		else if( getCommand().equals("*") ) {
			con = new TimesControler( getCommand() );
		}
		else if( getCommand().equals("/") ) {
			con = new DivideControler( getCommand() );
		}
		else if( getCommand().equals("=") ) {
			con = new EqualsControler( getCommand() );
		}
		else if( getCommand().equals(".") ) {
			con = new PointControler( getCommand() );
		}
		else if( getCommand().equals("B") ) {
			con = new BackControler( getCommand() );
		}
		else if( getCommand().equals("C") ) {
			con = new ClearControler( getCommand() );
		}
		else{
			con = new OperandControler( getCommand() );
		}
		
		if( !con.isValid() ) return false;
		
		con.compute();
		
		return true;
	}
	
	
	/* ========== Getters and Setters ========== */
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
}
