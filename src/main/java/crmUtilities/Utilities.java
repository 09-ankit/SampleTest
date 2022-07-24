package crmUtilities;
import java.util.ArrayList;




public class Utilities {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getDatafromExcel(){

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader("D:\\sel fils\\Excel Data\\TestData.xlsx");
		} catch (Exception e){
			e.printStackTrace();
		}

		//System.out.println(reader.getRowCount("Persons"));
	
		for (int rowNum=2; rowNum<reader.getRowCount("Persons"); rowNum++ ) {
			

			String firstName= reader.getCellData("Persons", "firstName", rowNum); 
			String lastName =reader.getCellData("Persons", "lastName", rowNum);
			String jobTitle =reader.getCellData("Persons", "jobTitle",rowNum);
			String org= reader.getCellData("Persons","org", rowNum);
			String tags =reader.getCellData("Persons","tags",rowNum);
			String phoneNumber= reader.getCellData("Persons","phoneNumber",rowNum);
			String email =reader.getCellData("Persons","email",rowNum);			

			Object ob[]= {firstName,lastName,jobTitle,org,tags,phoneNumber,email};
			System.out.println(ob);
			myData.add(ob);

		}
		return myData;


	}
}