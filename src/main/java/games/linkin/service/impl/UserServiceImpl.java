package games.linkin.service.impl;

import games.linkin.dao.UserDao;
import games.linkin.pojo.User;
import games.linkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        User user1 = userDao.selectByUsernameAndPasswordUser(user);
        return user1;
    }
}
