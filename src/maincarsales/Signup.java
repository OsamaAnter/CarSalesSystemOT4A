/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincarsales;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author eng osama anter
 */
public class Signup {

    public static List<User> users = new LinkedList<User>();
    static String gender;

    Button btn_signup, btn_back;
    static TextField t_name, t_uname, t_phonenumber, t_id;
    static PasswordField password;
    static RadioButton male, female;

    private Scene scene;

    public Scene return_scene() {
        if (scene == null) {
            Group G_signup = new Group();

            Line line = new Line(800, 100, 800, 650);
            line.setFill(Color.BLANCHEDALMOND);

            Font font2 = new Font("plain", 25);
            new Font("plain", 20);

            Text title = new Text(100, 150, "Welcome in OT4A ");
            title.setFont(Constants.getFont1());
            title.setFill(Color.ANTIQUEWHITE);

            Text name = new Text(900, 50, "Name ");
            name.setFont(font2);
            name.setFill(Color.BLANCHEDALMOND);

            t_name = new TextField();
            t_name.setLayoutX(945);
            t_name.setLayoutY(80);
            t_name.setScaleX(1.5);
            t_name.setScaleY(1.5);
            t_name.setPromptText("Enter Your name");

            Text username = new Text(900, 170, "Username ");

            username.setFont(font2);
            username.setFill(Color.BLANCHEDALMOND);

            t_uname = new TextField();
            t_uname.setLayoutX(945);
            t_uname.setLayoutY(200);
            t_uname.setScaleX(1.5);
            t_uname.setScaleY(1.5);
            t_uname.setPromptText("Enter Username");

            Text pass = new Text(900, 290, "Password ");
            pass.setFont(font2);
            pass.setFill(Color.BLANCHEDALMOND);

            password = new PasswordField();
            password.setLayoutX(945);
            password.setLayoutY(320);
            password.setScaleX(1.5);
            password.setScaleY(1.5);
            password.setPromptText("Enter Strong Password");

            Text phonenumber = new Text(900, 410, "Phone number");
            phonenumber.setFont(font2);
            phonenumber.setFill(Color.BLANCHEDALMOND);

            t_phonenumber = new TextField();
            t_phonenumber.setLayoutX(945);
            t_phonenumber.setLayoutY(440);
            t_phonenumber.setScaleX(1.5);
            t_phonenumber.setScaleY(1.5);
            t_phonenumber.setPromptText("Enter Your Phone Number");

            Text id = new Text(900, 530, "Your ID");
            id.setFont(font2);
            id.setFill(Color.BLANCHEDALMOND);

            t_id = new TextField();
            t_id.setLayoutX(945);
            t_id.setLayoutY(560);
            t_id.setScaleX(1.5);
            t_id.setScaleY(1.5);
            t_id.setPromptText("Enter Your ID");

            male = new RadioButton("Male");
            male.setLayoutX(910);
            male.setLayoutY(650);
            male.setScaleX(1.5);
            male.setScaleY(1.5);
            male.setTextFill(Color.ANTIQUEWHITE);

            female = new RadioButton("Female");
            female.setLayoutX(1080);
            female.setLayoutY(650);
            female.setScaleX(1.5);
            female.setScaleY(1.5);
            female.setTextFill(Color.ANTIQUEWHITE);

            ToggleGroup gender = new ToggleGroup();
            gender.getToggles().addAll(female, male);

            btn_signup = new Button("Register ");
            btn_signup.setTextFill(Color.ANTIQUEWHITE);
            btn_signup.setLayoutX(1210);
            btn_signup.setLayoutY(700);
            btn_signup.setFont(new Font("Arail", 30));
            btn_signup.setPrefSize(160, 70);
            btn_signup.setBackground(new Background(
                    new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

            btn_signup.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                btn_signup.setEffect(Constants.getShadow());
            });
            btn_signup.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                btn_signup.setEffect(null);
            });
            btn_signup.setOnAction((ActionEvent event) -> {
                check();
                System.out.println("Register ");
            });

            btn_back = new Button("Back", Constants.getBackImage());
            btn_back.setTextFill(Color.ANTIQUEWHITE);
            btn_back.setLayoutX(800);
            btn_back.setLayoutY(700);
            btn_back.setFont(new Font("Arail", 30));
            btn_back.setPrefSize(160, 70);
            btn_back.setBackground(new Background(
                    new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

            btn_back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                btn_back.setEffect(Constants.getShadow());
            });
            btn_back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                btn_back.setEffect(null);
            });
            btn_back.setOnAction((ActionEvent event) -> {
                ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
                        .setScene(ApplicationRegistery.getApplicationRegistery().getLoginScene());
                t_name.clear();
                password.clear();
                t_phonenumber.clear();
                t_id.clear();
                t_uname.clear();
                male.setSelected(false);
                female.setSelected(false);
            });

            ImageView image = new ImageView(new Image(getClass().getResourceAsStream("grap.png")));
            image.setLayoutX(140);
            image.setLayoutY(170);
            image.setFitHeight(450);
            image.setFitWidth(650);

            ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("logo1_1.png")));
            logo.setLayoutX(20);
            logo.setLayoutY(650);
            logo.setFitHeight(150);
            logo.setFitWidth(140);

            G_signup.getChildren().addAll(image, line, title, name, t_name, username, t_uname, pass, password);
            G_signup.getChildren().addAll(phonenumber, t_phonenumber, id, t_id, male, female, btn_signup, logo,
                    btn_back);

            scene = new Scene(G_signup, 1400, 800, Color.BLUEVIOLET);
        }
        return scene;
    }

    public static void check() {

        if ("".equals(t_name.getText())) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Name");
        } else if ("".equals(t_uname.getText())) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Username");
        } else if ("".equals(password.getText())) {
            JOptionPane.showMessageDialog(null, "Please Enter Your password");
        } else if (password.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "invalid password Please Enter password at least 8 characters ");
        } else if (t_phonenumber.getText().length() != 11) {
            JOptionPane.showMessageDialog(null, "Please Enter Valid number from 11 numbers");
        } else if (t_id.getText().length() != 14) {
            JOptionPane.showMessageDialog(null, "Please Enter Valid ID from 14 numbers");
        } else if (male.isSelected() == false && female.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "please Choose Your Gender");
        } else {

            //store in the database
            try {

                if (male.isSelected()) {

                    gender = "male";
                }
                if (female.isSelected()) {

                    gender = "female";
                }
                Database.insertUser();
                User user = new User();
                user.setName(t_name.getText());
                user.setId(t_id.getText());
                user.setPassword(password.getText());
                user.setPhone(t_phonenumber.getText());
                user.setUsername(t_uname.getText());
                user.setSex(gender);

                users.add(user);
                t_name.clear();
                password.clear();
                t_phonenumber.clear();
                t_id.clear();
                t_uname.clear();
                male.setSelected(false);
                female.setSelected(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            //end

        }
    }

}
