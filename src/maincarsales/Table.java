package maincarsales;

import java.util.LinkedList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Table {

    private static List<TableView<Car>> tables = new LinkedList<>();
    private static Stage visa = new Stage();

    static int idcar;

    public Table() {

    }

    public static void return_scene() {

        Group G_visa = new Group();

        Font font2 = new Font("plain", 25);

        //texts alert credit buy
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

        //textfields buy credit card
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
                visa.close();
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
        //visa.initModality(Modality.APPLICATION_MODAL);
    }

    // creates a TableView UI component
    public static TableView<Car> createTable() {
        return createTable(true);
    }

    public static TableView<Car> createTable(boolean cache) {
        TableView<Car> table = new TableView<>();
        table.setEditable(true);
        table.setPrefSize(900, 500);
        table.setLayoutX(450);
        table.setLayoutY(70);

        TableColumn<Car, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setMinWidth(150);

        TableColumn<Car, String> modelColumn = new TableColumn<>("Model");
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        modelColumn.setMinWidth(150);

        TableColumn<Car, String> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        yearColumn.setMinWidth(150);

        TableColumn<Car, String> colorColumn = new TableColumn<>("Colors");
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        colorColumn.setMinWidth(150);

        TableColumn<Car, String> counterColumn = new TableColumn<>("Amount");
        counterColumn.setCellValueFactory(new PropertyValueFactory<>("counter"));
        counterColumn.setMinWidth(150);

        TableColumn<Car, String> costColumn = new TableColumn<>("Cost   L.E");
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        costColumn.setMinWidth(150);

        // setup table
        table.getColumns().addAll(nameColumn, modelColumn, yearColumn, colorColumn, counterColumn, costColumn);
        refreshCarsData(table);
        if (cache) {
            tables.add(table);
        }
        return table;
    }

    public static void refresh() {
        refreshCarsData();
    }

    private static void refreshCarsData() {
        tables.forEach(table -> {
            refreshCarsData(table);
        });
    }

    private static void refreshCarsData(TableView<Car> table) {
        table.getItems().clear();
        table.getItems().addAll(ApplicationList.applicationList.getCarList());
    }

    static void addToTable() {

        try {

            if ((Integer.parseInt(Admin.yearField.getText()) < 1990)
                    || (Integer.parseInt(Admin.yearField.getText()) > 2021)
                   || Integer.parseInt(Admin.counterField.getText()) <= 0 || Integer.parseInt(Admin.costField.getText()) <= 0) {
                PopUp.alert("Error, please check your entries");
            } else {
                Car car = new Car(Admin.nameField.getText(), Admin.modelField.getText(),
                        Integer.parseInt(Admin.yearField.getText()), Admin.colorField.getText(),
                        Integer.parseInt(Admin.counterField.getText()), Double.parseDouble(Admin.costField.getText()), (Database.id));

                // add to list
                ApplicationList.applicationList.addCar(car);
                // ApplicationList.applicationList.getCarList().add(new Car(car));

                Database.insertCar();

                refreshCarsData();
            }
            Admin.nameField.clear();
            Admin.modelField.clear();
            Admin.yearField.clear();
            Admin.counterField.clear();
            Admin.costField.clear();
            Admin.colorField.clear();

            ApplicationList.applicationList.print();
        } catch (Exception e) {
            PopUp.alert(e.getMessage());
        }
    }

    // delete car from table and list
    static void deleteFromTable(TableView<Car> table) {

        // delete from list
        Car car = table.getSelectionModel().getSelectedItem();
        if (car == null) {
            JOptionPane.showMessageDialog(null, "Please, Select car.");
        } else if (JOptionPane.showConfirmDialog(null,
                "Do you want delet this car?") == JOptionPane.OK_OPTION) {
            idcar = car.getId();
            //System.out.println(ApplicationList.applicationList.getCarList().indexOf(car));
            try {
                Database.deletCar(idcar);
                System.out.println(ApplicationList.applicationList.getCarList().remove(car));

                refreshCarsData();

                ApplicationList.applicationList.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }

    static void sellOneCar(TableView<Car> table) {
        Car selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            JOptionPane.showMessageDialog(null, "Please, Select car.");
        } else if (selectedItem.getCounter() <= 0) {
            JOptionPane.showMessageDialog(null, "Sorry, No car avaliable.");
        } else if (JOptionPane.showConfirmDialog(null,
                "Please, Confirm that you need to sell one car.") == JOptionPane.OK_OPTION) {
            Visa.enterVisa(table);
        }
    }
}
