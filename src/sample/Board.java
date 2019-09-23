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

    public Cell[][] getCells() {
        return cells;
    }
}