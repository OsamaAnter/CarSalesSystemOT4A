/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincarsales;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author eng osama anter
 */
public class ApplicationRegistery {

    private static final ApplicationRegistery APPLICATION_REGISTERY = new ApplicationRegistery();
    private Stage primaryStage;
    private Scene loginScene;
    private Scene signupScene;
    private Scene userScene;
    private Scene SearchScene;
    private Scene ViewScene;
    private Scene SettingScene;
    private Scene adminScene;
    private Scene aboutus;

    private ApplicationRegistery() {
    }

    public Scene getUserScene() {
        return userScene;
    }

    public Scene getSignupScene() {
        return signupScene;
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Scene getAdminScene() {
        return adminScene;
    }

    public Scene getSearchScene() {
        return SearchScene;
    }

    public Scene getViewScene() {
        return ViewScene;
    }

    public Scene getSettingScene() {
        return SettingScene;
    }

    public Scene getAboutus() {
        return aboutus;
    }

    public void setSignupScene(Scene signupScene) {
        this.signupScene = signupScene;
    }

    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setUserScene(Scene userScene) {
        this.userScene = userScene;
    }

    public void setAdminScene(Scene adminScene) {
        this.adminScene = adminScene;
    }

    public void setSearchScene(Scene SearchScene) {
        this.SearchScene = SearchScene;
    }

    public void setViewScene(Scene ViewScene) {
        this.ViewScene = ViewScene;
    }

    public void setSettingScene(Scene SettingScene) {
        this.SettingScene = SettingScene;
    }

    public void setAboutus(Scene aboutus) {
        this.aboutus = aboutus;
    }

    public static ApplicationRegistery getApplicationRegistery() {
        return APPLICATION_REGISTERY;
    }

}
