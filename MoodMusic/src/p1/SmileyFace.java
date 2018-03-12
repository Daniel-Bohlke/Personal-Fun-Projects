package p1;
import p1.Point;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import javafx.*;
import java.util.ArrayList;
import java.util.Collections;


public class SmileyFace extends Application {

    private static final int CENTER_Y = 200;
    private static final int CENTER_X = 200;
    private static final int RADIUS = 100;

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        ArrayList<Shape> shapes = new ArrayList<>();

        
        Circle c = new Circle(CENTER_X, CENTER_Y, RADIUS, Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        shapes.add(c);

        
        Line[] nose = createFixedNose(c);
        Collections.addAll(shapes, nose);

        
        double y =  CENTER_Y - (RADIUS / 2.8);
        double x = CENTER_X - (RADIUS / 2.8);
        for (int i = 0; i < 2; i++) {
            Ellipse outerC = new Ellipse(x, y, RADIUS / 4, RADIUS / 6);
            outerC.setFill(Color.TRANSPARENT);
            outerC.setStroke(Color.BLACK);
            shapes.add(outerC);

            Circle pupil = new Circle(outerC.getCenterX(), outerC.getCenterY(), outerC.getRadiusY() / 1.2);
            shapes.add(pupil);
            x += (RADIUS / 2.8) * 2;
        }

        
        Arc smile = new Arc(
                c.getCenterX(), 
                c.getCenterY() + (c.getRadius() / 3),
                c.getRadius() / 2, 
                c.getRadius() / 2 / 2, 
                180, 180); 
        smile.setFill(Color.TRANSPARENT);
        smile.setStroke(Color.BLACK);
        shapes.add(smile);


        pane.getChildren().addAll(shapes);
        Scene scene = new Scene(pane, CENTER_X + RADIUS * 2, CENTER_Y + RADIUS * 2);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Smiley Face!");
        primaryStage.show();
    }

    
    private Line[] createFixedNose(Circle c) {
        Point p1 = new Point(c.getCenterX() - (c.getRadius() / 4), c.getCenterY() + (c.getRadius() / 4));
        Point p2 = new Point(c.getCenterX() + (c.getRadius() / 4), c.getCenterY() + (c.getRadius() / 4));
        Point p3 = new Point(c.getCenterX(), c.getCenterY() - (c.getRadius() / 4));

        Line[] lines = new Line[3];
        lines[0] = new Line(p1.x, p1.y, p2.x, p2.y);
        lines[1] = new Line(p2.x, p2.y, p3.x, p3.y);
        lines[2] = new Line(p3.x, p3.y, p1.x, p1.y);

        return lines;
    }



    public static void main(String[] args) {
        Application.launch(args);
    }
}