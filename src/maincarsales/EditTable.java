package maincarsales;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.*;

public class EditTable {

    public static TextField editField;
    private static Button editButton;
    public static ComboBox comboBox;
    private static Stage stage;
    static int idCar1;

    private static void editTable(Car car) {

        if (comboBox.getSelectionModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Choose the cell you want to edit first.");
        } else {
            boolean varbool = false;
            for (Car c : ApplicationList.applicationList.getCarList()) {
                if (c.equals(car)) {

                    System.out.println("before1111");
                    idCar1 = c.getId();
                    System.out.println("idCar = " + idCar1);
                    System.out.println("after1111");
                    try {
                        if (comboBox.getValue() == "name") {
                            c.setName(editField.getText());
                            varbool =true;
                        } else if (comboBox.getValue() == "model") {
                            c.setModel(editField.getText());
                            varbool =true ;
                        } else if (comboBox.getValue() == "year") {
                            if (Integer.parseInt(editField.getText()) < 1990 || Integer.parseInt(editField.getText()) > 2021) {
                                JOptionPane.showMessageDialog(null, "Invalid year");
                            } else {
                                c.setYear(Integer.parseInt(editField.getText()));
                                varbool = true;
                            }
                        } else if (comboBox.getValue() == "color") {
                            c.setColor(editField.getText());
                            varbool =true;
                        } else if (comboBox.getValue() == "counter") {
                            if (Integer.parseInt(editField.getText()) <= 0) {
                                JOptionPane.showMessageDialog(null, "Invalid number");
                            } else {
                                c.setCounter(Integer.parseInt(editField.getText()));
                                varbool =true ;
                            }
                        } else if (comboBox.getValue() == "cost") {
                            if (Integer.parseInt((editField.getText())) <= 0) {
                                JOptionPane.showMessageDialog(null, "Invalid number");
                            } else {
                                c.setCost(Integer.parseInt(editField.getText()));
                                varbool =true ;
                            }
                        }
                        if (varbool) {
                            Database.updateCar(idCar1);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                }
            }
            stage.close();
        }
    }

    public static void showEditedTable(TableView<Car> carTableView) {
        if (carTableView.getSelectionModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select cell you want to edit.");
        } else {
            stage = new Stage();
            stage.setTitle("Edit Cell");
            stage.initModality(Modality.APPLICATION_MODAL);

            editField = new TextField();
            editField.setPrefSize(40, 40);
            editField.setScaleX(0.6);
            editField.setPromptText("Enter Editing");

            comboBox = new ComboBox();
            comboBox.setPromptText("Choose the cell you want to edit.");
            comboBox.getItems().addAll("name", "model", "year", "color", "counter", "cost");

            editButton = new Button("Edit Cell");
            editButton.setPrefSize(100, 40);
            editButton.setOnAction(e -> {
                editTable(carTableView.getSelectionModel().getSelectedItem());
            });

            VBox vBox = new VBox(10);
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(comboBox, editField, editButton);
            vBox.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

            Scene scene = new Scene(vBox, 450, 200, Color.BLUEVIOLET);

            stage.setScene(scene);
            stage.showAndWait();
        }
    }
}
