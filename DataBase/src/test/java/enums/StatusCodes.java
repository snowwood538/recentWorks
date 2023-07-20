package enums;

public enum StatusCodes {

    TEST_STATUS_PASSED("PASS"),
    TEST_STATUS_FAILED ("FAIL"),
    TEST_STATUS_SKIPPED ("SKIPPED");

    private final String statusCodes;

    StatusCodes(String statusCodes) {
        this.statusCodes = statusCodes;
    }

    public String getStatusCodes() {
        return statusCodes;
    }
}
