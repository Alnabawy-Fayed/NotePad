package com.example.notepad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        MenuItem save = new MenuItem("save");
        file.getItems().add(save);
        menuBar.getMenus().add(file);
        TextArea textArea = new TextArea();
        textArea.setMaxHeight(700);
        textArea.setMaxWidth(500);
        save.setOnAction(ActionEvent -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("txt files","*.txt");
            File SaveFile = fileChooser.showSaveDialog(null);
            try {
                FileWriter fileWriter = new FileWriter(SaveFile);
                fileWriter.write(textArea.getText());
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        GridPane gridPane = new GridPane();
        gridPane.add(menuBar,0,0);
        gridPane.add(textArea,0,1);
        Group group = new Group();
        group.getChildren().add(gridPane);
         Scene scene = new Scene(group);
         Stage stage1 = new Stage();
         stage1.setScene(scene);
         stage1.setMaxHeight(700);
         stage1.setMaxWidth(500);
         stage1.setTitle("Notepad");
         stage1.show();

    }

    public static void main(String[] args) {
        launch();
    }
}