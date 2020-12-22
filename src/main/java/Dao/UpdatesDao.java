package Dao;

import models.Updates;

import java.io.Reader;
import java.util.List;

public interface UpdatesDao {

    //    List
    List<Updates> getAllUpdates();

//    create
    void add(Updates updates);

//    Read
    Updates findById(int id);

//    Updates
    void update(int id, String post, String Comment);

//    Delete
    void deleteById(int id);
    void clearAllUpdates();
}
