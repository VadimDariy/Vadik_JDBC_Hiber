package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getConnection();

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ульяна", "Дарий", (byte) 1);
        userService.saveUser("Татьяна", "Шишлакова", (byte) 40);
        userService.saveUser("Вадим", "Емельянов", (byte) 44);
        userService.saveUser("Нина", "Бондарь", (byte) 66);
        userService.saveUser("Владимир", "Евсюков", (byte) 73);
        userService.saveUser("Светлана", "Пирогова", (byte) 28);

        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
