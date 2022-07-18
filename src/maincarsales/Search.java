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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
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
public class Search {

    //declare variables and items
    private Scene scene;
    RadioButton name, model, cost;
    TextField enter_search;
    Boolean check_boolean;

    public Scene return_scene() {

        if (scene == null) {
            
            //declare items
            Group G_search = new Group();

            Font font2 = new Font("plain", 40);

            Text ch_search = new Text(80, 200, "Search by : ");
            ch_search.setFont(font2);
            ch_search.setFill(Color.BLANCHEDALMOND);

            //sellector radio buttons search
            name = new RadioButton(" Name");
            name.setLayoutX(100);
            name.setLayoutY(250);
            name.setScaleX(1.5);
            name.setScaleY(1.5);
            name.setSelected(true);
            name.setTextFill(Color.ANTIQUEWHITE);

            model = new RadioButton(" Model");
            model.setLayoutX(100);
            model.setLayoutY(320);
            model.setScaleX(1.5);
            model.setScaleY(1.5);
            model.setTextFill(Color.ANTIQUEWHITE);

            cost = new RadioButton(" Cost");
            cost.setLayoutX(100);
            cost.setLayoutY(390);
            cost.setScaleX(1.5);
            cost.setScaleY(1.5);
            cost.setTextFill(Color.ANTIQUEWHITE);

            ToggleGroup searchchoose = new ToggleGroup();
            searchchoose.getToggles().addAll(name, model, cost);

            Text ent_search = new Text(80, 500, "Enter Search : ");
            ent_search.setFont(font2);
            ent_search.setFill(Color.BLANCHEDALMOND);

            enter_search = new TextField();
            enter_search.setLayoutX(130);
            enter_search.setLayoutY(550);
            enter_search.setScaleX(1.5);
            enter_search.setScaleY(1.5);
            enter_search.setOnKeyReleased(event -> {
                search_item();
            });

            Line line = new Line(400, 150, 400, 650);
            line.setFill(Color.ANTIQUEWHITE);

            // Buttons
            ImageView buy = new ImageView(new Image(getClass().getResourceAsStream("buy.png")));
            buy.setFitHeight(30);
            buy.setFitWidth(30);
            Button btnBuy = new Button(" Buy", buy);
            btnBuy.setTextFill(Color.BISQUE);
            btnBuy.setLayoutX(1100);
            btnBuy.setLayoutY(650);
            btnBuy.setFont(new Font("Arail", 40));
            btnBuy.setPrefSize(280, 70);
            btnBuy.setBackground(new Background(
                    new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
            btnBuy.setOnAction((ActionEvent event) -> {
                Table.sellOneCar(table);
                search_item();
            });

            btnBuy.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                btnBuy.setEffect(Constants.getShadow());
            });
            btnBuy.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                btnBuy.setEffect(null);
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
                enter_search.clear();
                name.setSelected(false);
                model.setSelected(false);
                cost.setSelected(false);

            });

            btnback.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                btnback.setEffect(Constants.getShadow());
            });
            btnback.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                btnback.setEffect(null);
            });

            Text title = new Text(100, 100, "Search from a Car");
            title.setFont(Constants.getFont1());
            title.setFill(Color.ANTIQUEWHITE);

            table = Table.createTable(false);
            table.setLayoutX(450);
            table.setLayoutY(130);

            G_search.getChildren().addAll(table, line, btnback, btnBuy, title, name, model, cost, ch_search,
                    enter_search, ent_search);

            scene = new Scene(G_search, 1400, 800, Color.BLUEVIOLET);
        }

        return scene;
    }

    TableView<Car> table;

    //functions search 
    public void search_item() {
        if (name.isSelected() == false && model.isSelected() == false && cost.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "please select Your choose field");
        } else if ("".equals(enter_search.getText())) {
            table.getItems().clear();
            table.getItems().addAll(ApplicationList.applicationList.getCarList());
        } else {
            table.getItems().clear();

            for (Car car_i : ApplicationList.applicationList.getCarList()) {
                if ((name.isSelected() && car_i.getName().toLowerCase().contains(enter_search.getText().toLowerCase()))
                        || (model.isSelected()
                        && car_i.getModel().toLowerCase().contains(enter_search.getText().toLowerCase()))
                        || (cost.isSelected() && String.valueOf(car_i.getCost()).contains(enter_search.getText()))) {
                    table.getItems().add(car_i);
                }
            }

        }

    }

}
