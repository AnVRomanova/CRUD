package web.service;

import web.model.User;

import java.util.List;

public interface UserServiceInterface {
    void add(User user);

    List<User> listUsers();

    User readUser(long id);

    void edit(User user);

    void delete(long id);
}
