package hu.inf.unideb.prt.bazs.towerdefence.view.controller;

import hu.inf.unideb.prt.bazs.towerdefence.model.entity.HighScoreEntity;
import hu.inf.unideb.prt.bazs.towerdefence.model.service.EntityManagerProvider;
import hu.inf.unideb.prt.bazs.towerdefence.model.service.HighScoreService;
import hu.inf.unideb.prt.bazs.towerdefence.view.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

/**
 * Created by Balazs on 2017-05-21.
 */

public class PostGameController implements Initializable{

    @FXML
    Button nextButton;
    @FXML
    Label scoreLabel;
    @FXML
    TextField textBox;

    private Logger logger = LoggerFactory.getLogger(PostGameController.class);

    @FXML
    private void goHighScore() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            HighScoreService highscoreService = new HighScoreService(entityManager);
            entityManager.getTransaction().begin();
            highscoreService.add(new HighScoreEntity(textBox.getText(), Main.score, LocalDateTime.now()));
            entityManager.getTransaction().commit();
            logger.info("The database has been updated, an element was inserted into the highscore table.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Something went wrong with the database.");
        }


        Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HighScoreFXML.fxml"));
            root = loader.load();
            loader.<PostGameController> getController();
            stage = (Stage) nextButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("Something went wrong with the scene selection");
        }
        logger.info("Highscore scene has been selected");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scoreLabel.setText(String.valueOf(Main.score));
    }
}
