package Dao;

import models.Profile;

import java.util.List;

public interface ProfileDao {

//    create
    void add(Profile profile);

//    Read
    List<Profile> getAllProfile();
    Profile getProfileById(int id);

//Update
    void update(int id, String username, String bio, String location, String friendlist);

//    Delete
    void deleteById(int id);
    void clearAllProfile();
}
