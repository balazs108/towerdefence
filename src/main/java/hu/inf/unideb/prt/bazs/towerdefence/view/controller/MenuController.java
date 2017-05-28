package hu.inf.unideb.prt.bazs.towerdefence.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * Created by Balazs on 2017-05-21.
 */
public class MenuController {
    @FXML
    Button playButton;

    @FXML
    Button highScoreButton;


    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @FXML
    private void goGame(){
        Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameFXML.fxml"));
            root = loader.load();
            loader.<GameController> getController();
            stage = (Stage) playButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("Something went wrong with the scene selection.");
        }
        logger.info("Game scene has been selected.");
    }
    @FXML
    private void goHighScore(){
        Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HighScoreFXML.fxml"));
            root = loader.load();
            loader.<HighScoreController> getController();
            stage = (Stage) highScoreButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("Something went wrong with the scene selection");
        }
        logger.info("Highscore scene has been selected");
    }

    @FXML
    private void exitGame() {
        logger.info("The program is closed.");
        System.exit(0);
    }
}
