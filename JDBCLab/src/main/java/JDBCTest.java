import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:D:/lab4.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Driver name: " + dbmd.getDriverName());

            ItemDAO dao = new ItemDAO(conn);

            System.out.println(dao.searchById(1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}