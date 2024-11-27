package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//Data Provider1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from test data
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating object of excel utility
		
		int totalrows=xlutil.getRowCount("sheet1");
		int totalcols=xlutil.getCellCount("sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];//created for 2 dimnsin array whch can store
		for(int i=1;i<=totalrows;i++)//1 //read the data fro xl storig in two dimensonal array
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1",i,j); //1,0
			}
		}
		return logindata;//returning 2 dimension array
		
		
		
	}
	
	//data provider2

}
