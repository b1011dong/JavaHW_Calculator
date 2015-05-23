package model;

public enum ButtonNumber {
	
	SEVEN(1),
	EIGHT(1),
	NINE(2),
	DIVIDE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	TIMES(7),
	ONE(8),
	TWO(9),
	THREE(10),
	MINUS(11),
	ZERO(12),
	POINT(13),
	EQUALS(14),
	PLUS(15),
	C(16),
	B(17);
	
	private int keyNumber;
	
	ButtonNumber(int number)
	{
		this.keyNumber = number;
	}
	public int getNumber()
	{
		return keyNumber;
	}
}
