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
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
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
public class View {
	private Scene scene;
	private Group G_search = new Group();

	public Scene return_scene() {

		if (scene == null) {

			// shadow effects buttons
			DropShadow shadow = new DropShadow();
			TableView<Car> table = Table.createTable();
			table.setLayoutX(260);
			table.setLayoutY(130);

			// Buttons
			ImageView buy = new ImageView(new Image(getClass().getResourceAsStream("buy.png")));
			buy.setFitHeight(30);
			buy.setFitWidth(30);
			Button btnbuy = new Button("Buy This Car", buy);
			btnbuy.setTextFill(Color.BISQUE);
			btnbuy.setLayoutX(1000);
			btnbuy.setLayoutY(650);
			btnbuy.setFont(new Font("Arail", 36));
			btnbuy.setPrefSize(280, 70);
			btnbuy.setBackground(new Background(
					new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

			btnbuy.setOnAction((ActionEvent event) -> {
				Table.sellOneCar(table);
			});

			btnbuy.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				btnbuy.setEffect(shadow);
			});
			btnbuy.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				btnbuy.setEffect(null);
			});

			
			Button btnback = new Button(" Back ", Constants.getBackImage());
			btnback.setTextFill(Color.BISQUE);
			btnback.setLayoutX(80);
			btnback.setLayoutY(650);
			btnback.setFont(new Font("Arail", 40));
			btnback.setPrefSize(280, 70);
			btnback.setBackground(new Background(
					new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			btnback.setOnAction((ActionEvent event) -> {
				System.out.println("back ");
				ApplicationRegistery.getApplicationRegistery().getPrimaryStage()
						.setScene(ApplicationRegistery.getApplicationRegistery().getUserScene());
			});

			btnback.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				btnback.setEffect(shadow);
			});
			btnback.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				btnback.setEffect(null);
			});

			ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("logo1_1.png")));
			logo.setLayoutX(1250);
			logo.setLayoutY(650);
			logo.setFitHeight(150);
			logo.setFitWidth(150);

			Text title = new Text(100, 100, "Avalibale Cars");
			title.setFont(Constants.getFont1());
			title.setFill(Color.ANTIQUEWHITE);

			G_search.getChildren().addAll(table, btnback, title, logo, btnbuy);

			scene = new Scene(G_search, 1400, 800, Color.BLUEVIOLET);
		}

		return scene;
	}
}
