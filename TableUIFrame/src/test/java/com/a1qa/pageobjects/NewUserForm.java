package com.a1qa.pageobjects;

import com.a1qa.baseElementStructure.BaseForm;
import com.a1qa.baseElementStructure.Button;
import com.a1qa.baseElementStructure.Field;
import com.a1qa.logger.MyLogger;
import org.openqa.selenium.By;

public class NewUserForm extends BaseForm {
    private BaseForm newUserForm = new BaseForm(By.xpath("//*[@id='registration-form-modal']"), "New user form opened");
    private Field firstName = new Field(By.xpath("//*[@id='firstName']"), "First name to present form");
    private Field lastNameForm = new Field(By.xpath("//*[@id='lastName']"), "Last name to present form");
    private Field emailForm = new Field(By.xpath("//*[@id='userEmail']"), "Email to present form");
    private Field ageForm = new Field(By.xpath("//*[@id='age']"), "Age to present form");
    private Field salaryForm = new Field(By.xpath("//*[@id='salary']"), "Salary to present form");
    private Field departmentForm = new Field(By.xpath("//*[@id='department']"), "Department to present form");
    private Button submitButton = new Button(By.xpath("//*[@id='submit']"), "Submit user button");

    public boolean checkNewUserFormIsPresented() {
        MyLogger.info("User Form is opened");
        return newUserForm.isPageOpen();
    }

    public void setFirstName(String firstName) {
        this.firstName.click();
        this.firstName.sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        lastNameForm.click();
        lastNameForm.sendKeys(lastName);
    }
    public void setEmail(String email) {
        emailForm.click();
        emailForm.sendKeys(email);
    }
    public void setAge(String age) {
        ageForm.click();
        ageForm.sendKeys(age);
    }
    public void setSalary(String salary) {
        salaryForm.click();
        salaryForm.sendKeys(salary);
    }
    public void setDepartment(String department) {
        departmentForm.click();
        departmentForm.sendKeys(department);
    }
    public void clickSubmit() {
        submitButton.click();
    }



}
