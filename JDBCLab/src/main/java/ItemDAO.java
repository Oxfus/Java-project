import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDAO {

    private Connection connection;

    public ItemDAO(Connection connection) {
        this.connection = connection;
    }

    public String searchById(int id) throws SQLException {
        String query = "SELECT * FROM ITEM WHERE ID = %d";
        query = String.format(query, id);

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        StringBuilder stringBuilder = new StringBuilder();

        while (rs.next()) {
            int numColumns = rs.getMetaData().getColumnCount();
            System.out.println("numColumns: " + numColumns);

            for (int i = 1; i <= numColumns; i++) {
                Object obj = rs.getObject(i);
                stringBuilder.append((obj != null) ? obj.toString() : "null");
                if (i < numColumns) stringBuilder.append(", ");
            }
        }

        stmt.close();
        rs.close();

        return stringBuilder.toString();
    }

    public ArrayList<MusicItem> searchByKeyword(String keyword) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM ITEM WHERE NAME LIKE \'" + keyword + "\'";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<MusicItem> rowsArrFoodItem = new ArrayList<>();

        while (rs.next()) {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList rowArr = new ArrayList();

            int numColumns = rs.getMetaData().getColumnCount();
            System.out.println("numColumns: " + numColumns);

            for (int i = 1; i <= numColumns; i++) {
                Object obj = rs.getObject(i);
                stringBuilder.append((obj != null) ? obj.toString() : "null");
                if (i < numColumns) stringBuilder.append(", ");
            }

            String row = stringBuilder.toString();

            String[] rowArrStr = row.split(", ");

            for (String rowElement : rowArrStr) {
                rowArr.add(rowElement);
            }
            System.out.println(Float.parseFloat(rowArr.get(2).toString()));

            rowsArrFoodItem.add(
                    new MusicItem(
                            Integer.valueOf(rowArr.get(0).toString()),
                            rowArr.get(1).toString(),
                            Float.parseFloat(rowArr.get(2).toString()),
                            Category.valueOf(rowArr.get(3).toString())
                    )
            );
        }

        stmt.close();
        rs.close();
        return rowsArrFoodItem;
    }


    void create(MusicItem item) throws SQLException {
        String query = "INSERT INTO ITEM (ID, NAME, PRICE ,CATEGORY) VALUES (" +
                item.getID() + ", " +
                "\'" + item.getName() + "\'" + ", " +
                item.getPrice() + ", " +
                "\'" + item.getCategory() + "\'"  + ")";
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);

        connection.close();
        stmt.close();

    }

}
