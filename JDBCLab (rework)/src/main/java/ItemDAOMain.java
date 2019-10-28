import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemDAOMain {
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionCreator.createConnection();

            ItemDAO dao = new ItemDAO(conn);

            String row = dao.searchById(0);
            String[] rowArrStr = row.split(", ");
            ArrayList<String> rowArr = new ArrayList<>(Arrays.asList(rowArrStr));

            dao.searchByKeyword("Fanta").forEach(MusicItem::printAll);
            MusicItem testItem = new MusicItem(
                    Integer.valueOf(rowArr.get(0)),
                    rowArr.get(1),
                    Float.parseFloat(rowArr.get(2)),
                    Category.valueOf(rowArr.get(3))
            );

            MusicItem testItem2 = new MusicItem(5, "Cup", 240, Category.GENERAL);
            dao.create(testItem2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
