package maincarsales;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp {
	// confirmation boolean
	private static boolean isConfirm = false;

	static boolean confirmation() {

		Stage confirmStage = new Stage();
		confirmStage.setTitle("Confirm Message");
		confirmStage.initModality(Modality.APPLICATION_MODAL);

		Text message = new Text("Are you sure you want do this action?");
		message.setLayoutX(100);
		message.setLayoutY(50);

		Button yesButton = new Button("Yes");
		yesButton.setPrefSize(100, 30);
		yesButton.setLayoutX(50);
		yesButton.setLayoutY(100);
		yesButton.setOnAction(e -> {
			isConfirm = true;
			confirmStage.close();
		});

		Button noButton = new Button("No");
		noButton.setPrefSize(100, 30);
		noButton.setLayoutX(200);
		noButton.setLayoutY(100);
		noButton.setOnAction(e -> {
			isConfirm = false;
			confirmStage.close();
		});

		Group layout = new Group();
		layout.getChildren().addAll(message, yesButton, noButton);

		Scene confirmScene = new Scene(layout, 250, 250);

		// setup stage
		confirmStage.setScene(confirmScene);
		confirmStage.showAndWait();

		return isConfirm;
	}

	// overloading
	static boolean confirmation(String title, String msg) {

		Stage confirmStage = new Stage();
		confirmStage.setTitle(title);
		confirmStage.initModality(Modality.APPLICATION_MODAL);

		Text message = new Text(msg);
		message.setLayoutX(100);
		message.setLayoutY(50);

		Button yesButton = new Button("Yes");
		yesButton.setPrefSize(100, 30);
		yesButton.setLayoutX(50);
		yesButton.setLayoutY(100);
		yesButton.setOnAction(e -> {
			isConfirm = true;
			confirmStage.close();
		});

		Button noButton = new Button("No");
		noButton.setPrefSize(100, 30);
		noButton.setLayoutX(200);
		noButton.setLayoutY(100);
		noButton.setOnAction(e -> {
			isConfirm = false;
			confirmStage.close();
		});

		Group layout = new Group();
		layout.getChildren().addAll(message, yesButton, noButton);

		Scene confirmScene = new Scene(layout, 350, 150);

		// setup stage
		confirmStage.setScene(confirmScene);
		confirmStage.showAndWait();

		return isConfirm;
	}

	static void alert(String msg) {
		Stage confirmStage = new Stage();
		confirmStage.setTitle("Alert Message");
		confirmStage.initModality(Modality.APPLICATION_MODAL);

		Text message = new Text(msg);
		message.setLayoutX(100);
		message.setLayoutY(50);

		VBox layout = new VBox();
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(message);

		Scene confirmScene = new Scene(layout, 350, 200);

		// setup stage
		confirmStage.setScene(confirmScene);
		confirmStage.showAndWait();
	}
}
