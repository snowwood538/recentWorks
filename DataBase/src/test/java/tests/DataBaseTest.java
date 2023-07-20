package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.Test;
import utils.DataBaseUtils;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBaseTest {

    @Test
    public static void selectAndDeleteTest() {
        ResultSet tableInfo = DataBaseUtils.selectIdsFromTable();
        AqualityServices.getLogger().info("Tests' selection  from the database where ID contains two random repeating digits");
        ArrayList<Integer> updatedTablesIds = DataBaseUtils.updateTableByIdAndGetResult(tableInfo);
        AqualityServices.getLogger().info("Updating tests' info with an indication of the current project");
        DataBaseUtils.deleteIdsFromTable(updatedTablesIds, tableInfo);
        AqualityServices.getLogger().info("Deletion of the tests' records  from the database.");

    }
}
