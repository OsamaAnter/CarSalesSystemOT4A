package maincarsales;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class Constants {

	private static Font font1 = new Font("century gothic", 70);
	private static ImageView backImage;
	private static DropShadow shadow = new DropShadow();
	static {
                backImage = new ImageView(new Image(Constants.class.getResourceAsStream("back.png")));
		backImage.setFitHeight(30);
		backImage.setFitWidth(30);
	}

	public static Font getFont1() {
		return font1;
	}

	public static ImageView getBackImage() {
		return backImage;
	}

	public static DropShadow getShadow() {
		return shadow;
	}
}
