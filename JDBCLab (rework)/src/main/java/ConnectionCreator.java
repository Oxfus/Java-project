import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static String url = "jdbc:sqlite:lab4.db";

    public static Connection createConnection() throws SQLException {
        try (Connection conn = DriverManager.getConnection(url)){
            if (conn != null) {
                DatabaseMetaData dbmd = conn.getMetaData();
                if (dbmd == null) {
                    throw new SQLException();
                }
                System.out.println("Driver name: " + dbmd.getDriverName());
                System.out.println("User name: " + dbmd.getUserName());
                System.out.println("Schema name: " + dbmd.getSchemaTerm());
                ItemDAO dao = new ItemDAO(conn);

                System.out.println(dao.searchById(1));
                return conn;
            }
        } catch (SQLException e) {
            throw new SQLException();
        }
        return null;
    }
}
