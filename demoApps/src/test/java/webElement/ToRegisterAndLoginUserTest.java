package webElement;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.BaseClass;
import pomRepo.Login_Page;
import pomRepo.Register_Page;

public class ToRegisterAndLoginUserTest extends BaseClass {


	@Test(priority = 1)
	public void toRegisterUserTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String name = fUtils.fetchDataFromExcelsheet("Sheet2", 1, 0);
		String email = fUtils.fetchDataFromExcelsheet("Sheet2", 1, 1);
		String password = fUtils.fetchDataFromExcelsheet("Sheet2", 1, 2);
		
		Register_Page register=new Register_Page(driver);
		register.registerUser(name, email, password);
		
		Thread.sleep(2000);
		Login_Page login = new Login_Page(driver);
		Assert.assertTrue(login.verifyRegisterUser());
		System.out.println("Pass: the user has registered");
			
	}
	
	@Test(priority = 2)
	public void toLoginUserTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String email = fUtils.fetchDataFromExcelsheet("Sheet2", 1, 1);
		String password = fUtils.fetchDataFromExcelsheet("Sheet2", 1, 2);
		
		Login_Page login = new Login_Page(driver);
		login.loginUser(email, password);
		Thread.sleep(2000);
		Assert.assertTrue(login.verifyLoginUser());
		System.out.println("Pass: the user has Logged In");	
	}
}
