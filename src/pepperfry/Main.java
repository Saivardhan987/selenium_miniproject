package pepperfry;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

//		Calling all the methods by creating object of ProductListAutomation class 
		ProductListAutomation pro = new ProductListAutomation();
		pro.createDriver();
		pro.navigateToURL();
		pro.validateTitle();
		pro.selectFurniture();
		pro.selectSeating();
		pro.selectBenches();
		pro.fetchBenchDetails();
		pro.printBenchDetails();
		pro.validateIndustrialBenchesCount();
		pro.closeDriver();
	}
}
