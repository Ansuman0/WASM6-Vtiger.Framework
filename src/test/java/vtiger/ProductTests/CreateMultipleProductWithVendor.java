package vtiger.ProductTests;

import genericUtilities.BaseClass;
import genericUtilities.ListenersImplementation;
import io.qameta.allure.Feature;
import objectRepository.*;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * This class provides implementation to ITestListener Interface
 *
 * @author Ansuman
 */
@Feature("Create Multiple Product with Product Category & Vendors")
@Listeners(ListenersImplementation.class)
public class CreateMultipleProductWithVendor extends BaseClass {

    @Parameters("browser")
    @Test(dataProvider = "getData", groups = "RegressionSuite")
    public void createProductWithVendorTest(String productCategory) {

        String prodcutName = rUtil.generateRandomProduct();
        String ProductDate = jUtil.getsimpleDateFormat();
        String vendername = rUtil.generateRandomCompany();
        String email = rUtil.generateFakeEmails();
        String category = rUtil.generateRandomIndusty();
        String phone = rUtil.generateFakePhoneNumber();
        String website = rUtil.generateFakeWebsiteName();
        String address = rUtil.generateFullAddress();
        String description = rUtil.generateRandomCompanyDetails();

        HomePage hp = new HomePage(driver);

        //Click on Vendors link .
        hp.clickOnVendorsLnk(driver);
        Reporter.log("Navigate to Vendor Link & Click on vendor");

        // Navigate to Vendor link and Create vendor.
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

        // Navigate to Product link and Create Product
        hp.clickOnProductsLink();

        ProductPageInfo ppi = new ProductPageInfo(driver);
        String productPageHeader = ppi.getProductPagetHeader();
        Assert.assertTrue(productPageHeader.contains(productPageHeader));

        ProductPage pp = new ProductPage(driver);
        pp.clickOnProductLookUpImage();
        String productFormTitel = pp.getProductFormHeader();
        Assert.assertTrue(productFormTitel.contains(productFormTitel));

        pp.createProductWithVendor(driver, prodcutName, ProductDate, productCategory, vendername);
        String createdProductTitle = pp.getCreateddProduct();
        Assert.assertTrue(createdProductTitle.contains(createdProductTitle));

    }

    @DataProvider
    public Object[][] getData() throws EncryptedDocumentException, IOException {
        return eUtil.readMultipleData("DatProviderProd");
    }

}
