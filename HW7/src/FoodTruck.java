import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * FoodTruck class.
 * @author Jessie Xu
 * @version 1.0
 */
public class FoodTruck extends Application {
    public int itemSum;
    File outFile;
    PrintWriter outPrintWriter;
    private int tf1Num; //Num of hamburgers
    private int tf2Num; //Num of hot dogs
    private int tf3Num; //Num of ice creams
    int[] itemArray = {tf1Num, tf2Num, tf3Num};
    TextField tf1 = new TextField("0");
    TextField tf2 = new TextField("0");
    TextField tf3 = new TextField("0");
    Label l1 = new Label("Hamburger $10");
    Label l2 = new Label("Hot Dog $6");
    Label l3 = new Label("Ice Cream $4");
    Label l4 = new Label("Total Order: $" + itemSum);
    Button clear = new Button("Clear");
    Button purchase = new Button("Purchase");
    Alert a = new Alert(Alert.AlertType.ERROR);


    /**
     * Start method of FoodTruck javafx.
     * @param primaryStage Primary stage takes in
     * @throws Exception Custom exceptions NegativeQuantityException and IllegalQuantityException
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        final int widthMid = 250;
        final int heightMid = 300;
        Text name = new Text(20, 30, "Jessie Xu");
        name.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        name.setFill(Color.WHITE);
        Text email = new Text(20, 70, "jxu645@gatech.edu");
        email.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        email.setFill(Color.WHITE);
        Rectangle tag = new Rectangle(0, 0, 500, 100);
        tag.setFill(Color.BLACK);
        Rectangle back = new Rectangle(0, 100, 500, 400);
        back.setFill(Color.BEIGE);
        Rectangle ground = new Rectangle(0, 420, 500, 100);
        ground.setFill(Color.DARKSEAGREEN);
        Rectangle body = new Rectangle(widthMid - 150, heightMid - 100, 300, 200); //(100, 200, 300, 200)
        body.setFill(Color.INDIANRED);
        body.setStroke(Color.DARKGREY);
        body.setStrokeWidth(5);
        Circle tire1 = new Circle(widthMid - 80, heightMid + 100, 30);
        tire1.setFill(Color.GREY);
        Circle tire2 = new Circle(widthMid + 80, heightMid + 100, 30);
        tire2.setFill(Color.GREY);
        Line deco1 = new Line(widthMid - 144, heightMid + 30, widthMid + 144, heightMid + 30);
        deco1.setStroke(Color.WHITE);
        deco1.setStrokeWidth(8);
        Line deco2 = new Line(widthMid - 144, heightMid + 50, widthMid + 144, heightMid + 50);
        deco2.setStroke(Color.WHITE);
        deco2.setStrokeWidth(8);
        Ellipse top1 = new Ellipse(widthMid - 130, heightMid - 100, 60, 40);
        top1.setFill(Color.DARKSALMON);
        Ellipse top2 = new Ellipse(widthMid - 40, heightMid - 100, 60, 40);
        top2.setFill(Color.DARKSALMON);
        Ellipse top3 = new Ellipse(widthMid + 50, heightMid - 100, 60, 40);
        top3.setFill(Color.DARKSALMON);
        Ellipse top4 = new Ellipse(widthMid + 140, heightMid - 100, 60, 40);
        top4.setFill(Color.DARKSALMON);
        Text ft = new Text(180, 390, "Food Truck");
        ft.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
        ft.setFill(Color.FLORALWHITE);
        Rectangle window1 = new Rectangle(widthMid - 130, heightMid - 50, 120, 50);
        window1.setFill(Color.LIGHTBLUE);
        window1.setStroke(Color.LIGHTCORAL);
        window1.setStrokeWidth(5);
        Rectangle window2 = new Rectangle(widthMid + 10, heightMid - 50, 120, 50);
        window2.setFill(Color.LIGHTBLUE);
        window2.setStroke(Color.LIGHTCORAL);
        window2.setStrokeWidth(5);
        Pane pane = new Pane();
        pane.getChildren().add(tag);
        pane.getChildren().add(name);
        pane.getChildren().add(email);
        pane.getChildren().add(back);
        pane.getChildren().add(ground);
        pane.getChildren().add(tire1);
        pane.getChildren().add(tire2);
        pane.getChildren().add(body);
        pane.getChildren().add(deco1);
        pane.getChildren().add(deco2);
        pane.getChildren().add(top1);
        pane.getChildren().add(top2);
        pane.getChildren().add(top3);
        pane.getChildren().add(top4);
        pane.getChildren().add(ft);
        pane.getChildren().add(window1);
        pane.getChildren().add(window2);
        primaryStage.setTitle("Graphics Window");
        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();

        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        bp.setTop(new CustomPane("CS 1331 Food Truck"));
        bp.setLeft(getGridPane(gp));
        bp.setBottom(getHBox());
        clear.setOnAction(new ClearHandler());
        purchase.setOnAction(new PurchaseHandler());
        tf1.setOnAction(e -> l4.setText("Total Order: $"
                + setTf1Num((tf1.getText()))));
        tf2.setOnAction(e -> l4.setText("Total Order: $"
                + setTf2Num((tf2.getText()))));
        tf3.setOnAction(e -> l4.setText("Total Order: $"
                + setTf3Num((tf3.getText()))));

        Stage secondStage = new Stage();
        secondStage.setTitle("Food Truck Window");
        secondStage.setScene(new Scene(bp, 400, 300));
        secondStage.show();
    }

    /**
     * Helper class to put "CS 1331 Food Truck" in the right place.
     */
    class CustomPane extends StackPane {
        CustomPane(String title) {
            getChildren().add(new Label(title));
            setStyle("-fx-background-color: gray");
            setPadding(new Insets(15, 15, 15, 15));
        }
    }

