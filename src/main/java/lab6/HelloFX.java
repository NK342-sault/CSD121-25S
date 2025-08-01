package lab6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.*;

import static javafx.collections.FXCollections.observableArrayList;

public class HelloFX extends Application {
    private ListView<Label> toDoListView;
    private ObservableList<Label> toDos;
    private TextField taskInput;
    private ComboBox<String> priorityBox;

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(90);
        root.setPadding(new Insets(10));

        Label titleLabel = new Label("To Do List");
        titleLabel.setStyle("-fx-font-size: 50; -fx-font-weight: bold;");

        HBox input = new HBox(5);
        taskInput = new TextField();
        taskInput.setPromptText("Enter a New Task");
        HBox.setHgrow(taskInput, Priority.ALWAYS);

        priorityBox = new ComboBox<>();
        priorityBox.getItems().addAll("Low Priority", "High Priority");
        priorityBox.setValue("Low Priority");

        Button addButton = new Button("Add Task");
        input.getChildren().addAll(taskInput, priorityBox, addButton);

        toDos = observableArrayList();
        toDoListView = new ListView<Label>(toDos);
        toDoListView.setPrefHeight(300);

        HBox buttonBox= new HBox(10);
        Button deleteButton = new Button("Delete Selected Task");
        Button clearButton = new Button("Clear All Tasks");
        Button markAsDoneButton = new Button("Mark Task as Completed");
        buttonBox.getChildren().addAll(deleteButton, clearButton, markAsDoneButton);


        root.getChildren().addAll(titleLabel, input, toDoListView, buttonBox);

        Scene scene = new Scene(root, 900, 700);
        stage.setTitle(titleLabel.getText());
        stage.setScene(scene);
        stage.show();

        addButton.setOnAction(e -> addTask());

        deleteButton.setOnAction(e -> {
            int selectedIndx = toDoListView.getSelectionModel().getSelectedIndex();
            if (selectedIndx != -1){
                toDos.remove(selectedIndx);
            }
        });

        clearButton.setOnAction(e -> {
            toDos.clear();
        });

        markAsDoneButton.setOnAction(e -> {
            int selectedIndx = toDoListView.getSelectionModel().getSelectedIndex();
            if (selectedIndx != -1){
                Label taskLabel  = toDos.get(selectedIndx);
                HBox taskBox = (HBox) taskLabel.getGraphic();

                Text checkmark = new Text("✓");
                checkmark.setFill(Color.GREEN);
                checkmark.setStyle("-fx-font-size: 16");

                taskBox.getChildren().set(0, checkmark);

                Label textLabel = (Label) taskBox.getChildren().get(1);
                textLabel.setTextFill(Color.GRAY);
            }
        });
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()){
            String priority = priorityBox.getValue();
            Shape priorityShape;
            if (priority.equals("High Priority")){
                Circle circle = new Circle(8);
                circle.setFill(Color.RED);
                priorityShape = circle;
            } else {
                Rectangle rectangle = new Rectangle(10, 10);
                rectangle.setFill(Color.GREEN);
                priorityShape = rectangle;
            }

            HBox taskBox = new HBox(10);
            taskBox.getChildren().addAll(priorityShape, new Label(task));

            Label taskLabel = new Label();
            taskLabel.setGraphic(taskBox);
            toDos.add(taskLabel);
            taskInput.clear();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}