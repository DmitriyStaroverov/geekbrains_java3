package net.evricom.edu.java3lesson2;

import java.sql.*;

/**
 * created by dima on 10.08.2019 13:55
 */
public class MainDB {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        statement = connection.createStatement();

    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // методы по работе с БД
        //statement.execute("DELETE FROM STUDENTS");

        long t1 = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i=0; i<500; i++) {
            statement.executeUpdate("INSERT INTO students (name,score) VALUES ('name', 100)");
        }
        connection.setAutoCommit(true);

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

//        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        for (int i = 1; i <= metaData.getColumnCount(); i++) {
//            System.out.println(metaData.getColumnTypeName(i));
//        }

//        while (resultSet.next()){
//
//            System.out.println(
//                    resultSet.getInt("id") + " " +
//                    resultSet.getString("name") + " " +
//                    resultSet.getString("score")
//                    );
//        }

        disconnect();
    }

}
