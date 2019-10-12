package sample;

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

import javax.jws.soap.SOAPBinding;

public class UserInterface {
    private Board board;
    private Label lblState;
    private GameDefinition gameDefinition;
    private Label lblResultX;
    private Label lblResultO;
    private Label lblMaxRounds;


    public UserInterface(GameDefinition gameDefinition) {
        this.board = new Board(BoardSize.MAX_ROWS, BoardSize.MAX_COLS);
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
            cell.setOwnerPlayer(Owner.O);
            Move.drawMoveO(cell);
            boolean gameResult = new GameResolver(board.getCells(), this).findSameAs();
            if (!gameResult) {
                /*Task<Void> sleeper = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        try {
                            board.setDisable(true);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        return null;
                    }
                };

                sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        if (gameDefinition.getDifficultyLevel().equals(DifficultyLevel.HARDER)) {
                            BetterComputerStrategy.computerMove(board.getCells());
                        } else {
                            ComputerStrategy.computerMove(board.getCells(), BoardSize.MAX_ROWS, BoardSize.MAX_COLS);
                        }
                        board.setDisable(false);
                    }
                });
                new Thread(sleeper).start();*/
                if (gameDefinition.getDifficultyLevel().equals(DifficultyLevel.HARDER)) {
                    BetterComputerStrategy.computerMove(board.getCells());
                } else {
                    ComputerStrategy.computerMove(board.getCells(), BoardSize.MAX_ROWS, BoardSize.MAX_COLS);
                }
                gameResult = new GameResolver(board.getCells(), this).findSameAs();
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

        ComboBox<String> comboDifficultyLevel = new ComboBox();
        comboDifficultyLevel.getItems().addAll("Łatwy", "Trudniejszy");
        comboDifficultyLevel.getSelectionModel().select(0);

        Button btnOk = new Button("Ok");
        Button btnCancel = new Button("Anuluj");

        secondaryLayout.getChildren().addAll(comboDifficultyLevel, spinner, btnOk, btnCancel);
        AnchorPane.setTopAnchor(spinner, 40.0);
        AnchorPane.setLeftAnchor(spinner, 140.0);
        AnchorPane.setTopAnchor(comboDifficultyLevel, 40.0);
        AnchorPane.setLeftAnchor(comboDifficultyLevel, 25.0);
        AnchorPane.setBottomAnchor(btnOk, 10.0);
        AnchorPane.setLeftAnchor(btnOk, 100.0);
        AnchorPane.setBottomAnchor(btnCancel, 10.0);
        AnchorPane.setLeftAnchor(btnCancel, 150.0);

        Scene secondScene = new Scene(secondaryLayout, 300, 100);
        Stage newWindow = new Stage();
        newWindow.setTitle("Ustaw poziom trudności i liczbę rund");
        newWindow.setResizable(false);
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.setScene(secondScene);
        newWindow.show();

        btnOk.setOnAction(event -> {
            board.clear();
            gameDefinition.setActualRound(1);
            if (comboDifficultyLevel.getValue().equals("Łatwy")) {
                gameDefinition.setDifficultyLevel(DifficultyLevel.EASY);
                System.out.println(gameDefinition.getDifficultyLevel());
            } else {
                gameDefinition.setDifficultyLevel(DifficultyLevel.HARDER);
                System.out.println(gameDefinition.getDifficultyLevel());
            }
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
