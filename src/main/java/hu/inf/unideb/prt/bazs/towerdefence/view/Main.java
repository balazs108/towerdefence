package hu.inf.unideb.prt.bazs.towerdefence.view;

import hu.inf.unideb.prt.bazs.towerdefence.model.service.EntityManagerProvider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Balazs on 2017-05-01.
 */
public class Main extends Application {
    public Logger logger = LoggerFactory.getLogger(Main.class);

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuFXML.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Aethernal_Td");
        stage.setScene(scene);
        stage.show();
        logger.info("Starting the program");
    }

    @Override
    public void stop() throws Exception {
            EntityManagerProvider.closeConnection();
            logger.info("Closing the program");
    }

    public static int score=0;

    public static void main(String[] args) {
        launch(args);
    }
}