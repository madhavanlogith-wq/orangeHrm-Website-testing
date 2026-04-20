package com.orangehrm.testing.stepdefinition;

import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.testing.objectrepository.pages.DashbordPage;
import com.orangehrm.testing.objectrepository.pages.addJobTitlePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class jobTitleTest extends Base {
	addJobTitlePage jt = new addJobTitlePage(Base.getDriver());
	DashbordPage d = new DashbordPage(Base.getDriver());

	@Given("user is on dashboard page")
	public void user_is_on_dashboard_page() {
	    //// Already handled in Hooks
	}
	@When("user navigates to job titles")
	public void user_navigates_to_job_titles() {
		d.getAdminLink().click();
		jt.setJobMenu();
		jt.setJobTitlesOption();
		jt.setAddButtonjob();
	   }

	@When("user uploads job specification file {string}")
	public void user_uploads_job_specification_file(String fileName) {
		jt.setJob_Specification(fileName);
	}
	
	@When("user enters job title")
	public void user_enters_job_title(String dataTable) {
		jt.setJobMenu();
		jt.setJobTitlesOption();
		jt.setAddButtonjob();
        jt.setJobTitleField(dataTable);
	}
	@When("user enters job description")
	public void user_enters_job_description(String dataTable) {
		jt.setJobDescriptionField(dataTable);
	}
	@When("user adds job note")
	public void user_adds_job_note(String dataTable) {
		jt.setNoteField(dataTable);
		jt.setSaveJobTitle();
	}
	@Then("job title should be added successfully")
	public void job_title_should_be_added_successfully() {
		String actualText = jt.getVerifyjob().getText();
		Assert.assertEquals(actualText, "Success");
		System.out.println("Successfully Saved");
	   }



}
