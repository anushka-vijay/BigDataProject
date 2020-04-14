import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Reads in dataset to derive the average percentage of children poor and 
 * average number of children poor in each state, then stored in StateIncome
 * objects.
 * 
 * @author Anushka Vijay
 * @since 17 March 2019
 */
public class Income
{
	private List<StateIncome> incomeData; //ArrayList storing desired values
	private int[] indices = {2, 70, 104, 121, 196, 255, 320, 329, 333, 335,
	403, 563, 569, 614, 717, 810, 910, 1016, 1138, 1202, 1219, 1244, 1259,
	1343, 1431, 1514, 1630, 1687, 1781, 1799, 1810, 1832, 1866, 1929, 2030,
	2084, 2173, 2251, 2288, 2356, 2362, 2409, 2476, 2572, 2827, 2857, 2872,
	3007, 3047, 3103, 3176, 3200}; //indices of average of each state

	public Income()
	{
		//initializes ArrayList
		incomeData = new ArrayList<StateIncome>();
	}
	
	public static void main(String [] args)
	{
		Income income = new Income();
		income.loadDataset();
		income.writeFile();
	}
	
	/**
	 * Binary search algorithm for tokens in a given line
	 * @param target	value method searches for
	 * @return 			true - if target is in array of indices
	 * 					false - otherwise
	 */
	private boolean search(int target)
	{
		//search indices within line
		for(int i = 0; i < indices.length; i++)
		{
			if(indices[i] == target)
				return true;
		}
		return false;
	}
	
	/**
	 * Printing all averaged values to an output text file.
	 */
	public void writeFile()
	{
		//output file
		PrintWriter writer = FileUtils.openToWrite("IncomeData.txt"); 
		writer.print("State, Abbreviation, Percent of Children Poor, Number of Children Poor\n");
		for(int i = 0; i < incomeData.size(); i++)
		{
			StateIncome state = incomeData.get(i);
			String name = state.getState();
			String abbr = state.getStateAbbr();
			double percent = state.getPercent();
			int num = state.getNum();
			writer.print(name + ", " + abbr + ", " + percent + ", " + num + "\n");
		}
		writer.close(); //close PrintWriter object
	}	
	
	/**
	 * Reads dataset then parses and merges data based on tokenized lines
	 */
	public void loadDataset()
	{
		String fileName = "Income.csv"; //file to be read in
		Scanner input = FileUtils.openToRead(fileName).useDelimiter(",");
		//declare and initializing variables
		String state = "", stateAbbr = "", percentage = "", number = "";
		int count = 0;
		boolean isNewState = false;
		while(input.hasNext())
		{
			String line = input.nextLine();
			String[] tokens = new String[11];
			int tokenCount = 0;
			//tokenizer for each line
			for(int i = 0; i < line.length(); i++)
			{
				if(line.charAt(i) == ',')
				{
					tokenCount++;
					tokens[tokenCount] = "";
				}
				else
					tokens[tokenCount]+= line.charAt(i);
			}
			//desired values from line
			stateAbbr = tokens[1];
			state = tokens[2];
			percentage = tokens[5];
			number = tokens[9];
			//checks if line is the state average
			if(search(count))
				incomeData.add(new StateIncome(number, percentage, 
													stateAbbr, state));
			count++;
		}
	}
}	
