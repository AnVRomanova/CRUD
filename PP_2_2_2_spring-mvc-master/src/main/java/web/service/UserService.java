package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void add(User user) {
        userRepository.addUser(user);

    }

    @Override
    public List<User> listUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User readUser(long id) {
        return userRepository.readUser(id);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userRepository.edit(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }


}
