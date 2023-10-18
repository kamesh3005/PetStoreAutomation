package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {
		
		String path=System.getProperty("user.dir")+"/testData/storeAPIData.xlsx";
		XLUtility xl=new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		int columcount = xl.getCellCount("Sheet1", 1);
		String apidata[][]=new String[rownum][columcount];
		
		for(int r=1;r<=rownum;r++) {
			
			for(int c=0;c<columcount;c++) {
				
				 apidata[r-1][c] = xl.getCellData("Sheet1", r, c);
			}
		}
		return apidata;
		
		
	}
	
	
	@DataProvider(name = "UserName")
	public String[] getuserName() throws IOException{
		String path=System.getProperty("user.dir")+"/testData/storeAPIData.xlsx";
		XLUtility xl=new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		String apiData[]=new String[rownum];
		for(int i=1;i<=rownum;i++) {
			
			apiData[i-1]=xl.getCellData("Sheet1", i, 1);
		}
		
		
		return apiData;
		
		
		
	}

}
