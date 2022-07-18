/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincarsales;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author eng osama anter
 */

public class Main extends Application {

    private Signup signup_o = new Signup();
    private login login_o = new login();
    private Usermenu menuuser_o = new Usermenu();
    private Search search_o = new Search();
    private View view_o = new View();
    private Setting setting_o = new Setting();
    private Aboutus aboutus_o = new Aboutus();

    public Main() throws FileNotFoundException {
        ApplicationRegistery.getApplicationRegistery().setLoginScene(login_o.return_scene());
        ApplicationRegistery.getApplicationRegistery().setSignupScene(signup_o.return_scene());
        ApplicationRegistery.getApplicationRegistery().setUserScene(menuuser_o.return_scene());
        ApplicationRegistery.getApplicationRegistery().setSearchScene(search_o.return_scene());
        ApplicationRegistery.getApplicationRegistery().setViewScene(view_o.return_scene());
        ApplicationRegistery.getApplicationRegistery().setSettingScene(setting_o.return_scene());
        ApplicationRegistery.getApplicationRegistery().setAboutus(aboutus_o.return_scene());
        ApplicationRegistery.getApplicationRegistery().setAdminScene(Admin.returnScene());
        try {
            Database.insertCarInList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println("before555555");
            Database.insertUserInList();
             Table.refresh();
            System.out.println("after5555555");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Car Sales System OT4A");
        primaryStage.setScene(login_o.return_scene());
        ApplicationRegistery.getApplicationRegistery().setPrimaryStage(primaryStage);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/maincarsales/v1.png")));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
