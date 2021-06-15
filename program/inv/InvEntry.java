public class InvEntry
{
	private String name;
	private double amount;
	public InvEntry(String name,double amount)
	{
		this.name=name;
		this.amount=amount;
	}


	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() 
	{
		return amount;
	}


	/**
	 * @return the amount as as string
	 */
	public String getAmountAsString() 
	{
		return new Double(amount).toString();
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

}
