import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/employees_database?";
        int sqlResult = 0;
        int sqlDelete = 0;
        int sqlUpdate = 0;
        String resultsSet = null;
        try {
            // Establish the connection object
            Connection connection = DriverManager.getConnection(url, "root", "yourPassword");
            // Create a statement object to execute the SQL statement.
            Statement statement = connection.createStatement();
            // Execute the SQL statement to send to the server.
            sqlResult = statement.executeUpdate("insert into employees_tbl (id, name, dept, salary) values(1000, \"Forrest\", \"Technology\", 6500);");
            sqlDelete = statement.executeUpdate("delete from employees_tbl where id = 100;");
            sqlUpdate = statement.executeUpdate("UPDATE employees_tbl SET salary=8000 where id = 800;");
            // Process the result set.
            int total = 0;
            System.out.println("Executed SQL statement: " + sqlResult + "\n" + "rows effected.");
            while (resultsSet.next()) {
                System.out.println(resultsSet.getString("name"));
                total += resultsSet.getInt("salary");
                
            }
            System.out.println(total);

        } catch (SQLException e) {
            System.out.println("Error inserting data into the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
