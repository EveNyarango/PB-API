package models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return getId() == profile.getId() &&
                Objects.equals(getUsername(), profile.getUsername()) &&
                Objects.equals(getBio(), profile.getBio()) &&
                Objects.equals(getLocation(), profile.getLocation()) &&
                Objects.equals(getFriendlist(), profile.getFriendlist());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getBio(), getLocation(), getFriendlist());
    }
}
