package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerStrategy {
    private static final Random RANDOM = new Random();

    public static void computerMove(final Cell[][] cells, final int maxRows, final int maxCols) {
        List<Cell> remainedCells = new ArrayList<>();
        for (int row = 0; row < maxRows; row++) {
            for (int col = 0; col < maxCols; col++) {
                if (cells[row][col].getOwnerPlayer().equals(Owner.EMPTY)) {
                    remainedCells.add(cells[row][col]);
                }
            }
        }

        if (remainedCells.size() > 0) {
            int r = RANDOM.nextInt((remainedCells.size()));
            Cell drawnCell = remainedCells.get(r);
            Move.drawMoveX(drawnCell);
            drawnCell.setOwnerPlayer(Owner.X);
            remainedCells.clear();
        }
    }
}
