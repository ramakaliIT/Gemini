package utilities;

import java.sql.*;

public class DBUtils {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    private static String username = "sa";
    private static String password = "S202048s!";
    public static String url = "jdbc:sqlserver://KALILAPTOP\\SQLEXPRESS;";

    public static ResultSet executeQuery(String query) throws SQLException {
    /*-------------------------------------------------------------------------------------------------------
       This method is a common execute command for sql queries for all project DB executions
     ------------------------------------------------------------------------------------------------------*/

        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        connection = DriverManager.getConnection(url, username, password);

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        System.out.println("Connection is not null : " + connection.isValid(10));

        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }


    public static boolean executeSqlCommand(String sqlCommand) throws SQLException {
    /*-------------------------------------------------------------------------------------------------------
       *  This method is a common execute command for sql for all project DB executions
     ------------------------------------------------------------------------------------------------------*/

        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        connection = DriverManager.getConnection(url, username, password);

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        System.out.println("Connection is not null : " + connection.isValid(10));

        return statement.execute(sqlCommand);
    }





}
