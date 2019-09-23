package sample;

import org.junit.*;

public class BoardTest {
    @Test
    public void testEmptyBoard() {
        //Given
        Board board = new Board(BoardSize.MAX_ROWS, BoardSize.MAX_COLS);
        //When
        Cell[][] cells = board.getCells();
        Owner result = cells[2][2].getOwnerPlayer();
        //Then
        Assert.assertEquals(Owner.EMPTY, result);
    }
}
