package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

       Car car1 = new Car("car1",1);
       Car car2 = new Car("car2",2);
       Car car3 = new Car("car3",3);
       Car car4 = new Car("car4",4);

       user1.setUsersCar(car1);
       user2.setUsersCar(car2);
       user3.setUsersCar(car3);
       user4.setUsersCar(car4);

      UserService userService = context.getBean(UserService.class);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

     User test = userService.getUserByCar("car3",3);
      System.out.println(test);


//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}
