/**
 * Stores the number of children poor, percentage of children poor,
 * and name of a state as objects of this class.
 * 
 * @author Anushka Vijay
 * @since 17 March 2019
 */
public class StateIncome
{
	private String stateAbbr;
	private int childNum;
	private double childPercent;
	private String stateName;
	
	public State(String num, String percent, String abbr, String name)
	{
		childNum = convertInteger(num);
		childPercent = convertDouble(percent);
		stateAbbr = abbr;
		stateName = name;
	}
	
	public int getNum() {
		return childNum;
	}
	
	public double getPercent() {
		return childPercent;
	}
	
	public String getState() {
		return stateName;
	}
	
	public String getStateAbbr() {
		return stateAbbr;
	}
	
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
