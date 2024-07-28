////////////////////////////////////////////////////////
//   Kush Gandhi 
//   Z1968933
//   CSCI 470-PE1 
//   
//  I certify that this is my own work and where appropriate an extension 
//  of the starter code provided for the assignment. 
////////////////////////////////////////////////////////
public class Player 
{
	private String name;
	private int balance;
	private int id;
	
	public Player(String name, int balance)
	{
		this.name = name;
		this.balance = balance;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public int getBalance() 
	{
		return balance;
	}
	
	public void setBalance(int balance) 
	{
		this.balance = balance;
	}
}
