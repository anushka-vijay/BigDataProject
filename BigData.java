/**
 * @author Anushka Vijay
 * @since 17 March 2019
 */
public class BigData
{
	private Income income;
	private Education education;
	private TobaccoUse tobacco;
	
	public BigData()
	{
		income = new Income();
		education = new Education();
		tobacco = new TobaccoUse();
	}
	
	public static void main(String [] args)
	{
		BigData data = new BigData();
		data.run();
	}
	
	public void run()
	{
		income.loadDataset();
		income.writeFile();
		education.readAndWrite();
		tobacco.loadData();
		tobacco.writeFile();
	}
}
