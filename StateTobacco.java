/**
 * Stores the percentage of tobacco use and the name of states as fields.
 * 
 * @author Anushka Vijay
 * @since 17 March 2019
 */
public class StateTobacco
{
	private String stateAbbr;
	private String stateName;
	private double percentUse;
	private int year;
	
	public StateTobacco(String state, String abbr, double percent, int date)
	{
		stateName = state;
		stateAbbr = abbr;
		percentUse = percent;
		year = date;
	}
	
	/**
	 * accessor method for private field year
	 * @return 		year of data
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * accessor method for private field state
	 * @return 		name of state
	 */
	public String getState()
	{
		return stateName;
	}
	
	/**
	 * accessor method for private field state
	 * @return 		name of state
	 */
	public String getAbbreviation()
	{
		return stateAbbr;
	}
	
	/**
	 * accessor method for private field percentUse
	 * @return 		percentage of tobacco use
	 */
	public double getPercentUse()
	{
		return percentUse;
	}
	
	/**
	 * helper method - convert String into integer
	 * @param val	String to be converted to integer
	 * @return 		converted integer		
	 */
	private int convertInteger(String val)
	{
		int value = 0;
		try {
			value = Integer.parseInt(val);
		}
		catch(NumberFormatException e) {
			System.err.println("ERROR: Value is not an integer");
		}
		return value;
	}
	
	/**
	 * helper method - convert String into double
	 * @param val	String to be converted to double
	 * @return 		converted double
	 */
	private double convertDouble(String val)
	{
		double value = 0.0;
		try {
			value = Double.parseDouble(val);
		}
		catch(NumberFormatException e) {
			System.err.println("ERROR: Value is not an double");
		}
		return value;
	}
}
