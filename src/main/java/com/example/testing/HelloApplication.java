package com.example.testing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // Crear componentes de la UI
        TextField passwordField = new TextField();
        passwordField.setPromptText("Ingresa la contraseña");

        Button evaluateButton = new Button("Evaluar");
        Label resultLabel = new Label();

        // Crear el evaluador de contraseñas
        PasswordEvaluator passwordEvaluator = new PasswordUtil();

        // Acción al hacer clic en el botón
        evaluateButton.setOnAction(event -> {
            String password = passwordField.getText();
            PasswordUtil.Securitylevel level = passwordEvaluator.assessPassword(password);
            resultLabel.setText("Nivel de seguridad: " + level);
        });

        // Crear un layout vertical y agregar los componentes
        VBox vbox = new VBox(10, passwordField, evaluateButton, resultLabel);
        vbox.setStyle("-fx-padding: 10;"); // Espaciado

        // Crear la escena y mostrarla
        Scene scene = new Scene(vbox, 320, 240);
        stage.setTitle("Evaluador de Contraseñas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
