import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:D:/lab4.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Driver name: " + dbmd.getDriverName());

            ItemDAO dao = new ItemDAO(conn);

            String row = dao.searchById(0);
            String[] rowArrStr = row.split(", ");
            ArrayList rowArr = new ArrayList();
            for (String rowElement : rowArrStr) {
                rowArr.add(rowElement);
            }

            dao.searchByKeyword("Fanta").forEach(MusicItem::printAll);
            MusicItem testItem = new MusicItem(
                    Integer.valueOf(rowArr.get(0).toString()),
                    rowArr.get(1).toString(),
                    Float.parseFloat(rowArr.get(2).toString()),
                    Category.valueOf(rowArr.get(3).toString())
            );

            MusicItem testItem2 = new MusicItem(5,"Cup", 240, Category.GENERAL);
            dao.create(testItem2);
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
