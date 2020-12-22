import Dao.Sql2oProfileDao;
import Dao.Sql2oUpdatesDao;
import com.google.gson.Gson;
import org.sql2o.Sql2o;
import static spark.Spark.*;

import org.sql2o.Connection;

public class App {
    public static void main (String[] args) {
        Sql2oProfileDao ProfileDao;
        Sql2oUpdatesDao UpdatesDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString =  ("jdbc:postgresql://localhost:5432/pome");

        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Nya2rango@");

        ProfileDao = new Sql2oProfileDao(sql2o);
        UpdatesDao = new Sql2oUpdatesDao(sql2o);
        conn = sql2o.open();

//        Homepage
        get("/", "application/json", (req, res) ->
                "{\"message\":\"Welcome to the organisation news application.\"}");

        post("/p");
    }
}
