import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import java.awt.Desktop;

import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class GUI extends Application{

    scalaToCpp translator = new scalaToCpp();
    File input;
    File output;
    private Desktop desktop = Desktop.getDesktop();
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open .scala File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Scala Files", "*.scala")
        );

        TextArea textArea1 = new TextArea();
        textArea1.setEditable(false);
        Button openButton = new Button("Open a Scala File");
        openButton.setOnAction(e -> {
            input = fileChooser.showOpenDialog(primaryStage);
            if (input != null) {
                try {
                    translator.input = input;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            StringBuilder sb = new StringBuilder();
            Scanner scanner;
            try {
                scanner = new Scanner(translator.input);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            textArea1.setText(sb.toString());

        });
        TextArea textArea2 = new TextArea();
        textArea2.setEditable(false);
        TextArea textArea3 = new TextArea();
        textArea3.setEditable(false);
        textArea3.setStyle("-fx-text-fill: #d8706a;");
        textArea3.setMinWidth(860);
        textArea3.setMinHeight(85);
        textArea3.setText("Errors will be displayed here");


        Button translateButton = new Button("Translate");
        translateButton.setOnAction(e -> {
            textArea3.setText("");
            try {
                var errors = translator.processFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (scalaToCpp.ErrorListener.ErrorListenerException exception){
                StringBuilder sb = new StringBuilder();
                sb.append(exception.getMessage());
                sb.append(": ");
                if(exception.cause != null){
                    sb.append("\n");
                    sb.append("Stack trace: \n");
                    StackTraceElement[] stackTraceElements = exception.cause.getStackTrace();
                    for(StackTraceElement stackTraceElement : stackTraceElements){
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                }
                textArea3.setText(sb.toString());
                return;
            }
            StringBuilder sb = new StringBuilder();
            Scanner scanner;
            try {
                scanner = new Scanner(translator.output);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            textArea2.setText(sb.toString());
        });

        Button translateToButton = new Button("Translate to ...");
        FileChooser fileChooser2 = new FileChooser();
        fileChooser2.setTitle("Save .cpp File");
        fileChooser2.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("C++ Files", "*.cpp")
        );


        translateToButton.setOnAction(e -> {
            textArea3.setText("");
            output = fileChooser2.showSaveDialog(primaryStage);
            if (output == null) {
                return;
            }
            if (output.exists()) {
                try {
                    translator.output = output;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else{
                try {
                    Files.createFile(output.toPath().toAbsolutePath());
                    translator.output = output;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            try {
                var errors = translator.processFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (scalaToCpp.ErrorListener.ErrorListenerException exception){
                StringBuilder sb = new StringBuilder();
                sb.append(exception.getMessage());
                sb.append(": ");
                if(exception.cause != null){
                    StackTraceElement[] stackTraceElements = exception.cause.getStackTrace();
                    for(StackTraceElement stackTraceElement : stackTraceElements){
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            Scanner scanner;
            try {
                scanner = new Scanner(output);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            textArea2.setText(sb.toString());
        });




        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setPadding(new Insets(10, 10, 10, 10));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(openButton, translateButton, translateToButton);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.setPrefSize(800, 600);
        hBox2.setPadding(new Insets(10, 10, 10, 10));
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(textArea1, textArea2);

        HBox hBox3 = new HBox();
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().addAll(textArea3);

        vBox.getChildren().addAll(hBox1, hBox2, hBox3);

        Scene scene = new Scene(vBox, 900, 600);
        primaryStage.setTitle("Translator");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
