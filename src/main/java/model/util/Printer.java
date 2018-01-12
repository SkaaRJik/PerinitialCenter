package model.util;

import controller.PrinterController;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.patient.PatientEntity;

import java.io.IOException;

/**
 * Рус:
 * <p>
 * Класс для печати данных о пациенте
 * <p>
 * Eng:
 * <p>
 * Class for printing of patient's data
 */

public class Printer {


    /**
     * Рус:
     * <p>
     * Создает внешний вид страницы, которая будет распечатанна. Инициализирует текстовые
     * поля значениями атрубута объекта класса {@link PatientEntity}. Отправляет данные на печать.
     * <p>
     * Eng:
     * <p>
     * Creates the visual view of the printed page. Initialise text field with object's attributes of
     * {@link PatientEntity} class. Send the data to the printer.
     * @param patient - the patient's data to be printed
     */
    public void print(PatientEntity patient)
    {
        final Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/printer.fxml"));

        Parent root = null;
        try {
            root = loader.load();

            PrinterController printerController = loader.getController();
            // Set the Size of the VBox

            // Create the Scene
            Scene scene = new Scene(root);
            // Add the scene to the Stage
            stage.setScene(scene);
            // Set the title of the Stage
            printerController.setPatient(patient);

            // Display the Stage
            //stage.show();
            printSetup(root, stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Рус:
     * <p>
     * Вызывает системное окно настройки печати.
     * <p>
     * Eng:
     * <p>
     * Calls system window to print setup
     * @param node
     * @param owner
     */
    private void printSetup(Node node, Stage owner)
    {
        // Create the PrinterJob
        PrinterJob job = PrinterJob.createPrinterJob();

        if (job == null)
        {
            return;
        }

        // Show the print setup dialog
        boolean proceed = job.showPrintDialog(owner);

        if (proceed)
        {
            print(job, node);
        }
    }

    /**
     * Рус:
     * <p>
     * Контроллёр процесса печати
     * <p>
     * Eng:
     * <p>
     * Printing process' controller
     * @param job
     * @param node
     */
    private void  print(PrinterJob job, Node node)
    {
        // Print the node
        boolean printed = job.printPage(node);

        if (printed)
        {
            job.endJob();
        }
    }
}