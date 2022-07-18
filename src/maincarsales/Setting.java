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
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
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
public class Setting {

	private Scene scene;
	Label l_name, l_id, l_phone, L_gender;

	public Scene return_scene() {

		if (scene == null) {
			Group G_setting = new Group();

			// Fonts
			Font font2 = new Font("plain", 30);


			// Buttons
			Button btninfo = new Button("Your Info...");
			btninfo.setTextFill(Color.BISQUE);
			btninfo.setLayoutX(100);
			btninfo.setLayoutY(250);
			btninfo.setFont(new Font("Arail", 36));
			btninfo.setPrefSize(280, 70);
			btninfo.setBackground(new Background(
					new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

			btninfo.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				btninfo.setEffect(Constants.getShadow());
			});
			btninfo.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				btninfo.setEffect(null);
			});

			Button editinfo = new Button("Edit info...");
			editinfo.setTextFill(Color.BISQUE);
			editinfo.setLayoutX(100);
			editinfo.setLayoutY(350);
			editinfo.setFont(new Font("Arail", 36));
			editinfo.setPrefSize(280, 70);
			editinfo.setBackground(new Background(
					new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

			editinfo.setOnAction((ActionEvent event) -> {
				System.out.println("edit info ");
				JOptionPane.showMessageDialog(null, "Waiting Working on it !!!!");
			});

			editinfo.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				editinfo.setEffect(Constants.getShadow());
			});
			editinfo.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				editinfo.setEffect(null);
			});

			Button btnback = new Button(" Back ", Constants.getBackImage());
			btnback.setTextFill(Color.BISQUE);
			btnback.setLayoutX(80);
			btnback.setLayoutY(650);
			btnback.setFont(new Font("Arail", 40));
			btnback.setPrefSize(280, 70);
			btnback.setBackground(new Background(
					new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

			btnback.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				btnback.setEffect(Constants.getShadow());
			});
			btnback.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				btnback.setEffect(null);
			});

			Line line = new Line(450, 150, 450, 650);
			line.setFill(Color.ANTIQUEWHITE);

			ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("logo1_1.png")));
			logo.setLayoutX(1250);
			logo.setLayoutY(650);
			logo.setFitHeight(150);
			logo.setFitWidth(150);

			Text title = new Text(100, 100, "Menu");
			title.setFont(Constants.getFont1());
			title.setFill(Color.ANTIQUEWHITE);

			Text title2 = new Text(500, 200, "Your Information");
			title2.setFont(Constants.getFont1());
			title2.setFill(Color.ANTIQUEWHITE);

			Text name = new Text(500, 300, "-Your Name :\n\n-your ID:\n\n-Your Phone :\n\n-Your Gender:");
			name.setFont(font2);
			name.setFill(Color.ANTIQUEWHITE);

			l_name = new Label("Osama Anter Mohamed");
			l_name.setLayoutX(700);
			l_name.setLayoutY(270);
			l_name.setFont(font2);
			l_name.setTextFill(Color.ANTIQUEWHITE);

			l_id = new Label("01098741325945");
			l_id.setLayoutX(700);
			l_id.setLayoutY(350);
			l_id.setFont(font2);
			l_id.setTextFill(Color.ANTIQUEWHITE);

			l_phone = new Label("01116741831");
			l_phone.setLayoutX(700);
			l_phone.setLayoutY(430);
			l_phone.setFont(font2);
			l_phone.setTextFill(Color.ANTIQUEWHITE);

			L_gender = new Label("Male");
			L_gender.setLayoutX(700);
			L_gender.setLayoutY(510);
			L_gender.setFont(font2);
			L_gender.setTextFill(Color.ANTIQUEWHITE);

			btninfo.setOnAction((ActionEvent event) -> {
				System.out.println("my info ");
				G_setting.getChildren().addAll(name, l_name, l_id, l_phone, L_gender, title2);
			});

			btnback.setOnAction((ActionEvent event) -> {
				System.out.println("back ");
				ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
						.setScene(ApplicationRegistery.getApplicationRegistery().getUserScene());
				G_setting.getChildren().removeAll(name, l_name, l_id, l_phone, L_gender, title2);
			});

			G_setting.getChildren().addAll(btnback, title, logo, btninfo, editinfo, line);

			scene = new Scene(G_setting, 1400, 800, Color.BLUEVIOLET);
		}

		return scene;
	}
}
