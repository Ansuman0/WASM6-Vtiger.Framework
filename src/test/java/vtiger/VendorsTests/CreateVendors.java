package vtiger.VendorsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ListenersImplementation;
import io.qameta.allure.Feature;
import objectRepository.HomePage;
import objectRepository.VendorsPage;
import objectRepository.VendorsPageInfo;

/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 */
@Feature("Create Multiple Vendors with GlAccounts Type")
@Listeners(ListenersImplementation.class)
public class CreateVendors extends BaseClass {

	@Parameters("browser")
	@Test(groups = "RegressionSuite")
	public void createVendorsTest() {
		
		

		String vendername = jUtil.generateRandomCompany();
		String email = jUtil.generateFakeEmails();
		String category = jUtil.generateRandomIndusty();
		String phone = jUtil.generateFakePhoneNumber();
		String website = jUtil.generateFakeWebsiteName();
		String address = jUtil.generateFullAddress();
		String description = jUtil.generateRandomCompanyDetails();

		HomePage hp = new HomePage(driver);
		hp.clickOnVendorsLnk(driver);

		VendorsPageInfo vpi = new VendorsPageInfo(driver);
		vpi.getVendorsPageHeader();
		String vendorsPageHeader = vpi.getVendorsPageHeader();
		Assert.assertTrue(vendorsPageHeader.contains(vendorsPageHeader));
		System.out.println("Vendors Page : " + vendorsPageHeader);

		VendorsPage vp = new VendorsPage(driver);
		
		vp.clickOnVendorsookUpImage();

		String vendorsFormTitle = vp.getVendorsFormHeader();
		Assert.assertTrue(vendorsFormTitle.contains(vendorsFormTitle));
		System.out.println("Vendors Page : " + vendorsFormTitle);

		vp.createVendorsSingleGLaccount(driver, vendername, email, category, phone, website, address, description);

		String createdVendorsTitel = vp.getCreatedVendorsHeader();
		Assert.assertTrue(createdVendorsTitel.contains(createdVendorsTitel));

	}

}
