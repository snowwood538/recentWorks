package utils;

import enums.StatusCodes;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static constants.Constants.PROJECT_ID;
import static constants.Constants.SESSION_ID;
import static constants.DataConstants.ENV;
import static constants.DataConstants.INDEX_STATUS_FAIL;
import static constants.DataConstants.INDEX_STATUS_PASS;
import static constants.DataConstants.INDEX_STATUS_SKIPPED;
import static constants.PathsConstants.CONFIG_DATA_PATH;


public class Listener implements ITestListener {

    private final List<String> testNames = new ArrayList<>();
    private final List<String> testMethodNames = new ArrayList<>();
    private final List<String> testStatuses = new ArrayList<>();
    private final List<Long> testStart = new ArrayList<>();
    private final List<Long> testEnd = new ArrayList<>();

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        String testMethodName = result.getMethod().getMethodName();
        long startMillis = result.getStartMillis();
        testStart.add(startMillis);
        testNames.add(testName);
        testMethodNames.add(testMethodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testStatuses.add(StatusCodes.TEST_STATUS_PASSED.getStatusCodes());
        long endMillis = result.getEndMillis();
        testEnd.add(endMillis);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testStatuses.add(StatusCodes.TEST_STATUS_FAILED.getStatusCodes());
        testEnd.add(result.getEndMillis());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testStatuses.add(StatusCodes.TEST_STATUS_SKIPPED.getStatusCodes());
        testEnd.add(result.getEndMillis());
    }

    @Override
    public void onFinish(ITestContext context) {
        for (int i = 0; i < testNames.size(); i++) {
            String name = testNames.get(i);
            String statusId;
            if (testStatuses.get(i).equals(StatusCodes.TEST_STATUS_PASSED.getStatusCodes())) {
                statusId = INDEX_STATUS_PASS;
            } else if (testStatuses.get(i).equals(StatusCodes.TEST_STATUS_FAILED.getStatusCodes())) {
                statusId = INDEX_STATUS_FAIL;
            } else {
                statusId = INDEX_STATUS_SKIPPED;
            }
            String methodName = testMethodNames.get(i);
            Timestamp startDate = new Timestamp(new Date(testStart.get(i)).getTime());
            Timestamp endDate = new Timestamp(new Date(testEnd.get(i)).getTime());
            String browser = ParseUtils.getTestConfig(CONFIG_DATA_PATH, "BROWSER");
            String authorId = ParseUtils.getTestConfig("AUTHOR_ID");
            DataBaseUtils.fillTableInDatabase(name,statusId,methodName,PROJECT_ID, SESSION_ID, startDate, endDate, ENV, browser, authorId);
        }
    }

}

