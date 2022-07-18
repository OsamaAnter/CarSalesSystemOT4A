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
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author eng osama anter
 */
public class Aboutus {

    private Scene scene;

    // function return scene
    public Scene return_scene() {

        // Check scene
        if (scene == null) {

            Group G_login = new Group();

            // Images declare
            ImageView logo, image;

            //image in About us scene
            image = new ImageView(new Image(getClass().getResourceAsStream("bm.png")));
            image.setLayoutX(790);
            image.setLayoutY(190);
            image.setFitHeight(370);
            image.setFitWidth(620);

            //image my logo ot4a 
            logo = new ImageView(new Image(getClass().getResourceAsStream("logo1_1.png")));
            logo.setLayoutX(1250);
            logo.setLayoutY(650);
            logo.setFitHeight(150);
            logo.setFitWidth(150);

            // button back to return home
            Button btn_back;
            btn_back = new Button(" Back", Constants.getBackImage());
            btn_back.setTextFill(Color.ANTIQUEWHITE);
            btn_back.setLayoutX(50);
            btn_back.setLayoutY(700);
            btn_back.setFont(new Font("Arail", 35));
            btn_back.setPrefSize(170, 85);
            btn_back.setBackground(new Background(
                    new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

            //btns effects
            btn_back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                btn_back.setEffect(Constants.getShadow());
            });
            btn_back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                btn_back.setEffect(null);
            });

            //btns actions 
            btn_back.setOnAction((ActionEvent event) -> {
                ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
                        .setScene(ApplicationRegistery.getApplicationRegistery().getLoginScene());
            });

            // Fonts
            Font font = new Font("Comic Sans MS", 40);

            // Texts
            Text title;
            title = new Text(70, 100, "*Team Work Name (G029) :- \n\t\t\t\t\t\t\t\t\t\t(OT4A)"
                    + "\n 1-Osama Anter Mohamed Afify. \n 2-Tarek Ashraf Mahmoud Hessin. \n "
                    + "3-Ahmed Mohamed Ibrahim Mohamed. \n 4-Ahmed Mohamed ALi Abdelrahman."
                    + " \n 5-Adham Mohamed Tawfik Mohamed. \n 6-Ahmed Yasser Mahmoud Seliem. "
                    + "\n\n *Under Supervision :- \n\t\t\tDr.Mohamed Mabrook   &   T.A Aya Ashraf .");
            title.setFont(font);
            title.setFill(Color.SNOW);

            // print items
            G_login.getChildren().addAll(btn_back, title, logo, image);

            //Scene 
            scene = new Scene(G_login, 1400, 800, Color.BLUEVIOLET);

        }
        return scene;
    }

}
