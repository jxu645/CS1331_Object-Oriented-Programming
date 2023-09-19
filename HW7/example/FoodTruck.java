import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FoodTruck extends Application {
    /** File that is used for order.txt. */
    File outFile;
    /** PrintWriter that is used for order.txt. */
    PrintWriter outWrite;
    /** Total cost for food truck order. */
    private int sum = 0;
    /** Number of burgers. */
    private int burgers = 0;
    /** Number of hot dogs. */
    private int hotDogs = 0;
    /** Number of fries. */
    private int fries = 0;
    /** Text field for burger input. */
    TextField burgerField = new TextField();
    /** Text field for hot dog input. */
    TextField hotDogField = new TextField();
    /** Text field for fries input. */
    TextField friesField = new TextField();


    /**
     * Method that takes in String and sets burger value
     * while returning sum as a String.
     *
     * @param input String of number of burgers.
     * @return The sum as a String.
     */
    private String setBurgerValue(String input) {
        if (input.trim().equals("")) {
            burgers = 0;
            calcSum();
            return sum + "";
        } else {
            if (isInteger(input)) {
                burgers = Integer.parseInt(input);
            }
            calcSum();
            return sum + "";
        }
    }

    /**
     * Method that takes in String and sets hot dog value
     * while returning sum as a String.
     *
     * @param input String of number of hot dogs.
     * @return The sum as a String.
     */
    private String setHotDogValue(String input) {
        if (input.trim().equals("")) {
            hotDogs = 0;
            calcSum();
            return sum + "";
        } else {
            if (isInteger(input)) {
                hotDogs = Integer.parseInt(input);
            }
            hotDogs = Integer.parseInt(input);
            calcSum();
            return sum + "";
        }
    }

    /**
     * Method that takes in String and sets fries value
     * while returning sum as a String.
     *
     * @param input String of number of fries.
     * @return The sum as a String.
     */
    private String setFriesValue(String input) {
        if (input.trim().equals("")) {
            fries = 0;
            calcSum();
            return sum + "";
        } else {
            if (isInteger(input)) {
                fries = Integer.parseInt(input);
            }
            fries = Integer.parseInt(input);
            calcSum();
            return sum + "";
        }
    }

    /**
     * Getter method for sum.
     *
     *
     * @return Sum.
     */
    private int getSum() {
        return sum;
    }

    /**
     * Method that calculates sum by prices of
     * each item.
     *
     */
    private void calcSum() {
        sum = burgers * 8 + hotDogs * 5 + fries * 3;
    }

    //////////////////////////////////////////////////
    /**
     * Start method for JavaFx.
     *
     * @param primaryStage default input.
     */
    public void start(Stage primaryStage) {

        /*
        ROCKET SHIP WINDOW
        */

        //Background
        Rectangle background = new Rectangle(0, 0, 2000, 2000);
        background.setFill(Color.BLACK);

        //Name Label
        Label lb1 = new Label("Aya Kakizaki\nakakizaki3@gatech.edu");
        lb1.setContentDisplay(ContentDisplay.BOTTOM);
        lb1.setTextFill(Color.WHITE);

        //Nose of Rocket
        Polygon nose = new Polygon();
        nose.getPoints().addAll(new Double[]{
                200.0, 0.0,
                150.0, 75.0,
                250.0, 75.0});
        nose.setFill(Color.RED);

        //Body of Rocket
        Rectangle body = new Rectangle(150, 75, 100, 200);
        body.setFill(Color.BLUE);

        //Window Frame of Rocket
        Circle frame = new Circle(200, 175, 35);
        frame.setFill(Color.AQUA);

        //Window of Rocket
        Circle window = new Circle(200, 175, 30);
        window.setFill(Color.WHITE);

        //Face of Man
        Circle face = new Circle(200, 175, 20);
        face.setFill(Color.WHITE);
        face.setStroke(Color.BLACK);
        face.setStrokeWidth(3);

        //Left Eye of Man
        Line leftEye = new Line(192, 165, 192, 175);

        //Right Eye of Man
        Line rightEye = new Line(208, 165, 208, 175);

        //Bottom Body of Rocket
        Rectangle bottomBody = new Rectangle(150, 275, 100, 25);
        bottomBody.setFill(Color.BLUE);

        //Left Wing of Rocket
        Polygon leftWing = new Polygon();
        leftWing.getPoints().addAll(new Double[]{
                150.0, 275.0,
                150.0, 200.0,
                90.0, 275.0});
        leftWing.setFill(Color.RED);

        //Right Wing of Rocket
        Polygon rightWing = new Polygon();
        rightWing.getPoints().addAll(new Double[]{
                250.0, 275.0,
                250.0, 200.0,
                310.0, 275.0});
        rightWing.setFill(Color.RED);

        //Bottom Wing of Rocket
        Polygon bottomWing = new Polygon();
        bottomWing.getPoints().addAll(new Double[]{
                175.0, 240.0,
                225.0, 240.0,
                200.0, 320.0});
        bottomWing.setFill(Color.RED);

        //Left Flame of Rocket
        Polygon leftFlame = new Polygon();
        leftFlame.getPoints().addAll(new Double[]{
                150.0, 300.0,
                225.0, 300.0,
                175.0, 380.0});
        leftFlame.setFill(Color.ORANGE);

        //Right Flame of Rocket
        Polygon rightFlame = new Polygon();
        rightFlame.getPoints().addAll(new Double[]{
                250.0, 300.0,
                175.0, 300.0,
                225.0, 380.0});
        rightFlame.setFill(Color.ORANGE);

        //Middle Flame of Rocket
        Polygon middleFlame = new Polygon();
        middleFlame.getPoints().addAll(new Double[]{
                175.0, 300.0,
                225.0, 300.0,
                200.0, 375.0});
        middleFlame.setFill(Color.ORANGE);

        //Text for Rocket
        Text rocketText = new Text(25, 425, "My Amazing Rocket Ship!!!");
        rocketText.setFont(new Font("Verdana", 30));
        rocketText.setFill(Color.WHITE);

        //Pane of Rocket
        Pane pane = new Pane();
        pane.getChildren().add(background);
        pane.getChildren().add(lb1);
        pane.getChildren().add(nose);
        pane.getChildren().add(body);
        pane.getChildren().add(frame);
        pane.getChildren().add(window);
        pane.getChildren().add(bottomBody);
        pane.getChildren().add(leftWing);
        pane.getChildren().add(rightWing);
        pane.getChildren().add(leftFlame);
        pane.getChildren().add(rightFlame);
        pane.getChildren().add(middleFlame);
        pane.getChildren().add(bottomWing);
        pane.getChildren().add(rocketText);
        pane.getChildren().add(face);
        pane.getChildren().add(leftEye);
        pane.getChildren().add(rightEye);


        ////////////////////////////////////////////////////
        /*
        FOOD TRUCK
        */

        //Label for Food Truck
        Text title = new Text();
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        title.setText("CS 1331 Food Truck");

        //Pane for Food Truck
        BorderPane bPane = new BorderPane();

        //Title Pane
        HBox upBox = new HBox();
        upBox.setPadding(new Insets(10, 15, 15, 15));
        upBox.getChildren().add(title);
        upBox.setAlignment(Pos.CENTER);

        //Burger Field
        burgerField.setText("0");

        //Hot Dog Field
        hotDogField.setText("0");

        //Fries Field
        friesField.setText("0");

        //Food Text
        Text burgerText = new Text("Hamburger ($8)");
        Text hotDogText = new Text("Hot Dog ($5)");
        Text friesText = new Text("French Fires ($3)");
        Text totalText = new Text("Total Order: $" + sum);

        //Text Field Actions
        burgerField.setOnAction(e -> totalText.setText("Total Order: $"
                + setBurgerValue((burgerField.getText()))));

        hotDogField.setOnAction(e -> totalText.setText("Total Order: $"
                + setHotDogValue(hotDogField.getText())));

        friesField.setOnAction(e -> totalText.setText("Total Order: $"
                + setFriesValue(friesField.getText())));

        //Food Counter Grid Pane
        GridPane foodBox = new GridPane();
        foodBox.setPadding(new Insets(30, 10, 0, 30));
        foodBox.setHgap(10);
        foodBox.setVgap(10);
        foodBox.add(burgerField, 0, 0);
        foodBox.add(hotDogField, 0, 1);
        foodBox.add(friesField, 0, 2);
        foodBox.add(burgerText, 1, 0);
        foodBox.add(hotDogText, 1, 1);
        foodBox.add(friesText, 1, 2);
        foodBox.add(totalText, 0, 3);

        //Clear Button
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> {
            burgerField.setText("0");
            hotDogField.setText("0");
            friesField.setText("0");
            burgers = 0;
            hotDogs = 0;
            fries = 0;
            calcSum();
            totalText.setText("Total Order: $" + getSum());
        });

        //Submit Button
        Button purchaseButton = new Button("Purchase");
        purchaseButton.setOnAction(new PurchaseHandler());


        //Button Gird Pane
        GridPane buttonPane = new GridPane();
        buttonPane.setPadding(new Insets(10, 30, 10, 30));
        buttonPane.setHgap(275);
        buttonPane.add(clearButton, 0, 0);
        buttonPane.add(purchaseButton, 1, 0);

        //Border Pane Setup
        bPane.setTop(upBox);
        bPane.setCenter(foodBox);
        bPane.setBottom(buttonPane);


        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Graphics"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        Stage stage = new Stage();
        Scene secondScene = new Scene(bPane, 450, 300);
        stage.setTitle("Food Truck");
        stage.setScene(secondScene);
        stage.show();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     *
     * @param args default input.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Static method that confirms if a String is an int.
     *
     * @param num String.
     * @return true if String is int, false otherwise.
     */
    public static boolean isInteger(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Handler class for purchase button..
     */
    class PurchaseHandler implements EventHandler<ActionEvent> {

        /**
         * Handle method that throws exceptions for incorrect input
         * and prints values to order.txt receipt.
         */
        @Override
        public void handle(ActionEvent arg0) {
            try {
                if (!isInteger(burgerField.getText())) {
                    throw new IllegalQuantityException(burgerField.getText());
                }
                if (!isInteger(hotDogField.getText())) {
                    throw new IllegalQuantityException(hotDogField.getText());
                }
                if (!isInteger(friesField.getText())) {
                    throw new IllegalQuantityException(friesField.getText());
                }

                if (burgers < 0) {
                    throw new NegativeQuantityException(burgers + "");
                }
                if (hotDogs < 0) {
                    throw new NegativeQuantityException(hotDogs + "");
                }
                if (fries < 0) {
                    throw new NegativeQuantityException(fries + "");
                }

            } catch (IllegalQuantityException e) {
                System.out.println(e.getMessage());
                return;
            } catch (NegativeQuantityException ne) {
                System.out.println(ne.getMessage());
                return;
            }

            try {
                outFile = new File("order.txt");
                outWrite = new PrintWriter(outFile);
                if (burgers > 0) {
                    outWrite.println("Burgers: " + burgers);
                }
                if (hotDogs > 0) {
                    outWrite.println("Hot Dogs: " + hotDogs);
                }
                if (fries > 0) {
                    outWrite.println("Fries: " + fries);
                }
                outWrite.println("Total Order: $" + sum);
            } catch (IOException e) {
            } finally {
                outWrite.close();
            }
        }
    }
}


