package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameDefinition gameDefinition = new GameDefinition();
        UserInterface userInterface = new UserInterface(gameDefinition);
        Game game = new Game(userInterface, gameDefinition);

        primaryStage.setTitle(game.getTitle());
        primaryStage.setScene(game.play());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
