package sample;

public class GameResolver {
    private Cell[][] cells;
    private UserInterface userInterface;

    public GameResolver(Cell[][] cells, UserInterface userInterface) {
        this.cells = cells;
        this.userInterface = userInterface;
    }

    public boolean findSameAs() {
        if (findInARow()) {
            return true;
        }
        if (findInACol()) {
            return true;
        }
        if (findDiagonallyFromLeftToRight()) {
            return true;
        }
        if (findDiagonallyFromRightToLeft()) {
            return true;
        }
        if (isBoardFull()) {
            return true;
        }
        return false;
    }

    private boolean findInARow() {
        int count;
        Cell temp;
        for (int row = 0; row < BoardSize.MAX_ROWS; row++) {
            temp = cells[row][0];
            count = 0;
            if (!temp.getOwnerPlayer().equals(Owner.EMPTY)) {
                for (int col = 0; col < BoardSize.MAX_COLS; col++) {
                    if (temp.getOwnerPlayer().equals(cells[row][col].getOwnerPlayer())) {
                        temp = cells[row][col];
                        count++;
                    }
                }
            }
            if (count == BoardSize.MAX_ROWS) {
                showWinner(cells[row]);
                return true;
            }
        }
        return false;
    }

    private boolean findInACol() {
        int count;
        Cell temp;
        for (int col = 0; col < BoardSize.MAX_COLS; col++) {
            count = 0;
            temp = cells[0][col];
            if (!temp.getOwnerPlayer().equals(Owner.EMPTY)) {
                for (int row = 0; row < BoardSize.MAX_ROWS; row++) {
                    if (temp.getOwnerPlayer().equals(cells[row][col].getOwnerPlayer())) {
                        temp = cells[row][col];
                        count++;
                    }
                }
            }
            if (count == BoardSize.MAX_COLS) {
                Cell[] tempCell = new Cell[BoardSize.MAX_COLS];
                for (int row = 0; row < BoardSize.MAX_ROWS; row++) {
                    tempCell[row] = cells[row][col];
                }
                showWinner(tempCell);
                return true;
            }
        }
        return false;
    }

    private boolean findDiagonallyFromLeftToRight() {
        int count = 0;
        Cell temp = cells[0][0];
        for (int row = 0, col = 0; row < BoardSize.MAX_ROWS && col < BoardSize.MAX_COLS; row++, col++) {
            if (!temp.getOwnerPlayer().equals(Owner.EMPTY)) {
                if (temp.getOwnerPlayer().equals(cells[row][col].getOwnerPlayer())) {
                    temp = cells[row][col];
                    count++;
                }
            }
            if (count == BoardSize.MAX_COLS) {
                Cell[] tempCell = new Cell[BoardSize.MAX_ROWS];
                for (row = 0, col = 0; row < BoardSize.MAX_ROWS && col < BoardSize.MAX_COLS; row++, col++) {
                    tempCell[row] = cells[row][col];
                }
                showWinner(tempCell);
                return true;
            }
        }
        return false;
    }

    private boolean findDiagonallyFromRightToLeft() {
        int count = 0;
        Cell temp = cells[0][2];
        for (int row = 0, col = BoardSize.MAX_COLS - 1; row < BoardSize.MAX_ROWS && col >= 0; row++, col--) {
            if (!temp.getOwnerPlayer().equals(Owner.EMPTY)) {
                if (temp.getOwnerPlayer().equals(cells[row][col].getOwnerPlayer())) {
                    temp = cells[row][col];
                    count++;
                }
            }
            if (count == BoardSize.MAX_ROWS) {
                Cell[] tempCell = new Cell[BoardSize.MAX_ROWS];
                for (row = 0, col = BoardSize.MAX_COLS - 1; row < BoardSize.MAX_ROWS && col >= 0; row++, col--) {
                    tempCell[row] = cells[row][col];
                }
                showWinner(tempCell);
                return true;
            }
        }
        return false;
    }

    private void showWinner(Cell[] cell) {
        for (int i = 0; i < BoardSize.MAX_ROWS; i++) {
            if (cell[0].getOwnerPlayer().equals(Owner.O)) {
                cell[i].setStyle("-fx-border-color: black; -fx-background-color: #15c6cd");
            } else {
                cell[i].setStyle("-fx-border-color: black; -fx-background-color: #cd6427");
            }
        }
        if (cell[0].getOwnerPlayer().equals(Owner.O)) {
            userInterface.getGameDefinition().addPointsO();
            userInterface.getLblResultO().setText("Punkty O: " + userInterface.getGameDefinition().getPointsO());
            userInterface.getLblState().setText("Wygrał O");
        } else {
            userInterface.getGameDefinition().addPointsX();
            userInterface.getLblResultX().setText("Punkty X: " + userInterface.getGameDefinition().getPointsX());
            userInterface.getLblState().setText("Wygrał X");
        }
    }

    private boolean isBoardFull() {
        for (int row = 0; row < BoardSize.MAX_ROWS; row++) {
            for (int col = 0; col < BoardSize.MAX_COLS; col++) {
                if (cells[row][col].getOwnerPlayer().equals(Owner.EMPTY)) {
                    return false;
                }
            }
        }
        userInterface.getLblState().setText("Remis");
        return true;
    }
}
