/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincarsales;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
public class login {

	// Global Variable
	Button btn_signin, btn_signup ,btn_aboutus;
	TextField i_name, password;
	Boolean logincheck = false;

	private Scene scene;

	// function retyrn scene
	public Scene return_scene() {

		// Check scene
		if (scene == null) {

			Group G_login = new Group();

			// buttons
			btn_signin = new Button("Sign In");
			btn_signin.setTextFill(Color.ANTIQUEWHITE);
			btn_signin.setLayoutX(900);
			btn_signin.setLayoutY(500);
			btn_signin.setFont(new Font("Arail", 30));
			btn_signin.setPrefSize(150, 70);
			btn_signin.setBackground(new Background(
					new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

			btn_signin.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				btn_signin.setEffect(Constants.getShadow());
			});
			btn_signin.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				btn_signin.setEffect(null);
			});
			btn_signin.setOnAction((ActionEvent event) -> {
				log_check();
				System.out.println("sign in ");
			});

			btn_signup = new Button("Sign Up");
			btn_signup.setTextFill(Color.ANTIQUEWHITE);
			btn_signup.setLayoutX(1100);
			btn_signup.setLayoutY(500);
			btn_signup.setFont(new Font("Arail", 30));
			btn_signup.setPrefSize(150, 70);
			btn_signup.setBackground(new Background(
					new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

			btn_signup.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				btn_signup.setEffect(Constants.getShadow());
			});
			btn_signup.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				btn_signup.setEffect(null);
			});

			btn_signup.setOnAction((ActionEvent event) -> {
				ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
						.setScene(ApplicationRegistery.getApplicationRegistery().getSignupScene());
			});
                        
                        btn_aboutus = new Button("about Us");
			btn_aboutus.setTextFill(Color.ANTIQUEWHITE);
			btn_aboutus.setLayoutX(50);
			btn_aboutus.setLayoutY(700);
			btn_aboutus.setFont(new Font("Arail", 30));
			btn_aboutus.setPrefSize(200, 95);
			btn_aboutus.setBackground(new Background(
					new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

			btn_aboutus.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				btn_aboutus.setEffect(Constants.getShadow());
			});
			btn_aboutus.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				btn_aboutus.setEffect(null);
			});

			btn_aboutus.setOnAction((ActionEvent event) -> {
				ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
						.setScene(ApplicationRegistery.getApplicationRegistery().getAboutus());
			});

			// Fonts
			Font font2 = new Font("plain", 25);
			new Font("plain", 20);

			Line line = new Line(800, 150, 800, 650);
			line.setFill(Color.ANTIQUEWHITE);

			// Texts
			Text name, title, pass;

			title = new Text(100, 150, "Car Sales System ");
			title.setFont(Constants.getFont1());
			title.setFill(Color.ANTIQUEWHITE);

			name = new Text(900, 190, "Username ");
			name.setFont(font2);
			name.setFill(Color.BLANCHEDALMOND);

			pass = new Text(900, 330, "Password ");
			pass.setFont(font2);
			pass.setFill(Color.BLANCHEDALMOND);

			// Textfields
			i_name = new TextField();
                        i_name.setPromptText("Enter Username ");
			i_name.setLayoutX(945);
			i_name.setLayoutY(225);
			i_name.setScaleX(1.5);
			i_name.setScaleY(1.5);
			i_name.setOnKeyReleased(event -> {
				if (event.getCode().equals(KeyCode.ENTER)) {
					log_check();
				}
			});

			password = new PasswordField();
			password.setLayoutX(945);
			password.setLayoutY(365);
			password.setScaleX(1.5);
			password.setScaleY(1.5);
                        password.setPromptText("Enter Password");
			password.setOnKeyReleased(event -> {
				if (event.getCode().equals(KeyCode.ENTER)) {
					log_check();
				}
			});

			// Images
			ImageView image, logo;

			image = new ImageView(new Image(getClass().getResourceAsStream("v1.png")));
			image.setLayoutX(140);
			image.setLayoutY(220);
			image.setFitHeight(350);
			image.setFitWidth(450);

			logo = new ImageView(new Image(getClass().getResourceAsStream("logo1_1.png")));
			logo.setLayoutX(1250);
			logo.setLayoutY(650);
			logo.setFitHeight(150);
			logo.setFitWidth(150);

			// print items
			G_login.getChildren().addAll(line, i_name, title, name, pass, password, logo, image, btn_signin,
					btn_signup,btn_aboutus);

			scene = new Scene(G_login, 1400, 800, Color.BLUEVIOLET);

		}
		return scene;
	}

	// Function check log in account
	public void log_check() {
		logincheck = false;
		if (i_name.getText().equals(Admin.username) && password.getText().equals(Admin.password)) {
			ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
					.setScene(ApplicationRegistery.getApplicationRegistery().getAdminScene());
			i_name.clear();
			password.clear();
		} else {
			for (User user : Signup.users) {
				if (i_name.getText().equals(user.getUsername()) && (password.getText().equals(user.password))) {
					logincheck = true;
					break;
				}
			}
			if (logincheck) {
				i_name.clear();
				password.clear();
				ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
						.setScene(ApplicationRegistery.getApplicationRegistery().getUserScene());
			} else {
				JOptionPane.showMessageDialog(null, "Invalid mail");
			}
		}
	}

}
