package models;

public class Profile {
    private int id;
    private String username;
    private String bio;
    private String location;
    private  String friendlist;

    public Profile(String username, String bio, String location, String friendlist) {
        this.username = username;
        this.bio = bio;
        this.location = location;
        this.friendlist = friendlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFriendlist() {
        return friendlist;
    }

    public void setFriendlist(String friendlist) {
        this.friendlist = friendlist;
    }
}
