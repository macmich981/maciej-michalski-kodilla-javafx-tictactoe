package sample;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.TimeUnit;

public class UserInterface {
    private Stage primaryStage;
    private Board board;
    private final int maxRows = BoardSize.MAX_ROWS;
    private final int maxCols = BoardSize.MAX_COLS;
    private Label lblState;
    private GameDefinition gameDefinition;
    private Label lblResultX;
    private Label lblResultO;
    private Label lblMaxRounds;


    public UserInterface(Stage primaryStage, GameDefinition gameDefinition) {
        this.primaryStage = primaryStage;
        this.board = new Board(maxRows, maxCols);
        this.lblState = new Label();
        this.lblMaxRounds = new Label();
        this.lblResultO = new Label();
        this.lblResultX = new Label();
        this.gameDefinition = gameDefinition;
    }

    public Board getBoard() {
        return board;
    }

    public boolean move(Cell cell) {
        if (cell.getOwnerPlayer().equals(Owner.EMPTY)) {
            Move.drawMoveO(cell);
            cell.setOwnerPlayer(Owner.O);
            boolean gameResult = new GameResolver(getBoard().getCells(), this).findSameAs();
            if (!gameResult) {
                ComputerStrategy.computerMove(board.getCells(), maxRows, maxCols);
                gameResult = new GameResolver(getBoard().getCells(), this).findSameAs();
            }
            return gameResult;
        }
        return false;
    }

    public BorderPane borderWithMenu() {
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Gra");
        BorderPane root = new BorderPane();
        VBox menus = new VBox();
        HBox results = new HBox();
        MenuItem newGame = new MenuItem("Nowa gra");

        newGame.setOnAction(event -> {
            Cell[][] cells = getBoard().getCells();
            for (int row = 0; row < BoardSize.MAX_ROWS; row++) {
                for (int col = 0; col < BoardSize.MAX_COLS; col++) {
                    cells[row][col].setOwnerPlayer(Owner.EMPTY);
                    cells[row][col].getChildren().clear();
                }
            }
            gameOptions();
            gameDefinition.setPointsX(0);
            gameDefinition.setPointsO(0);
            lblResultX.setText("Punkty X: " + gameDefinition.getPointsX());
            lblResultO.setText("Punkty O: " + gameDefinition.getPointsO());
            gameDefinition.setGameOver(false);
        });

        lblMaxRounds.setText("Runda: " + (gameDefinition.getActualRound()) + "/" + gameDefinition.getMaxRound());
        lblState.setText("Kliknij \"Gra\", aby rozpocząć... ");
        menu.getItems().add(newGame);
        menuBar.getMenus().add(menu);
        menus.getChildren().addAll(menuBar, results);
        results.setSpacing(10);
        results.getChildren().addAll(lblResultX, lblResultO, lblMaxRounds);
        root.setStyle("-fx-background-color: #cdc06c");
        root.setTop(menus);
        root.setBottom(lblState);

        return root;
    }

    private void gameOptions() {
        AnchorPane secondaryLayout = new AnchorPane();
        Spinner<Integer> spinner = new Spinner<>();

        final int initialValue = 5;
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50, initialValue);
        spinner.setValueFactory(valueFactory);
        spinner.valueProperty().addListener(new ChangeListener<Integer>() {

            @Override
            public void changed(ObservableValue<? extends Integer> observable,//
                                Integer oldValue, Integer newValue) {
            }
        });
        Button btnOk = new Button("Ok");
        Button btnCancel = new Button("Anuluj");

        secondaryLayout.getChildren().addAll(spinner, btnOk, btnCancel);
        AnchorPane.setTopAnchor(spinner, 40.0);
        AnchorPane.setLeftAnchor(spinner, 50.0);
        AnchorPane.setBottomAnchor(btnOk, 10.0);
        AnchorPane.setLeftAnchor(btnOk, 75.0);
        AnchorPane.setBottomAnchor(btnCancel, 10.0);
        AnchorPane.setLeftAnchor(btnCancel, 125.0);

        Scene secondScene = new Scene(secondaryLayout, 230, 100);
        Stage newWindow = new Stage();
        newWindow.setTitle("Ustaw liczbę rund");
        newWindow.setResizable(false);
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.setScene(secondScene);
        newWindow.show();

        btnOk.setOnAction(event -> {
            gameDefinition.setActualRound(1);
            gameDefinition.setMaxRound(spinner.getValue());
            lblMaxRounds.setText("Runda: " + gameDefinition.getActualRound() + "/" + spinner.getValue().toString());
            newWindow.close();
        });
        btnCancel.setOnAction(event -> {
            newWindow.close();
        });
    }

    public Label getLblState() {
        return lblState;
    }

    public Label getLblResultX() {
        return lblResultX;
    }

    public Label getLblResultO() {
        return lblResultO;
    }

    public GameDefinition getGameDefinition() {
        return gameDefinition;
    }

    public Label getLblMaxRounds() {
        return lblMaxRounds;
    }
}
