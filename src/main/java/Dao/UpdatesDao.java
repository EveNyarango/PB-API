package Dao;

import models.Updates;

import java.io.Reader;
import java.util.List;

public interface UpdatesDao {

//    create
    void add(Updates updates);

//    Read
List<Updates> getAllUpdates();
    Updates findById(int id);

//    Updates
    void update(int id, String name, String post, String Comment);

//    Delete
    void deleteById(int id);
    void clearAllUpdates();
}
