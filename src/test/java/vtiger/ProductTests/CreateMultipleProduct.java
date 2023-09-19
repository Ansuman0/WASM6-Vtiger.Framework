package vtiger.ProductTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ListenersImplementation;
import io.qameta.allure.Feature;
import objectRepository.HomePage;
import objectRepository.ProductPage;
import objectRepository.ProductPageInfo;


/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 *
 */
@Feature("Create Multiple Product with Product Category")
@Listeners(ListenersImplementation.class)
public class CreateMultipleProduct extends BaseClass {
	
	
	@Parameters("browser")
	@Test(dataProvider = "getData",groups="RegressionSuite")
	public void createProductTest(String productCategory) {

		String prodcutName = jUtil.generateRandomProduct();
		String ProductDate = jUtil.getsimpleDateFormat();
		
		HomePage hp = new HomePage(driver);
		hp.clickOnProductsLink();
		
		ProductPageInfo ppi = new ProductPageInfo(driver);
		String productPageHeader = ppi.getProductPagetHeader();
		Assert.assertTrue(productPageHeader.contains(productPageHeader));
		
		ProductPage pp = new ProductPage(driver);
		pp.clickOnProductLookUpImage();
		String productFormTitel = pp.getProductFormHeader();
		Assert.assertTrue(productFormTitel.contains(productFormTitel));
		
		pp.createProduct(driver, prodcutName, ProductDate , productCategory);
		String createdProductTitle = pp.getCreateddProduct();
		Assert.assertTrue(createdProductTitle.contains(createdProductTitle));
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleData("DatProviderProd");
	}

}

