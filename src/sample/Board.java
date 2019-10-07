package sample;

import javafx.scene.layout.GridPane;

public class Board extends GridPane {
    private final Cell[][] cells;

    public Board(final int maxRows, final int maxCols) {
        super();
        this.cells = new Cell[maxRows][maxCols];

        for (int row = 0; row < maxRows; row++) {
            for (int col = 0; col < maxCols; col++) {
                this.cells[row][col] = new Cell(100, 100);
            }
        }
        for (int row = 0; row < maxRows; row++) {
            for (int col = 0; col < maxCols; col++) {
                this.addColumn(col, cells[row][col]);
            }
        }
    }

    public void clear() {
        for (int row = 0; row < BoardSize.MAX_ROWS; row++) {
            for (int col = 0; col < BoardSize.MAX_COLS; col++) {
                cells[row][col].setOwnerPlayer(Owner.EMPTY);
                cells[row][col].getChildren().clear();
                cells[row][col].setStyle("-fx-border-color: black; -fx-background-color: #40cd34");
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}