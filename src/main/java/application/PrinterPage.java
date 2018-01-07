package application;

import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import patient.PatientEntity;

import java.io.IOException;

public class PrinterPage {


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
            stage.show();
            printSetup(root, stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private void  print(PrinterJob job, Node node)
    {
        // Set the Job Status Message
        // Print the node
        boolean printed = job.printPage(node);

        if (printed)
        {
            job.endJob();
        }
    }
}