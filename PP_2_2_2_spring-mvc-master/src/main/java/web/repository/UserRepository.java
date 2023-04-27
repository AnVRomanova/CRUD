package web.repository;

import web.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    void addUser(User user);

    User readUser(long id);

    void edit(User user);

    void delete(long id);


}
