package utils;

import aquality.selenium.browser.AqualityServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import static constants.DataConstants.AUTHOR_ID;
import static constants.DataConstants.BROWSER;
import static constants.DataConstants.END_TIME;
import static constants.DataConstants.ID;
import static constants.DataConstants.METHOD_NAME;
import static constants.DataConstants.NAME;
import static constants.DataConstants.NEW_ENV;
import static constants.DataConstants.NEW_ID;
import static constants.DataConstants.PROJECT_ID;
import static constants.DataConstants.SESSION_ID;
import static constants.DataConstants.START_TIME;
import static constants.DataConstants.STATUS_ID;
import static constants.PathsConstants.CONFIG_DATA_PATH;


public class DataBaseUtils {

    private static final int NAME_INDEX = 1;
    private static final int STATUS_ID_INDEX = 2;
    private static final int METHOD_NAME_INDEX = 3;
    private static final int PROJECT_ID_INDEX = 4;
    private static final int SESSION_ID_INDEX = 5;
    private static final int START_TIME_INDEX = 6;
    private static final int END_TIME_INDEX = 7;
    private static final int ENV_INDEX = 8;
    private static final int BROWSER_INDEX = 9;
    private static final int AUTHOR_ID_INDEX = 10;
    private static final int ID_INDEX = 11;

    private static final String DATA_BASE_URL = ParseUtils.getTestConfig(CONFIG_DATA_PATH,"DATA_BASE_URL");
    private static final String USER = ParseUtils.getTestConfig(CONFIG_DATA_PATH,"USER");
    private static final String PASSWORD = ParseUtils.getTestConfig(CONFIG_DATA_PATH,"PASSWORD");
    private static final String SQL_INSERT_STATEMENT = "INSERT INTO test (name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser, author_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_STATEMENT = "UPDATE test SET name = ?, status_id = ?, method_name = ?, project_id = ?, session_id = ?, start_time = ?, end_time = ?, env = ?, browser = ?, author_id = ? WHERE id=?";
    private static final String SQL_SELECT_STATEMENT = "SELECT * FROM test WHERE id REGEXP '.*([0-9])\\\\1.*' LIMIT 10";
    private static final String SQL_DELETE_STATEMENT = "DELETE FROM test WHERE id = ?";

    public static ResultSet selectIdsFromTable() {
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_STATEMENT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static ArrayList<Integer> updateTableByIdAndGetResult(ResultSet resultSet) {
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            while (resultSet.next()) {
                DataBaseUtils.updateTableInDatabase(resultSet.getInt(ID),
                        resultSet.getString(NAME),
                        resultSet.getString(STATUS_ID),
                        resultSet.getString(METHOD_NAME),
                        PROJECT_ID,
                        resultSet.getInt(SESSION_ID),
                        resultSet.getTimestamp(START_TIME),
                        resultSet.getTimestamp(END_TIME),
                        NEW_ENV,
                        resultSet.getString(BROWSER),
                        resultSet.getString(AUTHOR_ID));
                ids.add(resultSet.getInt(NEW_ID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    public static ArrayList<Integer> deleteIdsFromTable(ArrayList<Integer> ids ,ResultSet resultSet) {
        PreparedStatement stmtDelete;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            stmtDelete = connection.prepareStatement(SQL_DELETE_STATEMENT);
            DataBaseUtils.updateTableWithStatement(stmtDelete, ids, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    public static void fillTableInDatabase(String name, String statusId, String methodName, int projectId, int sessionId, Timestamp startTime, Timestamp endTime, String env, String browser, String authorId) {
        try (Connection conn = DriverManager.getConnection(DATA_BASE_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_STATEMENT)) {
            preparedStatement.setString(NAME_INDEX, name);
            preparedStatement.setString(STATUS_ID_INDEX, statusId);
            preparedStatement.setString(METHOD_NAME_INDEX, methodName);
            preparedStatement.setInt(PROJECT_ID_INDEX, projectId);
            preparedStatement.setInt(SESSION_ID_INDEX, sessionId);
            preparedStatement.setTimestamp(START_TIME_INDEX, startTime);
            preparedStatement.setTimestamp(END_TIME_INDEX, endTime);
            preparedStatement.setString(ENV_INDEX, env);
            preparedStatement.setString(BROWSER_INDEX, browser);
            preparedStatement.setString(AUTHOR_ID_INDEX, authorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        AqualityServices.getLogger().info("Test " + name + "successfully added to DataBase");
    }

    public static void updateTableInDatabase(int id, String name, String statusId, String methodName, int projectId, int sessionId, Timestamp startTime, Timestamp endTime, String env, String browser, String authorId) {

        try (Connection conn = DriverManager.getConnection(DATA_BASE_URL, USER, PASSWORD);
             PreparedStatement prepareStatement = conn.prepareStatement(SQL_UPDATE_STATEMENT)) {
            prepareStatement.setString(NAME_INDEX, name);
            prepareStatement.setString(STATUS_ID_INDEX, statusId);
            prepareStatement.setString(METHOD_NAME_INDEX, methodName);
            prepareStatement.setInt(PROJECT_ID_INDEX, projectId);
            prepareStatement.setInt(SESSION_ID_INDEX, sessionId);
            prepareStatement.setTimestamp(START_TIME_INDEX, startTime);
            prepareStatement.setTimestamp(END_TIME_INDEX, endTime);
            prepareStatement.setString(ENV_INDEX, env);
            prepareStatement.setString(BROWSER_INDEX, browser);
            prepareStatement.setString(AUTHOR_ID_INDEX, authorId);
            prepareStatement.setInt(ID_INDEX, id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        AqualityServices.getLogger().info("Test " + name + "successfully updated to DataBase");
    }
    public static void updateTableWithStatement(PreparedStatement stmtDelete, ArrayList<Integer> ids, Statement statement, ResultSet resultSet) throws SQLException {
        for (Integer id : ids) {
            stmtDelete.setInt(ID_INDEX, id);
            stmtDelete.executeUpdate();
            resultSet.close();
            statement.close();
        }
    }
}
