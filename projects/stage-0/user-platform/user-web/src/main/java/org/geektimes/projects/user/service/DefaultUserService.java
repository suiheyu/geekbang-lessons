package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.InMemoryUserRepository;
import org.geektimes.projects.user.repository.UserRepository;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/03/03
 * @link
 * @see
 */
public class DefaultUserService implements UserService{

    private UserRepository userRepository;

    public DefaultUserService() {
        UserRepository repository = new InMemoryUserRepository();
        this.userRepository = repository;
    }

    @Override
    public boolean register(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
