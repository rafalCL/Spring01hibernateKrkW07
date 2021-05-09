package pl.coderslab.spring01hibernatekrkw07.ut.zad1;

public class User {
    private int id;
    private String name;
    private String email;

    public User() {
    }

    public User(User source) {
        this.id = source.id;
        this.name = source.name;
        this.email = source.email;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
