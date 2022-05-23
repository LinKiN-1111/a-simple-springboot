package games.linkin.service;

import games.linkin.dao.UserDao;
import games.linkin.pojo.User;

public interface UserService {

    public User login(User user);
}
