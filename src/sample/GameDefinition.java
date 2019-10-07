package sample;

public class GameDefinition {
    private int maxRound;
    private int actualRound;
    private int pointsX;
    private int pointsO;
    private boolean gameOver;
    private boolean playerFirst;
    private DifficultyLevel difficultyLevel = DifficultyLevel.EASY;

    public int getMaxRound() {
        return maxRound;
    }

    public int getActualRound() {
        return actualRound;
    }

    public void setActualRound(int actualRound) {
        this.actualRound = actualRound;
    }

    public void setPointsX(int pointsX) {
        this.pointsX = pointsX;
    }

    public void setPointsO(int pointsO) {
        this.pointsO = pointsO;
    }

    public void setMaxRound(int maxRound) {
        this.maxRound = maxRound;
    }

    public int getPointsX() {
        return pointsX;
    }

    public void addPointsX() {
        pointsX++;
    }
    public int getPointsO() {
        return pointsO;
    }

    public void addPointsO() {
        pointsO++;
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isPlayerFirst() {
        return playerFirst;
    }

    public void setPlayerFirst(boolean playerFirst) {
        this.playerFirst = playerFirst;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
