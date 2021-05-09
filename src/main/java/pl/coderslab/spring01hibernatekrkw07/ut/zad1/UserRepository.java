package pl.coderslab.spring01hibernatekrkw07.ut.zad1;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private int nextId = 1;
    private Map<Integer, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public int size() {
        return users.size();
    }

    // Tworzenie użytkownika.
    public void create(User user) {
        final int thisId = nextId++;
        user.setId(thisId);
        User toStore = new User(user);
        this.users.put(thisId, toStore);
    }

    public User findById(int id) {
        return this.users.get(id);
    }
    //Edycję użytkownika.
    public void update(User user) {
        final User stored = this.users.get(user.getId());
        if (stored == null) {
            throw new InvalidParameterException(String.format("User with id=%s not contained in this repository.", user.getId()));
        }
        stored.setName(user.getName());
        stored.setEmail(user.getEmail());
    }

    public void delete(User user) {
        this.users.remove(user.getId());
    }

//Usuwanie użytkownika.

}