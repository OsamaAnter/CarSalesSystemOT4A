package maincarsales;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.*;
import javafx.scene.control.TableView;
import javax.swing.text.TabableView;

public class Visa {

    static int idcar;

    public static void enterVisa(TableView<Car> table) {

        Stage visa = new Stage();

        Group G_visa = new Group();

        Font font2 = new Font("plain", 25);

        //texts
        Text visaNumber = new Text("Credit Card Number :");
        visaNumber.setFont(font2);
        visaNumber.setFill(Color.AZURE);
        visaNumber.setLayoutX(20);
        visaNumber.setLayoutY(50);

        Text visapassword = new Text("Credit Card Password :");
        visapassword.setFont(font2);
        visapassword.setFill(Color.AZURE);
        visapassword.setLayoutX(20);
        visapassword.setLayoutY(200);

        //textfields
        TextField creditnumber, password;
        creditnumber = new TextField();
        creditnumber.setPromptText("Enter Creditcard number ");
        creditnumber.setLayoutX(20);
        creditnumber.setLayoutY(90);
        creditnumber.setScaleX(1);
        creditnumber.setScaleY(1);

        password = new PasswordField();
        password.setLayoutX(20);
        password.setLayoutY(230);
        password.setScaleX(1);
        password.setScaleY(1);
        password.setPromptText("Enter Password");

        //buttons
        Button ok = new Button("Ok");
        ok.setTextFill(Color.BISQUE);
        ok.setLayoutX(275);
        ok.setLayoutY(330);
        ok.setPrefSize(150, 35);
        ok.setStyle("-fx-font: 25 arial; -fx-base:#6495ED;");
        ok.setOnAction((ActionEvent event) -> {
            if ("".equals(creditnumber.getText()) || "".equals(password.getText())) {
                JOptionPane.showMessageDialog(null, "Pleas Enter Your Data");
            } else {
                JOptionPane.showMessageDialog(null, "Congratulation ");
                try {
                    Car car = table.getSelectionModel().getSelectedItem();
                    idcar = car.getId();
                    Database.buyCar(idcar, (car.getCounter() - 1));
                    car.setCounter(car.getCounter() - 1);
                    Table.refresh();// refreshCarsData();
                    ApplicationList.applicationList.print();
                    visa.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }

        });

        //background
        ImageView image = new ImageView(new Image(Table.class.getResourceAsStream("/maincarsales/credit.jpg")));
        image.setFitHeight(400);
        image.setFitWidth(700);

        G_visa.getChildren().addAll(image, visaNumber, visapassword, creditnumber, password, ok);
        Scene scene = new Scene(G_visa, 700, 400);

        visa.setTitle("Pay By Credit Card ");
        visa.setScene(scene);
        visa.initModality(Modality.APPLICATION_MODAL);
        visa.showAndWait();

    }
}
