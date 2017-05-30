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
