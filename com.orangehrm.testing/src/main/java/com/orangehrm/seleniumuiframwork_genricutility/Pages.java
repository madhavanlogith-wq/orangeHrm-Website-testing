package com.orangehrm.seleniumuiframwork_genricutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.testing.objectrepository.pages.*;

public class Pages {
	
	// Login Module
    public LoginPage loginpage;
    public DashbordPage dashboardpage;
    public ApplyPage apply;
    public LeaveListPage leavelist;
    public AddEntitlementsPage addentitlement;
    public LeavePage leavepage;
    public LeavePeriodPage leaveperiod;
    public MyLeavePage myleave;
    public MyLeaveReportPage myleavereport;
    public AssginLeavePage assignLeave;
    
    // Pim Module
    public addUserPage au;
    public addJobTitlePage jt;
    public organizationPage ong;
    public pimAddEmpPage aep;
    public PimCusDataPage pcd;
    // Recruitment module
    public  CandidatePage cp;
	public  VacancyPage vp;
	public  RecruitmentPage rp;
	
	// My-info Module
    public  PersonalDetailsPage personalDetailsPage;
    public  ContactDetailsPage contactDetailsPage;
    public EmergencyContactsPage emergencyContactsPage;
    public  DependentsPage dependentsPage;
    public  JobDetailsPage jobDetailsPage;
    public  QualificationsPage qualificationsPage;
    
    public Post post;
    public Attendance attendance;
    public Project_Info project_info;
    public Reports reports;
    public My_Claims my_claims;
    public Submit_Claim submit_Claim;

    // 🔥 Constructor (IMPORTANT)
    public Pages(WebDriver driver) {

        loginpage = PageFactory.initElements(driver, LoginPage.class);
        dashboardpage = PageFactory.initElements(driver, DashbordPage.class);
        apply = PageFactory.initElements(driver, ApplyPage.class);
        leavelist = PageFactory.initElements(driver, LeaveListPage.class);
        addentitlement = PageFactory.initElements(driver, AddEntitlementsPage.class);
        leavepage = PageFactory.initElements(driver, LeavePage.class);
        leaveperiod = PageFactory.initElements(driver, LeavePeriodPage.class);
        myleave = PageFactory.initElements(driver, MyLeavePage.class);
        myleavereport = PageFactory.initElements(driver, MyLeaveReportPage.class);
        assignLeave = PageFactory.initElements(driver, AssginLeavePage.class);
        
        // Pim Module
        ong=PageFactory.initElements(driver, organizationPage.class);
    	aep=PageFactory.initElements(driver, pimAddEmpPage.class);
    	jt=PageFactory.initElements(driver, addJobTitlePage.class); 
    	au=PageFactory.initElements(driver, addUserPage.class); 
    	pcd=PageFactory.initElements(driver, PimCusDataPage.class);
    	
    	// Recriutment  Mmodule
		cp=PageFactory.initElements(driver, CandidatePage.class);
		vp=PageFactory.initElements(driver, VacancyPage.class);
		rp=PageFactory.initElements(driver, RecruitmentPage.class);
		
		   // My Info Module
        personalDetailsPage = PageFactory.initElements(driver, PersonalDetailsPage.class);
        contactDetailsPage = PageFactory.initElements(driver, ContactDetailsPage.class);
        emergencyContactsPage = PageFactory.initElements(driver, EmergencyContactsPage.class);
        dependentsPage = PageFactory.initElements(driver, DependentsPage.class);
        jobDetailsPage = PageFactory.initElements(driver, JobDetailsPage.class);
        qualificationsPage = PageFactory.initElements(driver, QualificationsPage.class);
        
        // Buzz Module
     
        post = PageFactory.initElements(driver, Post.class);
        attendance = PageFactory.initElements(driver, Attendance.class);
        project_info = PageFactory.initElements(driver, Project_Info.class);
        reports = PageFactory.initElements(driver, Reports.class);
        my_claims = PageFactory.initElements(driver, My_Claims.class);
        submit_Claim = PageFactory.initElements(driver, Submit_Claim.class);
    }
}