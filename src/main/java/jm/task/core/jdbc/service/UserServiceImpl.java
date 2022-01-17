package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final UserDao userUserDaoJDVC = new UserDaoJDBCImpl();
    public void createUsersTable() {
      userUserDaoJDVC.createUsersTable();
    }

    public void dropUsersTable() {
      userUserDaoJDVC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
     userUserDaoJDVC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userUserDaoJDVC.removeUserById(id);

    }

    public List<User> getAllUsers() {
        return userUserDaoJDVC.getAllUsers();
    }

    public void cleanUsersTable() {
       userUserDaoJDVC.cleanUsersTable();
    }
}
