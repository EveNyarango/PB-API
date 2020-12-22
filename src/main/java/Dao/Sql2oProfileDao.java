package Dao;

import models.Profile;
import org.sql2o.Sql2o;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oProfileDao implements ProfileDao{
    private final Sql2o sql2o;

    public Sql2oProfileDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Profile profile) {
String sql = "INSERT INTO profile (username, bio, location, friendlist) VALUES (:username, :bio, :location, :friendlist)";
    try (Connection con = sql2o.open()){
        int id = (int) con.createQuery(sql, true)
                .throwOnMappingFailure(false)
                .bind(profile)
                .addParameter("username", profile.getUsername())
                .addParameter("bio", profile.getBio())
                .addParameter("location", profile.getLocation())
                .addParameter("friendlist", profile.getFriendlist())
                .executeUpdate()
                .getKey();
        profile.setId(id);
    }catch (Sql2oException ex){
        System.out.println(ex);
    }
    }

    @Override
    public List<Profile> getAllProfile() {
        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM profile";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Profile.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public Profile getProfileById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM profile WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Profile.class);
        }
    }

    @Override
    public void update(int id, String newUsername, String newBio, String newLocation, String newFriendlist) {
String sql = "UPDATE profile SET ( (username, bio, location, friendlist) = (:username, bio, location, friendlist)";
try (Connection con = sql2o.open()){
    con.createQuery(sql)
            .addParameter("username", newUsername)
            .addParameter("bio", newBio)
            .addParameter("location", newLocation)
            .addParameter("friendlist", newFriendlist)
            .addParameter("id", id)
            .executeUpdate();
}catch (Sql2oException ex) {
    System.out.println(ex);
}
    }

    @Override
    public void deleteById(int id) {
String sql = "DELETE from profile WHERE id=:id";
try (Connection con = sql2o.open()) {
    con.createQuery(sql)
            .addParameter("id", id)
            .executeUpdate();
}catch (Sql2oException ex) {
    System.out.println(ex);
}
    }

    @Override
    public void clearAllProfile() {
        String sql = "DELETE from profile";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
