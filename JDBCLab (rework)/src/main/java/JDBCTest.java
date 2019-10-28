import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JDBCTest {

    public static void main(String[] args) {
        try {
            Connection conn = ConnectionCreator.createConnection();
            if (conn != null) {
                DatabaseMetaData dbmd = conn.getMetaData();
                System.out.println("Driver name: " + dbmd.getDriverName());

                ItemDAO dao = new ItemDAO(conn);

                System.out.println(dao.searchById(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}