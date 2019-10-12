package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Game {
    private UserInterface userInterface;
    private static final String TITLE = "Kółko i krzyżyk";
    private GameDefinition gameDefinition;

    public Game(UserInterface userInterface, GameDefinition gameDefinition) {
        this.userInterface = userInterface;
        this.gameDefinition = gameDefinition;
    }

    public Scene play() {
        BorderPane root = userInterface.borderWithMenu();

        root.setCenter(userInterface.getBoard());
        Scene scene = new Scene(root, 300, 350, Color.WHITE);
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!gameDefinition.getGameOver() && gameDefinition.getActualRound() != 0
                        && gameDefinition.getActualRound() <= gameDefinition.getMaxRound()) {
                    if (mouseEvent.getTarget() instanceof Cell) {
                        Cell cell = (Cell) mouseEvent.getTarget();
                        gameDefinition.setGameOver(userInterface.move(cell));
                    }
                } else {
                    userInterface.getBoard().clear();
                    if (gameDefinition.getActualRound() <= gameDefinition.getMaxRound() && gameDefinition.getActualRound() != 0) {
                        if (gameDefinition.getActualRound() <= gameDefinition.getMaxRound()) {
                            gameDefinition.setActualRound(gameDefinition.getActualRound() + 1);
                        }
                        userInterface.getLblState().setText("");
                        if (!gameDefinition.isPlayerFirst() && gameDefinition.getActualRound() <= gameDefinition.getMaxRound()) {
                            if (gameDefinition.getDifficultyLevel().equals(DifficultyLevel.HARDER)) {
                                BetterComputerStrategy.computerMove(userInterface.getBoard().getCells());
                            } else {
                                ComputerStrategy.computerMove(userInterface.getBoard().getCells(), BoardSize.MAX_ROWS, BoardSize.MAX_COLS);
                            }
                            gameDefinition.setPlayerFirst(true);
                        } else {
                            gameDefinition.setPlayerFirst(false);
                        }
                    } else {
                        userInterface.getLblState().setText("Kliknij \"Gra\", aby rozpocząć...");
                    }
                    if (gameDefinition.getActualRound() > gameDefinition.getMaxRound()) {
                        userInterface.getLblMaxRounds().setText("Runda: " + (gameDefinition.getActualRound() - 1) + "/" + gameDefinition.getMaxRound());
                    } else {
                        userInterface.getLblMaxRounds().setText("Runda: " + gameDefinition.getActualRound() + "/" + gameDefinition.getMaxRound());
                    }
                    gameDefinition.setGameOver(false);
                }
            }
        });
        return scene;
    }

    public String getTitle() {
        return TITLE;
    }
}
