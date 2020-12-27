import Dao.Sql2oProfileDao;
import Dao.Sql2oUpdatesDao;
import com.google.gson.Gson;
import exception.ApiException;
import models.Profile;
import models.Updates;
import org.sql2o.Sql2o;
import static spark.Spark.*;

import org.sql2o.Connection;

import java.util.HashMap;
import java.util.Map;


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

//        Create

        post("/profile/new", "application/json", (req, res) -> {
            Profile profile = gson.fromJson(req.body(), Profile.class);
            ProfileDao.add(profile);
            res.status(201);
            res.type("application/json");
            return gson.toJson(profile);
        });

        post("/updates/new", "application/json", (req, res) -> {
            Updates updates = gson.fromJson(req.body(), Updates.class);
            UpdatesDao.add(updates);
            res.status(201);
            res.type("application/json");
            return gson.toJson(updates);
        });

        //        Read
        get("/profile", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(ProfileDao.getAllProfile());//send it back to be displayed
        });

        get("/updates", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(UpdatesDao.getAllUpdates());//send it back to be displayed
        });

        //FILTERS
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });


        after((req, res) ->{
            res.type("application/json");
        });


    }

}
