package Dao;

import models.Updates;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUpdatesDao implements UpdatesDao {

    private Sql2o sql2o;

    public Sql2oUpdatesDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Updates updates) {
        String sql = "INSERT INTO updates (post, comment) VALUES (:post, :comment)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .throwOnMappingFailure(false)
                    .bind(updates)
                    .addParameter("post", updates.getPost())
                    .addParameter("comment", updates.getComment())
                    .executeUpdate()
                    .getKey();
                    updates.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Updates> getAllUpdates() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM updates";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Updates.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public Updates findById(int id) {
try (Connection con = sql2o.open()){
    return con.createQuery("SELECT * FROM updates WHERE id = :id")
         .addParameter("id", id)
         .executeAndFetchFirst(Updates.class);
}
    }

    @Override
    public void update(int id, String newPost, String newComment) {
String sql = "UPDATE updates SET (post, comment)";
try(Connection con = sql2o.open()){
    con.createQuery(sql)
            .addParameter("post", newPost)
            .addParameter("comment", newComment)
            .addParameter("id", id)
            .executeUpdate();
} catch (Sql2oException ex) {
    System.out.println(ex);
}
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from updates WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllUpdates() {
        String sql = "DELETE from updates";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
