package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import stages.DoctorStage;
import stages.StageFactory;
import util.HibernateUtil;

/**
 * Eng:
 * Contains the start point of the program.
 * Extends the class of JavaFX {@link Application}.
 *
 * Рус:
 * Содержит точку входа в программу.
 * Наследует класс JavaFX {@link Application}.
 */

public class Main extends Application {
    /**
     * Eng:
     * The object is storing the view of GUI.
     *
     * Рус:
     * Объект, хранящий внешний вид графического интерфейса пользователя.
     */
    private FXMLLoader loader;


    /**
     * Eng:
     * Loads the view of GUI from path: "/view/sample.fxml",
     * defines the behavior of the program, when you press the system buttons,
     * and show the GUI for user.
     *
     * Рус:
     * Загружает графический интерфейс из следующего пути: "/view/sample.fxml",
     * определяет поведение программы при нажатии системных кнопок и показывает
     * графический интерфейс пользователю
     */
    @Override
    public void start(final Stage primaryStage) throws Exception{
        loader = new FXMLLoader(getClass().getResource("/view/sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Республиканский перинатальный центр");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            public void handle(WindowEvent event) {
                primaryStage.close();
                if(HibernateUtil.getSessionFactory()!=null)
                HibernateUtil.getSessionFactory().close();
                System.exit(0);
            }
        });
        Controller controller = loader.getController();
        controller.loadComponents();
        controller.setDoctor(DoctorStage.display());
        primaryStage.show();
    }

    /**
     * Eng:
     * The start point of the program.
     * Calls method @see start implicitly.
     * @param args - program arguments.
     *
     * Рус:
     * Точка входа в программу.
     * Вызывает метод @see start неявно
     * @param args - аргументы программы.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
