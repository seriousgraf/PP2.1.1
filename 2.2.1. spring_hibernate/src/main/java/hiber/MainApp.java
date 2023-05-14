package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        Car car1 = new Car("model1", 1);
        Car car2 = new Car("model2", 2);
        Car car3 = new Car("model3", 3);
        Car car4 = new Car("model4", 4);

        userService.add(new User("name1", "lastName1", "name1@mail.com", car1));
        userService.add(new User("name2", "lastName2", "name2@mail.com", car2));
        userService.add(new User("name3", "lastName3", "name3@mail.com", car3));
        userService.add(new User("name4", "lastName4", "name4@mail.com", car4));

        List<User> listUsers = userService.getListUsers();
        for (User user : listUsers) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        System.out.println(userService.getUserCar(new Car("model1", 1)));


        context.close();
    }
}
