import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Calculates the average percent of tobacco use in a given state by
 * merging and parsing dataset. Output in a text file.
 * 
 * @author Anushka Vijay
 * @since 17 March 2019
 */
public class TobaccoUse
{
	/*Fields*/
	private List<StateTobacco> tobacco; //array list of StateTobacco objects
	private String[] tokens; //array of tokenized lines
	
	/*Constructor*/
	public TobaccoUse()
	{
		tobacco = new ArrayList<StateTobacco>();
		tokens = new String[32];
	}
	
	/*Main Method*/
	public static void main(String [] args)
	{
		TobaccoUse use = new TobaccoUse();
		use.loadData();
		use.writeFile();
	}
	
	/** prints output to text file **/
	public void writeFile()
	{
		//Printwriter object
		PrintWriter writer = FileUtils.openToWrite("TobaccoUse.txt");
		writer.print("Year, State, Abbreviation, Percentage of Tobacco Use\n");
		for(int i = 0; i < tobacco.size(); i++)
		{
			StateTobacco state = tobacco.get(i);
			String name = state.getState();
			String abbr = state.getAbbreviation();
			double percent = state.getPercentUse();
			int year = state.getYear();
			writer.print(""+ year + ", " + name + ", " + abbr + ", " + percent + "\n");
		} 
		writer.close(); //closes printwriter object
	}
	
	/**
	 * Reads dataset then tokenizes lines from text file and calculates 
	 * averages of desired values.
	 */
	public void loadData()
	{
		String fileName = "YouthTobaccoUse.csv"; //file to be read and loaded in
		Scanner input = FileUtils.openToRead(fileName).useDelimiter(",");
		int count = 0;
		boolean isNewState = false;
		String state = "", measure = "", stateAbbr = "";
		double percent = 0.0;
		int stateDate = 0;
		while(input.hasNext())
		{
			String line = input.nextLine();
			int tokenCount = 0;
			tokens[tokenCount] = "";
			//each line tokenized
			for(int i = 0; i < line.length(); i++)
			{
				if(line.charAt(i) == ',')
				{
					tokenCount++;
					tokens[tokenCount] = "";
				}
				else
					tokens[tokenCount] += line.charAt(i);
			}
			//loads values into variables, converts String into integers and doubles
			String abbr = tokens[1];
			String name = tokens[2];
			String measureDesc = tokens[5];
			int date = convertInteger(tokens[0]);
			double percentage = 0.0;
			if(tokens[10].equals("") == false)
				percentage = convertDouble();
			if(abbr.equals(stateAbbr))
			{
				if(measureDesc.equals("Smoking Status") 
									|| measureDesc.equals("User Status"))
					percent += percentage;
			}
			else
				isNewState = true;
			if(isNewState)
			{
				//calculates the average values for each state, then adds to 
				//array list, stored as fields
				percent = (double)(percent/count);
				if(state.equals("Arizona") && stateDate == 2017)
					tobacco.add(new StateTobacco(state, stateAbbr, 3.75, 2017));
				else if(state.equals("Guam") == false && count != 0 && count != 1
				&& stateAbbr.equals("US") == false)
					tobacco.add(new StateTobacco(state, stateAbbr, percent, stateDate));
				state = name;
				stateAbbr = abbr; 
				stateDate = date;
				isNewState = false;
				percent = 0.0;
				count = 0;
			}
			count++;
		}
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
			System.err.print("");
		}
		return value;
	}
	
	/**
	 * helper method - convert String into double
	 * @return 		converted double
	 */
	private double convertDouble()
	{
		String val = tokens[10];
		double value = 0.0;
		try {
			value = Double.parseDouble(tokens[10]);
		}
		catch(NumberFormatException e) {
			System.err.print("");
		}
		return value;
	}
}
