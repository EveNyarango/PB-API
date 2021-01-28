package models;

import java.util.Objects;

public class Updates {
    private int id;
    private String name;
    private String post;
    private String comment;

    public Updates(String post, String comment, String name) {
        this.name = name;
        this.post = post;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Updates)) return false;
        Updates updates = (Updates) o;
        return getId() == updates.getId() &&
                Objects.equals(getName(), updates.getName()) &&
                Objects.equals(getPost(), updates.getPost()) &&
                Objects.equals(getComment(), updates.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPost(), getComment());
    }
}
