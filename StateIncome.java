/**
 * Stores the number of children poor and percentage of children poor
 * and name of state as fields.
 * 
 * @author Anushka Vijay
 * @since 17 March 2019
 */
public class StateIncome
{
	/**fields**/
	private String stateAbbr;
	private int childNum;
	private double childPercent;
	private String stateName;
	
	/**Constructor**/
	public StateIncome(String num, String percent, String abbr, String name)
	{
		childNum = convertInteger(num);
		childPercent = convertDouble(percent);
		stateAbbr = abbr;
		stateName = name;
	}
	
	/**
	 * accessor method for number of children poor
	 * @return	number of children poor 
	 */
	public int getNum() {
		return childNum;
	}
	
	/**
	 * accessor method for percentage of children poor
	 * @return	percentage of children poor as a double
	 */
	public double getPercent() {
		return childPercent;
	}
	
	/**
	 * accessor method for name of state
	 * @return	state name
	 */
	public String getState() {
		return stateName;
	}
	
	/**
	 * accessor method for abbreviation of state
	 * @return	state abbreviation
	 */
	public String getStateAbbr() {
		return stateAbbr;
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
	 * @param val	String to be converted to a double
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
