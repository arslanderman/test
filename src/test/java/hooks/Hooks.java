package hooks;

import base_url_set_up.CoreBaseURL;
import io.cucumber.java.Before;
import utilities.ConfigReader;

import java.sql.*;
import java.util.Map;

import static audience_management_test_data.Headers.headersForPost;
import static utilities.DBUtils.createConnection;


public class Hooks extends CoreBaseURL {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
   static Map<String,String> headers;
/*
    @Before(order=1,value ="@tag_group_create")
    public void beforeApi(){
        //audienceManagementSetUp();
        //spec.pathParams("first","setting","second","tag","third","group","fourth","create");
        //headers = header(ConfigReader.getProperty("ContentType"),ConfigReader.getProperty("host"));
        audienceManagementSetUp();
        spec.pathParams("first","setting","second","tag","third","group","fourth","create");

    }

 */
    /*
    @Before(value ="@tag_create")
    public void beforeApiTagCreate(){
        audienceManagementSetUp();
        spec.pathParams("first","setting","second","tag","third","create");
    }

     */






    @Before(order = 1,value ="@update_active_field")
    public static void beforeApiHeaders(){
        headers = headersForPost(ConfigReader.getProperty("ContentType"),ConfigReader.getProperty("host"));
    }

    @Before(order = 2,value ="@update_active_field")
    public static void connection() throws SQLException {
        createConnection();
    }
/*
    @Before(order = 3,value ="@tags_linked_to_entity")
    public static void beforeExecuteQuery( String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Before(order = 4,value ="@tags_linked_to_entity")
    public static void beforeCloseConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



 */



















    /*
    @After
    public void tearDown(Scenario scenario) {

        System.out.println("After Hooks");
        //adding reports that is generated when a scenrio fails
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed scenerio");
            Driver.closeDriver();

        }
    }

     */

}
