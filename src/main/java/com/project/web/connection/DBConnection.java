package com.project.web.connection;

import com.project.web.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBConnection {

    //параметри котрі використовуються для підключення до нашої БД
    private String url = "jdbc:mysql://localhost:3306/simplecrud";
    private String username = "root";
    private String password = "root";

    Connection connection; //обєкт connection для створення зєднання з базою даних та створення обєктів типу statement

    public DBConnection() {
        try {
            //ініціалізація connection за допомогою методу getConnection() в яким ми передаємо параметри для доступу до БД(url, імя і пароль)
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не вдалося  підключитися до БД, перевірте дані!");
        }
    }

    public void save(User user){
        //обєкт prepared statement використовується для виконання SQL запитів, крім нього існує ще statement та callable statement
        try(PreparedStatement statement = connection.prepareStatement("INSERT INTO user (name, surname, age) VALUES (?, ?, ?)")){
            //замість ? ми підставляємо параметри за допомогою методів:
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setInt(3, user.getAge());
            statement.executeUpdate();//метод для виконання SQL запиту типу INSERT і DELETE

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> select(){

        List<User> users = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM user")){
            ResultSet resultSet = statement.executeQuery();
            //result set це обєкт який використовується для зберігання інформаціїї яку ми дістаємо з таблиці
            //з цього обєкту ми можемо витягнути цю інформацію за допомогою відповідних методів:
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                int age = resultSet.getInt(4);

                users.add(new User(id, name, surname, age));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void delete(int id){

        try(PreparedStatement statement = connection.prepareStatement("DELETE  FROM user WHERE id = (?)")){
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User olduser, User currentuser){

    }

}
