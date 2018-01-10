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
 * Рус:
 * <p>
 * Окно подтверждения, дает варианты выбора 'Да' или 'Отмена'.
 * <p>
 * Eng:
 * <p>
 * Confirmation window allows user to select 'Yes' or 'Cancel'
 */
public class ConfirmStage  {

    static boolean answer;

    /**
     * Рус:
     * <p>
     * Показывает окно подтверждения. Возвращает 1, если выбран вариант 'Да', 0 - если 'Отмена'
     * <p>
     * Eng:
     * <p>
     * Display confirmation window. Returns 1 - 'Yes', 0 - 'cancel'
     * @param title header of the window (not used in that program)
     * @param message message to show
     * @return 1 - 'Yes', 0 - 'cancel'
     * @throws Exception
     */
    public static boolean display(String title, String message) throws Exception {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setTitle(title);
        window.setWidth(350);
        window.setHeight(200);

        Label labelMessage = new Label(message);
        labelMessage.setFont(Font.font(20));

        Button buttonConfirm = new Button("Да");
        Button buttonCancel = new Button("Отмена");


        buttonConfirm.setOnAction(e-> {
            answer = true;
            window.close();
        });
        buttonCancel.setOnAction(e-> {
            answer = false;
            window.close();
        });


        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        HBox layoutButtons = new HBox(10);
        layoutButtons.setAlignment(Pos.CENTER);

        layoutButtons.getChildren().addAll(buttonConfirm,buttonCancel);
        layout.getChildren().addAll(labelMessage,layoutButtons);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

}
