package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userdao;

    public UserServiceImp(UserDao userdao) {
        this.userdao = userdao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userdao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getListUsers() {
        return userdao.getListUsers();
    }


    @Transactional(readOnly = true)
    @Override
    public User getUserCar(Car car) {
        return userdao.getUserCar(car);

    }
}

