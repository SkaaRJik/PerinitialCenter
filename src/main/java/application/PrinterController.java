package application;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import patient.PatientEntity;

import java.text.SimpleDateFormat;

/**
 * Created by SkaaRJ on 20.11.2017.
 */
public class PrinterController {
    @FXML
    Label labelNumber;
    @FXML
    Label labelDate;
    @FXML
    Label labelResearch;
    @FXML
    Label labelName;
    @FXML
    Label labelAge;
    @FXML
    Label labelAnamnes;
    @FXML
    Label labelDateBirth;
    @FXML
    Label labelMass;
    @FXML
    Label labelPos;
    @FXML
    Label labelLenght;
    @FXML
    Label labelFrontBack;
    @FXML
    Label labelCross;
    @FXML
    Label labelState;
    @FXML
    Label labelContour;
    @FXML
    Label labelMiometrics;
    @FXML
    Label labelEcho;
    @FXML
    Label labelCavity;
    @FXML
    Label labelContains;
    @FXML
    Label labelStitches;
    @FXML
    Label labelHematom;
    @FXML
    Label labelVeins;
    @FXML
    Label labelFluid;
    @FXML
    Label labelAlien;
    @FXML
    Label labelConclusion;
    @FXML
    Label labelDoctor;
    @FXML
    Accordion accordionOperation;
    @FXML
    VBox operationBox;

    public void setPatient(PatientEntity patient) {
        SimpleDateFormat newFormat = new SimpleDateFormat("dd.MM.yyyy");
        if(patient.getOperationByOperation() !=null){
            labelResearch.setText(labelResearch.getText() + "после кесарева сечения");

            labelDateBirth.setText(labelDateBirth.getText() + "операции кесарева сечения: "
                    + newFormat.format(patient.getDateParturion()));



            labelStitches.setText(labelStitches.getText() + " " + patient.getOperationByOperation().getStitches()
                   + " " + patient.getOperationByOperation().getStitchesAdd());

            labelHematom.setText(labelHematom.getText() + " " + patient.getOperationByOperation().getHematom()
                    + " " + patient.getOperationByOperation().getHematomAdd());

            labelVeins.setText(labelVeins.getText() + " " + patient.getOperationByOperation().getVeins()
                    + " " + patient.getOperationByOperation().getVeinsAdd());

            labelFluid.setText(labelFluid.getText() + " " + patient.getOperationByOperation().getFluid()
                    + " " + patient.getOperationByOperation().getFluidAdd());

            labelAlien.setText(labelAlien.getText() + " " + patient.getOperationByOperation().getAlien());
        }
        else {
            labelResearch.setText(labelResearch.getText() + "в послеродовом периоде");
            labelDateBirth.setText(labelDateBirth.getText() + "родов: "
                    + newFormat.format(patient.getDateParturion()));
            operationBox.setVisible(false);
        }
        labelNumber.setText(labelNumber.getText() + patient.getId());
        labelDate.setText(labelDate.getText() + newFormat.format(patient.getDateDoc()));
        labelName.setText(labelName.getText() + patient.getSecondname()
                + " " + patient.getFirstname() + " " + patient.getThirdname());
        labelAge.setText(labelAge.getText() + patient.getAge());
        if(patient.getAnamnes().length()>0) {
            labelAnamnes.setText(labelAnamnes.getText() + patient.getAnamnes());
        } else {
            labelAnamnes.setVisible(false);
        }
        labelMass.setText(labelMass.getText() + patient.getMass());
        labelPos.setText(labelPos.getText() + patient.getUterusPosition());
        labelLenght.setText(labelLenght.getText() + patient.getLenght() + " мм.,");
        labelFrontBack.setText(labelFrontBack.getText() + patient.getFrontBack() + " мм.,");
        labelCross.setText(labelCross.getText() + patient.getTransverse()+ " мм.,");
        labelState.setText(labelState.getText() + patient.getState() +" /");
        labelContour.setText(labelContour.getText() + patient.getContour());
        labelMiometrics.setText(labelMiometrics.getText() + patient.getMiometrics() + " " + patient.getMiometricsAdd());
        labelEcho.setText(labelEcho.getText() + patient.getEcho() + " " + patient.getEchoAdd());
        labelCavity.setText(labelCavity.getText() + patient.getCavity() + " " + patient.getCavityAdd());
        labelContains.setText(labelContains.getText() + patient.getContent() + " " + patient.getContentAdd());
        labelConclusion.setText(labelConclusion.getText() + patient.getConclusion() + " " + patient.getConclusionAdd());
        labelDoctor.setText(labelDoctor.getText() + patient.getDoctor());

    }
}
