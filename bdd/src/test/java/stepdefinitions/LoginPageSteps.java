package stepdefinitions;

import java.util.Properties;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage();
	private ConfigReader configReader;
	Properties prop;
	
	public LoginPageSteps (){
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	
	@Given("user is on login page {string}")
	public void user_is_on_login_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   String url = prop.getProperty(string);
	   DriverFactory.getDriver().get(url);
	   loginPage.clickOnLogin();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
	    // Write code here that turns the phrase above into concrete actions
		String verifyField = loginPage.getLoginPageTitle();
		Assert.assertEquals(verifyField, string);
	}

	@Then("enter all mandatory fields")
	public void enter_all_mandatory_fields(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		loginPage.enterMandatoryFields();
	    throw new io.cucumber.java.PendingException();
	}



}
