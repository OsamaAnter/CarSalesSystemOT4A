/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincarsales;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class Usermenu {

    private Scene scene;
    private Group G_usermenu;

    public Scene return_scene() {

        if (scene == null) {
            G_usermenu = new Group();

            // Buttons
            ImageView caricons = new ImageView(new Image(getClass().getResourceAsStream("car.png")));
            caricons.setFitHeight(30);
            caricons.setFitWidth(30);
            Button btnshow = new Button("View Car List", caricons);
            btnshow.setTextFill(Color.BISQUE);
            btnshow.setLayoutX(80);
            btnshow.setLayoutY(200);
            btnshow.setFont(new Font("Arail", 35));
            btnshow.setPrefSize(280, 70);
            btnshow.setBackground(new Background(
                    new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
            btnshow.setOnAction((ActionEvent event) -> {
                System.out.println("Show");
                ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
                        .setScene(ApplicationRegistery.getApplicationRegistery().getViewScene());
            });

            btnshow.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                btnshow.setEffect(Constants.getShadow());
            });
            btnshow.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                btnshow.setEffect(null);
            });

            ImageView search = new ImageView(new Image(getClass().getResourceAsStream("search.png")));
            search.setFitHeight(30);
            search.setFitWidth(30);
            Button btnsearch = new Button(" Search a car", search);
            btnsearch.setTextFill(Color.BISQUE);
            btnsearch.setLayoutX(80);
            btnsearch.setLayoutY(320);
            btnsearch.setFont(new Font("Arail", 35));
            btnsearch.setPrefSize(280, 70);
            btnsearch.setBackground(new Background(
                    new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
            btnsearch.setOnAction((ActionEvent event) -> {
                System.out.println("search for a car ");
                ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
                        .setScene(ApplicationRegistery.getApplicationRegistery().getSearchScene());
            });

            btnsearch.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                btnsearch.setEffect(Constants.getShadow());
            });
            btnsearch.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                btnsearch.setEffect(null);
            });

            ImageView setting = new ImageView(new Image(getClass().getResourceAsStream("icons8_Settings_25px.png")));
            setting.setFitHeight(30);
            setting.setFitWidth(30);
            Button btnsetting = new Button("  Setting   ", setting);
            btnsetting.setTextFill(Color.BISQUE);
            btnsetting.setLayoutX(80);
            btnsetting.setLayoutY(460);
            btnsetting.setFont(new Font("Arail", 40));
            btnsetting.setPrefSize(280, 70);
            btnsetting.setBackground(new Background(
                    new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
            btnsetting.setOnAction((ActionEvent event) -> {
                System.out.println("Setting ");
                ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
                        .setScene(ApplicationRegistery.getApplicationRegistery().getSettingScene());
            });

            btnsetting.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                btnsetting.setEffect(Constants.getShadow());
            });
            btnsetting.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                btnsetting.setEffect(null);
            });

            ImageView logout = new ImageView(
                    new Image(getClass().getResourceAsStream("icons8_Logout_Rounded_Up_25px.png")));
            logout.setFitHeight(30);
            logout.setFitWidth(30);
            Button btnlogout = new Button(" Log Out   ", logout);
            btnlogout.setTextFill(Color.BISQUE);
            btnlogout.setLayoutX(80);
            btnlogout.setLayoutY(620);
            btnlogout.setFont(new Font("Arail", 40));
            btnlogout.setPrefSize(280, 70);
            btnlogout.setBackground(new Background(
                    new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
            btnlogout.setOnAction((ActionEvent event) -> {
                System.out.println("log out ");
                ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
                        .setScene(ApplicationRegistery.getApplicationRegistery().getLoginScene());
            });

            btnlogout.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                btnlogout.setEffect(Constants.getShadow());
            });
            btnlogout.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                btnlogout.setEffect(null);
            });

            Line line = new Line(400, 150, 400, 700);
            line.setFill(Color.ANTIQUEWHITE);

            Text title = new Text(100, 100, "Menu");
            title.setFont(Constants.getFont1());
            title.setFill(Color.ANTIQUEWHITE);

            Text title2 = new Text(550, 150, "Welcome in ..");
            title2.setFont(Constants.getFont1());
            title2.setFill(Color.ANTIQUEWHITE);
            title2.setUnderline(true);

            ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("logo.png")));
            logo.setLayoutX(600);
            logo.setLayoutY(200);
            logo.setFitHeight(500);
            logo.setFitWidth(400);

            G_usermenu.getChildren().addAll(line, logo, btnlogout, btnsetting, btnsearch, btnshow, title, title2);

            scene = new Scene(G_usermenu, 1400, 800, Color.BLUEVIOLET);
        }

        return scene;

    }
}
