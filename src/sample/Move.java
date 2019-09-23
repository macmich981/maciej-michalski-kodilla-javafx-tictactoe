package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class Move {
    public static void drawMoveX(Cell cell) {
        Line line1 = new Line(10, 10, cell.getWidth() - 10, cell.getHeight() - 10);
        line1.endXProperty().bind(cell.widthProperty().subtract(10));
        line1.endYProperty().bind(cell.heightProperty().subtract(10));
        line1.setStroke(Color.RED);
        line1.setStrokeWidth(10);

        Line line2 = new Line(10, cell.getHeight() - 10, cell.getWidth() - 10, 10);
        line2.endXProperty().bind(cell.widthProperty().subtract(10));
        line2.startYProperty().bind(cell.heightProperty().subtract(10));
        line2.setStroke(Color.RED);
        line2.setStrokeWidth(10);

        cell.getChildren().addAll(line1, line2);
    }

    public static void drawMoveO(Cell cell) {
        Ellipse ellipse = new Ellipse(cell.getWidth() / 2, cell.getHeight() / 2, cell.getWidth() / 2 - 10,
                cell.getHeight() / 2 - 10);
        ellipse.centerXProperty().bind(cell.widthProperty().divide(2));
        ellipse.centerYProperty().bind(cell.heightProperty().divide(2));
        ellipse.radiusXProperty().bind(cell.widthProperty().divide(2).subtract(10));
        ellipse.radiusYProperty().bind(cell.heightProperty().divide(2).subtract(10));
        ellipse.setStroke(Color.BLUE);
        ellipse.setStrokeWidth(10);
        ellipse.setFill(Color.TRANSPARENT);

        cell.getChildren().add(ellipse);
    }
}
