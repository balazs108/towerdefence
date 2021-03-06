//CHECKSTYLE:OFF
package hu.inf.unideb.prt.bazs.towerdefence.view.controller;

/*-
 * #%L
 * towerdefence
 * %%
 * Copyright (C) 2017 University of Debrecen
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * #L%
 */

import hu.inf.unideb.prt.bazs.towerdefence.model.entity.HighScoreEntity;
import hu.inf.unideb.prt.bazs.towerdefence.model.service.EntityManagerProvider;
import hu.inf.unideb.prt.bazs.towerdefence.model.service.HighScoreService;
import hu.inf.unideb.prt.bazs.towerdefence.view.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by Balazs on 2017-05-21.
 */
public class HighScoreController implements Initializable{

    @FXML
    Button backButton;
    @FXML
    TableView<HighScoreEntity> table;
    @FXML
    TableColumn<HighScoreEntity,String> player;
    @FXML
    TableColumn<HighScoreEntity,Integer> score;
    @FXML
    TableColumn<HighScoreEntity,LocalDateTime> date;

    private Logger logger = LoggerFactory.getLogger(HighScoreController.class);

    private ObservableList<HighScoreEntity> highScoreEntities;

    @FXML
    private void goMenu(){
        Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuFXML.fxml"));
            root = loader.load();
            loader.<MenuController> getController();
            stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("Something went wrong with the scene selection");
        }
        logger.info("Menu scene is selected");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            HighScoreService highscoreService = new HighScoreService(entityManager);
            highScoreEntities = FXCollections.observableArrayList(highscoreService.getAll());
            player.setCellValueFactory(new PropertyValueFactory<HighScoreEntity,String>("player"));
            score.setCellValueFactory(new PropertyValueFactory<HighScoreEntity,Integer>("score"));
            date.setCellValueFactory(new PropertyValueFactory<HighScoreEntity,LocalDateTime>("date"));
            table.setItems(highScoreEntities);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Something went wrong with the database");
        }
        logger.info("The highscore table has been initialized");
    }
}