    /**
     * Inner class that handles event when clear button is clicked.
     */
    class ClearHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            tf1.setText("0");
            tf2.setText("0");
            tf3.setText("0");
            tf1Num = 0;
            tf2Num = 0;
            tf3Num = 0;
            calcSum();
            l4.setText("Total Order: $" + itemSum);
        }
    }

    /**
     * Helper method to place bottom buttons on the right place.
     * @return Returns an arranged hbox for borderpane
     */
    private HBox getHBox() {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gray");
        Pane space = new Pane();
        HBox.setHgrow(space, Priority.ALWAYS);
        hBox.getChildren().addAll(clear, space, purchase);
        return hBox;
    }

    /**
     * Helper method to create gridpane.
     * @param gp Takes in gridpane that is ready to add elements
     * @return Returns settled gridpane
     */
    private GridPane getGridPane(GridPane gp) {
        gp.addRow(0, tf1, l1);
        gp.addRow(1, tf2, l2);
        gp.addRow(2, tf3, l3);
        gp.addRow(3, l4);
        gp.setVgap(20);
        gp.setHgap(20);
        return gp;
    }

    /**
     * Determines if a string can parse to integer.
     * @param s String value that is testing
     * @return Returns if string can be parsed or not
     */
    public static boolean canParse(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    /**
     * Inner class that handles events.
     */
    class PurchaseHandler implements EventHandler<ActionEvent> {

        /**
         * Handler method that alerts user when error occurred.
         * Prints purchased items to order.txt.
         */
        @Override
        public void handle(ActionEvent arg) {
            try {
                if (!canParse(tf1.getText())) {
                    a.setContentText("Entered quantity is not an integer.");
                    a.show();
                    throw new IllegalQuantityException(tf1.getText());
                }
                if (!canParse(tf2.getText())) {
                    a.setContentText("Entered quantity is not an integer.");
                    a.show();
                    throw new IllegalQuantityException(tf2.getText());
                }
                if (!canParse(tf3.getText())) {
                    a.setContentText("Entered quantity is not an integer.");
                    a.show();
                    throw new IllegalQuantityException(tf3.getText());
                }
                if (canParse(tf1.getText()) && Integer.parseInt(tf1.getText()) < 0) {
                    a.setContentText("Entered quantity can't be negative.");
                    a.show();
                    throw new NegativeQuantityException(tf1Num + "");
                }
                if (canParse(tf2.getText()) && Integer.parseInt(tf2.getText()) < 0) {
                    a.setContentText("Entered quantity can't be negative.");
                    a.show();
                    throw new NegativeQuantityException(tf2Num + "");
                }
                if (canParse(tf3.getText()) && Integer.parseInt(tf3.getText()) < 0) {
                    a.setContentText("Entered quantity can't be negative.");
                    a.show();
                    throw new NegativeQuantityException(tf3Num + "");
                }
            } catch (IllegalQuantityException iqe) {
                System.out.println(iqe.getMessage());
                return;
            } catch (NegativeQuantityException ne) {
                System.out.println(ne.getMessage());
                return;
            }
            try {
                outFile = new File("order.txt");
                outPrintWriter = new PrintWriter(outFile);
                if (tf1Num > 0) {
                    outPrintWriter.println("Hamburgers: " + tf1Num);
                }
                if (tf2Num > 0) {
                    outPrintWriter.println("Hot Dogs: " + tf2Num);
                }
                if (tf3Num > 0) {
                    outPrintWriter.println("Ice Creams: " + tf3Num);
                }
                outPrintWriter.println("Total Order: $" + itemSum);
            } catch (IOException e) {
            } finally {
                outPrintWriter.close();
            }
        }
    }

    /**
     * Calculates total cost after entered amount of hamburgers.
     * @param s Text entered by user
     * @return Total cost
     */
    private String setTf1Num(String s) {
        if (s.trim().equals("")) {
            tf1Num = 0;
            calcSum();
            return itemSum + "";
        } else {
            if (canParse(s)) {
                tf1Num = Integer.parseInt(s);
            }
            calcSum();
            return itemSum + "";
        }
    }

    /**
     * Calculates total cost after entered amount of hot dogs.
     * @param s Text entered by user
     * @return Total cost
     */
    private String setTf2Num(String s) {
        if (s.trim().equals("")) {
            tf2Num = 0;
            calcSum();
            return itemSum + "";
        } else {
            if (canParse(s)) {
                tf2Num = Integer.parseInt(s);
            }
            calcSum();
            return itemSum + "";
        }
    }

    /**
     * Calculates total cost after entered amount of ice creams.
     * @param s Text entered by user
     * @return Total cost
     */
    private String setTf3Num(String s) {
        if (s.trim().equals("")) {
            tf3Num = 0;
            calcSum();
            return itemSum + "";
        } else {
            if (canParse(s)) {
                tf3Num = Integer.parseInt(s);
            }
            calcSum();
            return itemSum + "";
        }
    }

    /**
     * Method to calculate items' sum.
     */
    private void calcSum() {
        itemSum = tf1Num * 10 + tf2Num * 6 + tf3Num * 4;
    }
}