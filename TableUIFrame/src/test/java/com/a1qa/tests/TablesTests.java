package com.a1qa.tests;

import com.a1qa.baseElementStructure.BaseTest;
import com.a1qa.logger.MyLogger;
import com.a1qa.models.Employee;
import com.a1qa.pageobjects.MainPage;
import com.a1qa.pageobjects.NewUserForm;
import com.a1qa.pageobjects.WebTablesPage;
import com.a1qa.utils.ParseUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TablesTests extends BaseTest {

    @Test(dataProvider = "userDataProvider")
    public void testTables(Employee employee) {
        MainPage mainPage = new MainPage();
        WebTablesPage webTablesPage = new WebTablesPage();
        NewUserForm newUserForm = new NewUserForm();
        Assert.assertTrue(mainPage.checkMainPageTemplateIsPresented(), "Main page isn't displayed");
        mainPage.clickElementsSectionButton();
        webTablesPage.clickWebTablesSection();
        Assert.assertTrue(webTablesPage.checkWebTablesPageHeaderIsPresented(), "Web Tables header isn't displayed");
        webTablesPage.clickAddButton();
        Assert.assertTrue(newUserForm.checkNewUserFormIsPresented(), "new user form is not presented");
        newUserForm.setFirstName(employee.getFirstName());
        newUserForm.setLastName(employee.getSecondName());
        newUserForm.setEmail(employee.getEmail());
        newUserForm.setAge(String.valueOf(employee.getAge()));
        newUserForm.setSalary(String.valueOf(employee.getSalary()));
        newUserForm.setDepartment(employee.getDepartment());
        newUserForm.clickSubmit();
        Assert.assertTrue(webTablesPage.getUsers().contains(employee), "The table does not contain new user");
        MyLogger.info("new user is presented in the table");
        webTablesPage.deleteUser(employee.getEmail());
        Assert.assertFalse(webTablesPage.getUsers().contains(employee), "The table still contains new user");

    }
    @DataProvider
    public Object[][] userDataProvider() throws IOException {
        Employee[] listOfEmployees = ParseUtils.parseFromJson("src/test/java/com/a1qa/Data/TestData.json", Employee[].class);
        return new Object[][] {
                {listOfEmployees[0]},
                {listOfEmployees[1]}
        };
    }
}
