package sample;

import org.junit.*;

public class BoardTestSuites {

    @Test
    public void emptyBoardTest() {
        //Given
        Board board = new Board(BoardSize.MAX_ROWS, BoardSize.MAX_COLS);
        //When
        Cell[][] cells = board.getCells();
        Owner result = cells[0][0].getOwnerPlayer();
        Owner result1 = cells[0][1].getOwnerPlayer();
        Owner result2 = cells[0][2].getOwnerPlayer();
        Owner result3 = cells[1][0].getOwnerPlayer();
        Owner result4 = cells[1][1].getOwnerPlayer();
        Owner result5 = cells[1][2].getOwnerPlayer();
        Owner result6 = cells[2][0].getOwnerPlayer();
        Owner result7 = cells[2][1].getOwnerPlayer();
        Owner result8 = cells[2][2].getOwnerPlayer();
        //Then
        Assert.assertEquals(Owner.EMPTY, result);
        Assert.assertEquals(Owner.EMPTY, result1);
        Assert.assertEquals(Owner.EMPTY, result2);
        Assert.assertEquals(Owner.EMPTY, result3);
        Assert.assertEquals(Owner.EMPTY, result4);
        Assert.assertEquals(Owner.EMPTY, result5);
        Assert.assertEquals(Owner.EMPTY, result6);
        Assert.assertEquals(Owner.EMPTY, result7);
        Assert.assertEquals(Owner.EMPTY, result8);
    }

    @Test
    public void setOwnerPlayerTest() {
        //Given
        Board board = new Board(BoardSize.MAX_ROWS, BoardSize.MAX_COLS);
        //When
        Cell[][] cells = board.getCells();
        cells[0][0].setOwnerPlayer(Owner.O);
        cells[1][1].setOwnerPlayer(Owner.X);
        //Then
        Assert.assertEquals(Owner.O, cells[0][0].getOwnerPlayer());
        Assert.assertEquals(Owner.X, cells[1][1].getOwnerPlayer());
    }

    @Test
    public void betterComputerStrategyTest() {
        //Given
        Board board = new Board(BoardSize.MAX_ROWS, BoardSize.MAX_COLS);
        //When
        Cell[][] cells = board.getCells();
        cells[0][0].setOwnerPlayer(Owner.O);
        cells[1][1].setOwnerPlayer(Owner.O);
        BetterComputerStrategy.computerMove(cells);
        Owner owner = cells[2][2].getOwnerPlayer();
        //Then
        Assert.assertEquals(Owner.X, owner);
    }
}
