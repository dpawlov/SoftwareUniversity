package jdbclab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class SoftUniDB {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", properties);

        PreparedStatement statement =
                connection.prepareStatement
                        ("SELECT first_name, last_name FROM employees WHERE salary > ?");

        String salary = scanner.nextLine();

        statement.setDouble(1, Double.parseDouble(salary));

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }
}
