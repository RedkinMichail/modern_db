
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConnectionToDB {
    private Connection getConnection() throws Exception {
//        Class.forName("org.postgresql.Driver").newInstance()
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/postgres";
        return DriverManager.getConnection(url,"postgres", "postgres");
    }

    public List getProductIds() throws Exception {
        List productIds = new ArrayList();
        // Получение соединения с БД
        Connection con = getConnection();
        // Выполнение SQL-запроса
        ResultSet rs = con.createStatement().executeQuery(
                "Select id From subjects_names");
        // Перечисляем результаты выборки
        while (rs.next()) {
            // Из каждой строки выборки выбираем
            // результат и помещаем в коллекцию
            productIds.add(rs.getInt(1));
        }
// Закрываем выборку и соединение с БД
        rs.close();
        con.close();
        return productIds;
    }
}
