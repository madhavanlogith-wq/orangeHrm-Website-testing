package com.orangehrm.seleniumuiframwork_genricutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.testing.objectrepository.pages.*;

public class Pages {

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
    }
}