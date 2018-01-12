package model.window;

import controller.MainController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.window.DoctorStage;
import model.util.HibernateUtil;

/**
 * Рус:
 * <p>
 * Содержит точку входа в программу.
 * Наследует класс JavaFX {@link Application}.
 * <p>
 * Eng:
 * <p>
 * Contains the start point of the program.
 * Extends the class of JavaFX {@link Application}.
 */

public class Main extends Application {


    /**
     * Рус:
     * <p>
     * Загружает графический интерфейс из следующего пути: "/view/sample.fxml",
     * определяет поведение программы при нажатии системных кнопок и показывает
     * графический интерфейс пользователю
     * <p>
     * Eng:
     * <p>
     * Loads the view of GUI from path: "/view/sample.fxml",
     * defines the behavior of the program, when you press the system buttons,
     * and show the GUI for user.
     */
    @Override
    public void start(final Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Республиканский перинатальный центр");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            public void handle(WindowEvent event) {
                primaryStage.close();
                HibernateUtil.closeSession();
                System.exit(0);
            }
        });
        MainController controller = loader.getController();
        controller.loadComponents();
        controller.setDoctor(DoctorStage.display());
        primaryStage.show();
    }

    /**
     * Рус:
     * <p>
     * Точка входа в программу.
     * Вызывает метод {@link #start(Stage)} неявно по средством {@link #launch(Class, String...)} метода.
     * <p>
     * Eng:
     * <p>
     * The start point of the program.
     * Calls method {@link #start(Stage)} with help of {@link #launch(String...)} method implicitly.
     * @param args - program arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
