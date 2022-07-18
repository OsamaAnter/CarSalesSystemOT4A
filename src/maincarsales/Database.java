/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincarsales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class Database {

    private static final String user = "root";
    private static final String pass = "";
    private static final String add = "jdbc:mysql://localhost/carsales";
    static Connection connect;
    static Statement stat;
    static String query;
    static ResultSet result;
    static int id;

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(add, user, pass);
    }

    public static void insertCar() throws Exception {
        connect = Database.connect();
        stat = connect.createStatement();
        System.out.println("id === " + id);
        query = "INSERT INTO cars(name, model, year, color, counter, cost,id) VALUES ('" + Admin.nameField.getText() + "','" + Admin.modelField.getText() + "','" + Integer.parseInt(Admin.yearField.getText()) + "','" + Admin.colorField.getText() + "','" + Integer.parseInt(Admin.counterField.getText()) + "','" + Double.parseDouble(Admin.costField.getText()) + "','" + (id + 1) + "')";
        stat.execute(query);
        id++;
    }

    public static void insertUser() throws Exception {
        connect = Database.connect();
        stat = connect.createStatement();
        query = "INSERT INTO users(name, username, password, phone, id, gender) VALUES ('" + Signup.t_name.getText() + "','" + Signup.t_uname.getText() + "','" + Signup.password.getText() + "','" + Signup.t_phonenumber.getText() + "','" + Signup.t_id.getText() + "','" + Signup.gender + "')";
        stat.execute(query);
    }

    public static void insertCarInList() throws Exception {
        connect = Database.connect();
        stat = connect.createStatement();

        query = "SELECT * FROM cars";

        result = stat.executeQuery(query);

        while (result.next()) {
            Car car1 = new Car(result.getString("name"), result.getString("model"), result.getInt("year"), result.getString("color"), result.getInt("counter"), result.getDouble("cost"), result.getInt("id"));
            //System.out.println(car1);
            ApplicationList.applicationList.addCar(car1);
            id = result.getInt("id");

        }
        System.out.println("id = " + id);
    }

    public static void insertUserInList() throws Exception {
        connect = Database.connect();
        stat = connect.createStatement();

        query = "SELECT * FROM users";

        result = stat.executeQuery(query);
        while (result.next()) {
            User user1 = new User(result.getString("name"), result.getString("phone"), result.getString("id"), result.getString("gender"), result.getString("username"), result.getString("password"));
            Signup.users.add(user1);
        }
    }

    public static void deletCar(int idCar) throws Exception {
        connect = Database.connect();
        stat = connect.createStatement();
        query = "DELETE FROM cars WHERE id='" + idCar + "'";
        stat.execute(query);
    }

    public static void updateCar(int idCar) throws Exception {
        connect = Database.connect();
        stat = connect.createStatement();
        System.out.println("com  =  " + EditTable.comboBox.getValue());
        query = "UPDATE cars SET " + EditTable.comboBox.getValue() + "='" + EditTable.editField.getText() + "' WHERE id='" + idCar + "'";
        stat.execute(query);
    }
    public static void buyCar(int idCar,int count) throws Exception{
        connect = Database.connect();
        stat = connect.createStatement();
        query = "UPDATE cars SET counter='"+count+"' WHERE id='" + idCar + "'";
        stat.execute(query);
    }
}
