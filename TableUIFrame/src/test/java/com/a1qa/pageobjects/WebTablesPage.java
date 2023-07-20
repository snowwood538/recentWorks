package com.a1qa.pageobjects;

import com.a1qa.baseElementStructure.BaseElement;
import com.a1qa.baseElementStructure.BaseForm;
import com.a1qa.baseElementStructure.Button;
import com.a1qa.baseElementStructure.Field;
import com.a1qa.logger.MyLogger;
import com.a1qa.models.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebTablesPage extends BaseForm{

    private Button webTablesButton = new Button(By.xpath("//span[text()='Web Tables']"), "web Tables button");
    private BaseForm webTablesPageHeader = new BaseForm(By.xpath("//div[@class='main-header']"), "Web Tables header");
    private Button addButton = new Button(By.xpath("//*[@id='addNewRecordButton']"), "button to add User to Table");
    private BaseForm newUserForm = new BaseForm(By.xpath("//*[@id='registration-form-modal']"), "New user form opened");
    private Field firstName = new Field(By.xpath("//*[@id='firstName']"), "First name to present form");
    private Field lastNameForm = new Field(By.xpath("//*[@id='lastName']"), "Last name to present form");
    private Field emailForm = new Field(By.xpath("//*[@id='userEmail']"), "Email to present form");
    private Field ageForm = new Field(By.xpath("//*[@id='age']"), "Age to present form");
    private Field salaryForm = new Field(By.xpath("//*[@id='salary']"), "Salary to present form");
    private Field departmentForm = new Field(By.xpath("//*[@id='department']"), "Department to present form");
    private Button submitButton = new Button(By.xpath("//*[@id='submit']"), "Submit user button");
    private List<WebElement> userInfo = new BaseElement(By.xpath("//*[@class='rt-tr-group']"), "df").findElements();


    public void clickWebTablesSection() {
        try {
            webTablesButton.click();
        } catch (StaleElementReferenceException e) {
            webTablesButton.click();
        }
    }
    public boolean checkWebTablesPageHeaderIsPresented() {
        MyLogger.info("Tables header is presented");
        return webTablesPageHeader.isPageOpen();
    }
    public void clickAddButton() {
        addButton.click();
    }

    public Employee getUser(int index) {
        return getUsers().get(index);
    }

    public List<Employee> getUsers() {
        List<Employee> employees = new ArrayList<>();
        List<WebElement> listOfUser = userInfo;
        for (WebElement user: listOfUser) {
            List<WebElement> userInfo = user.findElements(By.xpath(".//*[@class='rt-td']"));
            try {
                employees.add(new Employee(
                        userInfo.get(0).getText(),
                        userInfo.get(1).getText(),
                        Integer.parseInt(userInfo.get(2).getText()),
                        userInfo.get(3).getText(),
                        Integer.parseInt(userInfo.get(4).getText()),
                        userInfo.get(5).getText()));
            } catch (NumberFormatException ignored) {
            }
        }
        return employees.stream().filter(user -> !user.getFirstName().equals(" ")).collect(Collectors.toList());
    }
    public void deleteUser(String email) {
        List<WebElement> listOfUser = userInfo;
        for (WebElement user: listOfUser) {
            List<WebElement> userInfo = user.findElements(By.xpath(".//*[@class='rt-td']"));
            if (userInfo.get(3).getText().equals(email)) {
                user.findElement(By.xpath(".//*[contains(@id, 'delete-record')]")).click();
            }
        }
        MyLogger.info("New user is deleted");
    }
}
