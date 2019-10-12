package sample;

public class BetterComputerStrategy {

    public static void computerMove(Cell[][] cells) {
        //end to win
        for (int i = 0; i < 3; i++) {
            if (cells[i][0].getOwnerPlayer().equals(Owner.X) && cells[i][1].getOwnerPlayer().equals(Owner.X)
                    && cells[i][2].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[i][2].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[i][2]);
                return;
            }
            if (cells[i][0].getOwnerPlayer().equals(Owner.X) && cells[i][2].getOwnerPlayer().equals(Owner.X)
                    && cells[i][1].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[i][1].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[i][1]);
                return;
            }
            if (cells[i][2].getOwnerPlayer().equals(Owner.X) && cells[i][1].getOwnerPlayer().equals(Owner.X)
                    && cells[i][0].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[i][0].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[i][0]);
                return;
            }
            if (cells[0][i].getOwnerPlayer().equals(Owner.X) && cells[1][i].getOwnerPlayer().equals(Owner.X)
                    && cells[2][i].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[2][i].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[2][i]);
                return;
            }
            if (cells[0][i].getOwnerPlayer().equals(Owner.X) && cells[2][i].getOwnerPlayer().equals(Owner.X)
                    && cells[1][i].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[1][i].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[1][i]);
                return;
            }
            if (cells[2][i].getOwnerPlayer().equals(Owner.X) && cells[1][i].getOwnerPlayer().equals(Owner.X)
                    && cells[0][i].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[0][i].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[0][i]);
                return;
            }
        }
        if (cells[0][0].getOwnerPlayer().equals(Owner.X) && cells[1][1].getOwnerPlayer().equals(Owner.X)
                && cells[2][2].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[2][2].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[2][2]);
            return;
        }
        if (cells[0][0].getOwnerPlayer().equals(Owner.X) && cells[2][2].getOwnerPlayer().equals(Owner.X)
                && cells[1][1].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[1][1].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[1][1]);
            return;
        }
        if (cells[2][2].getOwnerPlayer().equals(Owner.X) && cells[1][1].getOwnerPlayer().equals(Owner.X)
                && cells[0][0].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[0][0].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[0][0]);
            return;
        }
        if (cells[0][2].getOwnerPlayer().equals(Owner.X) && cells[1][1].getOwnerPlayer().equals(Owner.X)
                && cells[2][0].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[2][0].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[2][0]);
            return;
        }
        if (cells[0][2].getOwnerPlayer().equals(Owner.X) && cells[2][0].getOwnerPlayer().equals(Owner.X)
                && cells[1][1].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[1][1].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[1][1]);
            return;
        }
        if (cells[2][0].getOwnerPlayer().equals(Owner.X) && cells[1][1].getOwnerPlayer().equals(Owner.X)
                && cells[0][2].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[0][2].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[0][2]);
            return;
        }

//block user
        for (int i = 0; i < 3; i++) {
            if (cells[i][0].getOwnerPlayer().equals(Owner.O) && cells[i][1].getOwnerPlayer().equals(Owner.O)
                    && cells[i][2].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[i][2].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[i][2]);
                return;
            }
            if (cells[i][0].getOwnerPlayer().equals(Owner.O) && cells[i][2].getOwnerPlayer().equals(Owner.O)
                    && cells[i][1].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[i][1].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[i][1]);
                return;
            }
            if (cells[i][2].getOwnerPlayer().equals(Owner.O) && cells[i][1].getOwnerPlayer().equals(Owner.O)
                    && cells[i][0].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[i][0].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[i][0]);
                return;
            }
            if (cells[0][i].getOwnerPlayer().equals(Owner.O) && cells[1][i].getOwnerPlayer().equals(Owner.O)
                    && cells[2][i].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[2][i].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[2][i]);
                return;
            }
            if (cells[0][i].getOwnerPlayer().equals(Owner.O) && cells[2][i].getOwnerPlayer().equals(Owner.O)
                    && cells[1][i].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[1][i].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[1][i]);
                return;
            }
            if (cells[2][i].getOwnerPlayer().equals(Owner.O) && cells[1][i].getOwnerPlayer().equals(Owner.O)
                    && cells[0][i].getOwnerPlayer().equals(Owner.EMPTY)) {
                cells[0][i].setOwnerPlayer(Owner.X);
                Move.drawMoveX(cells[0][i]);
                return;
            }
        }
        if (cells[0][0].getOwnerPlayer().equals(Owner.O) && cells[1][1].getOwnerPlayer().equals(Owner.O)
                && cells[2][2].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[2][2].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[2][2]);
            return;
        }
        if (cells[0][0].getOwnerPlayer().equals(Owner.O) && cells[2][2].getOwnerPlayer().equals(Owner.O)
                && cells[1][1].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[1][1].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[1][1]);
            return;
        }
        if (cells[2][2].getOwnerPlayer().equals(Owner.O) && cells[1][1].getOwnerPlayer().equals(Owner.O)
                && cells[0][0].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[0][0].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[0][0]);
            return;
        }
        if (cells[0][2].getOwnerPlayer().equals(Owner.O) && cells[1][1].getOwnerPlayer().equals(Owner.O)
                && cells[2][0].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[2][0].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[2][0]);
            return;
        }
        if (cells[0][2].getOwnerPlayer().equals(Owner.O) && cells[2][0].getOwnerPlayer().equals(Owner.O)
                && cells[1][1].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[1][1].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[1][1]);
            return;
        }
        if (cells[2][0].getOwnerPlayer().equals(Owner.O) && cells[1][1].getOwnerPlayer().equals(Owner.O)
                && cells[0][2].getOwnerPlayer().equals(Owner.EMPTY)) {
            cells[0][2].setOwnerPlayer(Owner.X);
            Move.drawMoveX(cells[0][2]);
            return;
        }

        ComputerStrategy.computerMove(cells, BoardSize.MAX_ROWS, BoardSize.MAX_COLS);
    }
}
