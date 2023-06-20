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
        Button translateButton = new Button("Translate");
        translateButton.setOnAction(e -> {
            try {
                var errors = translator.processFile();
                // translator.processFile() now returns a list of soft errors that do not stop the translation
                // but are a sign that our grammar is potentially flawed
                // The main list contains smaller lists, each of the smaller lists contains errors line by line
                // TODO: maybe represent the errors in the GUI?? (not sure if it's of any use to the user)
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (scalaToCpp.ErrorListener.ErrorListenerException exception){
                System.out.println(exception.getMessage());
                // exception.cause gives access to the core exception (often of type RecognitionException)
                // the summary is contained in exception.getMessage() but the full stack trace is in exception.cause
                // TODO: represent the error in the GUI
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
                // translator.processFile() now returns a list of soft errors that do not stop the translation
                // but are a sign that our grammar is potentially flawed
                // The main list contains smaller lists, each of the smaller lists contains errors line by line
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }catch (scalaToCpp.ErrorListener.ErrorListenerException exception){
                System.out.println(exception.getMessage());
                // exception.cause gives access to the core exception (often of type RecognitionException)
                // the summary is contained in exception.getMessage() but the full stack trace is in exception.cause
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

        vBox.getChildren().addAll(hBox1, hBox2);

        Scene scene = new Scene(vBox, 900, 600);
        primaryStage.setTitle("Translator");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
