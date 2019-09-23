package sample;

import javafx.scene.layout.Pane;

public class Cell extends Pane {
    private Owner ownerPlayer = Owner.EMPTY;

    public Cell(int x, int y) {
        setStyle("-fx-border-color: black; -fx-background-color: #40cd34");
        setPrefSize(105, 105);
    }

    public Owner getOwnerPlayer() {
        return ownerPlayer;
    }

    public void setOwnerPlayer(Owner ownerPlayer) {
        this.ownerPlayer = ownerPlayer;
    }
}
