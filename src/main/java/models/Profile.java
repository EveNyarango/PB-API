package models;
import java.sql.Timestamp;
import java.util.Objects;

public class Profile {
    private int id;
    private String username;
    private String bio;
    private String location;
    private String email;
    private String imageurl;
    private Timestamp createdat;


    public Profile(String username, String bio, String location, String email, String imageurl) {
        this.username = username;
        this.bio = bio;
        this.location = location;
        this.email = email;
        this.imageurl = imageurl;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getImageurl() {
        return imageurl;
    }

    public void setImageUrl(String imageurl) {
        this.imageurl = imageurl;
    }


    public Timestamp getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Timestamp createdat) {
        this.createdat = createdat;
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
                Objects.equals(getEmail(), profile.getEmail()) &&
                Objects.equals(getImageurl(), profile.getImageurl()) &&
                Objects.equals(getCreatedat(), profile.getCreatedat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getBio(), getLocation(), getEmail(), getImageurl(), getCreatedat());
    }

}


