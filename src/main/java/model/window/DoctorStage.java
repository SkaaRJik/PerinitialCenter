package model.window;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Рус:
 * <p>
 * Окно для изменения ФИО текущего доктора.
 * <p>
 * Eng:
 * <p>
 * Window changes full name of current doctor.
 */
public class DoctorStage  {
    static String doctorName;

    /**
     * Рус:
     * <p>
     * Показывает окно редактирования ФИО доктора. Не позволяет закрыть.
     * <p>
     * Eng:
     * <p>
     * Displays window to change doctor's full name. Closing is not allowed
     * @return new full name
     * @throws Exception
     */
    public static String display() throws Exception {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setTitle("Доктор");
        window.setWidth(350);
        window.setHeight(200);

        Label labelDoctor = new Label("Доктор: ");
        labelDoctor.setFont(Font.font(20));
        TextField textFieldDoctorName = new TextField();

        Button buttonConfirm = new Button("OK");



        buttonConfirm.setOnAction(e-> {
            window.close();
        });



        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        HBox layoutDoctorFields = new HBox(5);
        layoutDoctorFields.setAlignment(Pos.CENTER);

        layoutDoctorFields.getChildren().addAll(labelDoctor,textFieldDoctorName);
        layout.getChildren().addAll(layoutDoctorFields,buttonConfirm);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return textFieldDoctorName.getText();
    }
}
