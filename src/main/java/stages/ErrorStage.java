package stages;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by SkaaRJ on 02.11.2017.
 */
public class ErrorStage {


    public static void display(String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setTitle("Ошибка");
        window.setWidth(350);
        window.setHeight(200);
        Label labelError = new Label("Ошибка");
        labelError.setFont(Font.font(26));
        Label labelMessage = new Label(message);
        labelError.setFont(Font.font(16));

        Button buttonConfirm = new Button("OK");



        buttonConfirm.setOnAction(e-> {
            window.close();
        });



        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        layout.getChildren().addAll(labelError,labelMessage,buttonConfirm);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
