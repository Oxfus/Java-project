import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO {
    static final String SEARCH_BY_ID = "SELECT * FROM ITEM WHERE ID = %d";
    static final String SEARCH_BY_KEYWORD_QUERY = "SELECT * FROM ITEM WHERE NAME LIKE \'%s\'";
    static final String INSERT_QUERY = "INSERT INTO ITEM (ID, NAME, PRICE ,CATEGORY) VALUES (%d, \'%s\', \'%s\')";
    private Connection connection;

    public ItemDAO(Connection connection) {
        this.connection = connection;
    }

    public String searchById(int id) throws SQLException {

        String query = String.format(SEARCH_BY_ID, id);

        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        if (rs == null)
            throw new SQLException();

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

    public ArrayList<MusicItem> searchByKeyword(String keyword) throws SQLException {

        String query = String.format(SEARCH_BY_KEYWORD_QUERY, keyword);

        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        if (rs == null)
            throw new SQLException();

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

        String query = String.format(INSERT_QUERY, item.getID(), item.getName(), item.getCategory());
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.executeUpdate();

        connection.close();
        stmt.close();

    }

}
