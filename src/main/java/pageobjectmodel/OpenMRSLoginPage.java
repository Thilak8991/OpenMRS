package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.interfaceElement.OpenMRSElements;
import com.property.FileReaderManagerMRS;

public class OpenMRSLoginPage extends BaseClass implements OpenMRSElements {
	
	@FindBy(id="userName_id")
	private WebElement username;
	
	@FindBy(id="password_id")
	private WebElement password;
	
	@FindBy(id="loation_id")
	private WebElement location;
	
	@FindBy(id="login_id")
	private WebElement login;
	
	public OpenMRSLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void validLogin() throws Throwable {
		FileReaderManagerMRS data = new FileReaderManagerMRS();
		launchUrl(data.getDataProperty("url"));
		passInput(username,"loginusername");
		passInput(password,"loginpassword");
		elementclick(location);
		elementclick(login);
		


		
		
	}

	
	
	
	

}
