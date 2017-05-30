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

import hu.inf.unideb.prt.bazs.towerdefence.controller.Game;
import hu.inf.unideb.prt.bazs.towerdefence.model.TowerType;
import hu.inf.unideb.prt.bazs.towerdefence.view.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Balazs on 2017-05-01.
 */
public class GameController implements Initializable {

    @FXML
    Canvas canvasField;
    @FXML
    Label lifeLabel;
    @FXML
    Label goldLabel;
    @FXML
    Label waveLabel;
    @FXML
    Label selectedLabel;
    @FXML
    Label scoreLabel;
    @FXML
    Label costLabel;
    @FXML
    Label damageLabel;
    @FXML
    Label reloadLabel;
    @FXML
    Button normalTowerButton;
    @FXML
    Button fastTowerButton;
    @FXML
    Button chaosTowerButton;

    Image back;

    Timeline timeline;

    GraphicsContext gcField;
    Game game;

    int towerSelected = 1;

    private Logger logger = LoggerFactory.getLogger(GameController.class);

    @FXML
    private void normalTowerSelect() {
        selectedLabel.setText("Normal Tower");
        costLabel.setText(String.valueOf(TowerType.Normal.getCost()));
        damageLabel.setText(String.valueOf(TowerType.Normal.getDamage()));
        reloadLabel.setText(String.valueOf(TowerType.Normal.getReloadTime()));
        towerSelected = 1;
        logger.info("Normal TowerType has been selected");
    }

    @FXML
    private void fastTowerSelect() {
        selectedLabel.setText("Fast Tower");
        costLabel.setText(String.valueOf(TowerType.Fast.getCost()));
        damageLabel.setText(String.valueOf(TowerType.Fast.getDamage()));
        reloadLabel.setText(String.valueOf(TowerType.Fast.getReloadTime()));
        towerSelected = 2;
        logger.info("Fast TowerType has been selected");
    }

    @FXML
    private void chaosTowerSelect() {
        selectedLabel.setText("Chaos Tower");
        costLabel.setText(String.valueOf(TowerType.Chaos.getCost()));
        damageLabel.setText(String.valueOf(TowerType.Chaos.getDamage()));
        reloadLabel.setText(String.valueOf(TowerType.Chaos.getReloadTime()));
        towerSelected = 3;
        logger.info("Chaos TowerType has been selected");
    }

    @FXML
    private void handleMouseClick(MouseEvent e) {
        switch (towerSelected) {
            case 1:
                game.putTower(TowerType.Normal, (int) e.getX(), (int) e.getY() );
                break;
            case 2:
                game.putTower(TowerType.Fast, (int) e.getX(), (int) e.getY() );
                break;
            case 3:
                game.putTower(TowerType.Chaos, (int) e.getX(), (int) e.getY() );
                break;
        }
        logger.info("A tower has been placed");
    }

    private void clear() {
        gcField.setFill(Color.WHITE);
        gcField.fillRect(0, 0, 600, 400);
    }

    private void goGameOver() {
        Main.score=game.getScore();
        timeline.stop();

        Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PostGameFXML.fxml"));
            root = loader.load();
            loader.<PostGameController>getController();
            stage = (Stage) lifeLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Something went wrong with the scene selection");
        }
        logger.info("The game has ended, postgame scene has been selected");
    }


    private void renderLabels() {
        this.lifeLabel.setText(String.valueOf(game.getLife()));
        this.goldLabel.setText(String.valueOf(game.getGold()));
        this.waveLabel.setText(String.valueOf(game.getCurrentWave() + 1));
        this.scoreLabel.setText(String.valueOf(game.getScore()));
    }

    private void tick() {
        if (game.getLife() < 1 || game.getCurrentWave() == 15) {
            goGameOver();
        }
        game.tick();
    }

    private void renderShooting() {
        gcField.setStroke(Color.BLUEVIOLET);
        game.getTowers().forEach(t -> {
            if (t.isShooting()) {
                gcField.setLineWidth(1.5);
                gcField.strokeLine(t.getX(), t.getY(), t.getTarget().getX(), t.getTarget().getY());
            }
        });
    }
    private void renderMobs() {
        game.getMobs().forEach(m -> {
            switch (m.getMobType()) {
                case BOSS:
                    gcField.setFill(Color.BLACK);
                    gcField.fillOval(m.getX() - 5, m.getY() - 5, 10, 10);
                    break;
                case HEAVY:
                    gcField.setFill(Color.IVORY);
                    gcField.fillOval(m.getX() - 4, m.getY() - 4, 8, 8);
                    break;
                case MEDIUM:
                    gcField.setFill(Color.CYAN);
                    gcField.fillOval(m.getX() - 3, m.getY() - 3, 5, 5);
                    break;
                case LIGHT:
                    gcField.setFill(Color.DEEPPINK);
                    gcField.fillOval(m.getX() - 1, m.getY() - 1, 3, 3);
                    break;
            }
        });
    }

    private void renderTowers() {
        game.getTowers().forEach(t -> {
            switch (t.getTowerType()) {
                case Normal:
                    gcField.setFill(Color.GREY);
                    break;
                case Fast:
                    gcField.setFill(Color.RED);
                    break;
                case Chaos:
                    gcField.setFill(Color.DARKGREEN);
                    break;
            }
            gcField.fillRect(t.getX() - 13, t.getY() - 13, 26, 26);
        });
    }
    private void renderBG() {
        gcField.drawImage(back, 0, 0);
    }

    private void render() {
        clear();
        renderBG();
        renderMobs();
        renderTowers();
        renderLabels();
        renderShooting();
    }

    public void initialize(URL location, ResourceBundle resources) {
        game = new Game();
        back = new Image("IMG/field.png");
        costLabel.setText(String.valueOf(TowerType.Normal.getCost()));
        damageLabel.setText(String.valueOf(TowerType.Normal.getDamage()));
        reloadLabel.setText(String.valueOf(TowerType.Normal.getReloadTime()));
        gcField = canvasField.getGraphicsContext2D();
        timeline = new Timeline(new KeyFrame(Duration.millis(50), ae -> {
            tick();
            render();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        logger.info("The game has started");
    }
}
