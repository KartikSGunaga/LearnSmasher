package org.example.learnsmashers.Project08;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Calculator calculator;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(8);

        Label num1Label = new Label("Enter the number1:");
        GridPane.setConstraints(num1Label, 0, 0);

        TextField num1Input = new TextField();
        num1Input.setPromptText("Number1");
        GridPane.setConstraints(num1Input, 1, 0);

        Label num2Label = new Label("Enter the number2:");
        GridPane.setConstraints(num2Label, 0, 1);

        TextField num2Input = new TextField();
        num2Input.setPromptText("Number2");
        GridPane.setConstraints(num2Input, 1, 1);

        Label operationLabel = new Label("Enter the operation:");
        GridPane.setConstraints(operationLabel, 0, 2);

        TextField operationInput = new TextField();
        operationInput.setPromptText("Operation");
        GridPane.setConstraints(operationInput, 1, 2);

        Button calculateButton = new Button("Calculate");
        GridPane.setConstraints(calculateButton, 1, 3);

        Label resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 1, 4);

        grid.getChildren().addAll(num1Label, num1Input, num2Label, num2Input, operationLabel, operationInput,
                calculateButton, resultLabel);

        calculateButton.setOnAction(e -> {
            try {
                int num1 = Integer.parseInt(num1Input.getText());
                int num2 = Integer.parseInt(num2Input.getText());
                String operation = operationInput.getText().trim();

                calculator = new Calculator(num1, num2, operation);
                int result = calculator.calculate();

                resultLabel.setText(num1 + " " + operation + " " + num2 + " = " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter valid numbers.");
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
