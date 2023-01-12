import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {

    private static final String DBURL = "jdbc:mysql://localhost:3306/newdb";
    private static final String USER = "developer";
    private static final String PASSWORD = "passwordhere";

    public static void main(String[] args) {
        Connection connection = null;
        try {

            // create a connection to the database
            connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT last_name, first_name FROM students;");
            List<String> surnames = new ArrayList<>();
            while (resultSet.next()){
                System.out.println(resultSet.getString("first_name"));
                surnames.add(resultSet.getString("last_name"));
            }
            System.out.println();
            for (String surname : surnames){
                System.out.println(surname);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

