package application;

import DAO.FactoryDAO;
import DAO.PatientDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import patient.OperationEntity;
import patient.PatientEntity;
import stages.ConfirmStage;
import stages.DoctorStage;
import stages.ErrorStage;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;


/**
 * Рус:
 * <p>
 * Контроллер главного окна приложения.
 * Отвечает за поведение программы, когда происходит какое-либо событие.
 * <p>
 * Eng:
 * <p>
 * Controller of application's main window.
 * Responsible for the behavior of the program when an event occurs.
 */

public class Controller {
    PatientEntity currentPatient = null;
    boolean isLoadedFromBase = false;
    @FXML
    private TextField textFieldSearch;
    @FXML
    private TextField textFieldNumber;
    @FXML
    private DatePicker datePickerDocument;
    @FXML
    private TextField textFieldFullname;
    @FXML
    private TextField textFieldAge;
    @FXML
    private ChoiceBox<String> choiceBoxAnamnes;
    @FXML
    private DatePicker datePickerBirth;
    @FXML
    private TextField textFieldMass;
    @FXML
    private ChoiceBox<String> choiceBoxPosition;
    @FXML
    private TextField textFieldLenght;
    @FXML
    private TextField textFieldFrontBack;
    @FXML
    private TextField textFieldCross;
    @FXML
    private ChoiceBox<String> choiceBoxState;
    @FXML
    private ChoiceBox<String> choiceBoxContours;
    @FXML
    private ChoiceBox<String> choiceBoxMiometrics;
    @FXML
    private TextField textFieldMiometrics;
    @FXML
    private ChoiceBox<String> choiceBoxEcho;
    @FXML
    private TextField textFieldEcho;
    @FXML
    private ChoiceBox<String> choiceBoxCavity;
    @FXML
    private TextField textFieldCavity;
    @FXML
    private ChoiceBox<String> choiceBoxContents;
    @FXML
    private TextField textFieldContent;

    @FXML
    private ChoiceBox<String> choiceBoxConclusion;
    @FXML
    private TextField textFieldConclusion;
    @FXML
    private ChoiceBox<String> choiceBoxStitches;
    @FXML
    private TextField textFieldStitches;
    @FXML
    private ChoiceBox<String> choiceBoxHematom;
    @FXML
    private TextField textFieldHematom;
    @FXML
    private ChoiceBox<String> choiceBoxVeins;
    @FXML
    private TextField textFieldVeins;
    @FXML
    private ChoiceBox<String> choiceBoxFluid;
    @FXML
    private TextField textFieldFluid;
    @FXML
    private ChoiceBox<String> choiceBoxAlien;

    @FXML
    private Accordion accordionOperation;


    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<PatientEntity,Integer> columnID;
    @FXML
    private TableColumn<PatientEntity,Date> columnDate;
    @FXML
    private TableColumn<PatientEntity,String> columnSecondname;
    @FXML
    private TableColumn<PatientEntity,String> columnFirstname;
    @FXML
    private TableColumn<PatientEntity,String> columnThirdname;
    @FXML
    private RadioButton radioBirth;
    @FXML
    private RadioButton radioOperation;
    @FXML
    private Label labelDateBirthOrOperation;
    @FXML
    private Label labelDoctor;
    @FXML
    private Button buttonSave;


    /**
     * Рус:
     * <p>
     * Позволяет сменить имя текущего доктора.
     * Вызывает {@link DoctorStage} дочернее окно.
     * <p>
     * Eng:
     * <p>
     * Allows change the name of current doctor.
     * Call {@link DoctorStage} child window.
     */
    @FXML
    private void changeDoctor(){
        try {
            this.labelDoctor.setText(DoctorStage.display());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Рус:
     * Ищет пациетов в базе данных согласно содержащийся информации в поле
     * {@link #textFieldSearch} и выводит результат на экран.
     * <p>
     * Eng:
     * <p>
     * Looks for patients in the database, according to the information contained
     * in the {@link #textFieldSearch} field and displays the result on the screen.
     */
    @FXML
    private void search() {
        if (textFieldSearch.getText().length() > 0) {
            if (textFieldSearch.getText().matches("\\d*")) {
                try {

                   Collection result = FactoryDAO.getInstance().getPatientDAO().getAllPatients(Integer.parseInt(textFieldSearch.getText()));
                    fillTableView((List<PatientEntity>) result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    StringTokenizer tmp = new StringTokenizer(textFieldSearch.getText());
                    String firstname = "";
                    String secondname = "";
                    String thirdname = "";
                    if(tmp.hasMoreTokens()) secondname = tmp.nextToken();
                    if(tmp.hasMoreTokens()) firstname = tmp.nextToken();
                    if(tmp.hasMoreTokens()) thirdname = tmp.nextToken();
                    Collection result =  FactoryDAO.getInstance().getPatientDAO().getAllPatients( secondname, firstname, thirdname);
                    fillTableView((List<PatientEntity>) result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            fillTableView(null);
        }
    }

    /**
     * Рус:
     * <p>
     * Загрузка данных пациента, выбранного из таблицы {@link #tableView}.
     * Помещает всю информацию о пациенте в соответствующие поля графического интерфейса.
     * <p>
     * Eng:
     * <p>
     * Loading of patient's data, chosen from the table {@link #tableView}.
     * Initializes fields of GUI with field of the {@link PatientEntity} object.
     */
    @FXML
    private void getSelectedPatient(){
        try {
            boolean canContinue = true;
            if(textFieldNumber.getText().length()>0) {
               canContinue = ConfirmStage.display("Загрузка пициентки", "Вы уверенны?\nВсе поля будут очищенны!");
            }
            if(canContinue) {
                cleanFields();

                PatientEntity patient = (PatientEntity) this.tableView.getSelectionModel().getSelectedItem();
                this.currentPatient = patient;
                this.isLoadedFromBase = true;
                //OperationEntity operation = FactoryDAO.getInstance().getOperationDAO().getOperation(patient.getId());
                if (patient.getOperationByOperation() == null) setBirthPeriod();
                else {
                    setOperationPeriod();
                    choiceBoxStitches.setValue(patient.getOperationByOperation().getStitches());
                    textFieldStitches.setText(patient.getOperationByOperation().getStitchesAdd());
                    textFieldHematom.setText(patient.getOperationByOperation().getHematomAdd());
                    choiceBoxHematom.setValue(patient.getOperationByOperation().getHematom());
                    choiceBoxVeins.setValue(patient.getOperationByOperation().getVeins());
                    textFieldVeins.setText(patient.getOperationByOperation().getVeinsAdd());
                    choiceBoxFluid.setValue(patient.getOperationByOperation().getFluid());
                    textFieldFluid.setText(patient.getOperationByOperation().getFluidAdd());
                    choiceBoxAlien.setValue(patient.getOperationByOperation().getAlien());
                }
                buttonSave.setText("Обновить");
                textFieldNumber.setText(String.valueOf(patient.getId()));
                datePickerDocument.setValue(patient.getDateDoc().toLocalDate());
                textFieldFullname.setText(patient.getSecondname() + " " + patient.getFirstname() + " " + patient.getThirdname());
                textFieldAge.setText(String.valueOf(patient.getAge()));
                choiceBoxAnamnes.setValue(patient.getAnamnes());
                datePickerBirth.setValue(patient.getDateParturion().toLocalDate());
                textFieldMass.setText(String.valueOf(patient.getMass()));
                choiceBoxPosition.setValue(patient.getUterusPosition());
                textFieldLenght.setText(String.valueOf(patient.getLenght()));
                textFieldFrontBack.setText(String.valueOf(patient.getFrontBack()));
                textFieldCross.setText(String.valueOf(patient.getTransverse()));
                choiceBoxState.setValue(patient.getState());
                choiceBoxContours.setValue(patient.getContour());
                choiceBoxMiometrics.setValue(patient.getMiometrics());
                textFieldMiometrics.setText(patient.getMiometricsAdd());
                choiceBoxEcho.setValue(patient.getEcho());
                textFieldEcho.setText(patient.getEchoAdd());
                choiceBoxCavity.setValue(patient.getCavity());
                textFieldCavity.setText(patient.getCavityAdd());
                choiceBoxContents.setValue(patient.getContent());
                choiceBoxConclusion.setValue(patient.getConclusion());
                textFieldConclusion.setText(patient.getConclusion());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Рус:
     * <p>
     * Создает объект класса {@link PatientEntity} и заполняет поля объекта информацией, взятой
     * из полей графического интерфейса.
     * <p>
     * Eng:
     * <p>
     * Crates the new object of {@link PatientEntity} class and sets its fields with
     * information taken from fields of GUI.
     * @return new {@link PatientEntity} object
     */
    private PatientEntity createPatientFromFields() {
        PatientEntity patient = null;
        if (isAllFieldsCorrect()) {
            patient = new PatientEntity();
            OperationEntity operation = new OperationEntity();
            patient.setId(Integer.valueOf(textFieldNumber.getText()));
            patient.setDateDoc(Date.valueOf(datePickerDocument.getValue()));
            StringTokenizer fullname = new StringTokenizer(textFieldFullname.getText());
            patient.setSecondname(fullname.nextToken());
            patient.setFirstname(fullname.nextToken());
            patient.setThirdname(fullname.nextToken());
            patient.setAge(Integer.parseInt(textFieldAge.getText()));
            patient.setAnamnes(choiceBoxAnamnes.getValue());
            patient.setDateParturion(Date.valueOf(datePickerBirth.getValue()));
            patient.setMass(Integer.valueOf(textFieldMass.getText()));
            patient.setLenght(Integer.parseInt(textFieldLenght.getText()));
            patient.setFrontBack(Integer.parseInt(textFieldFrontBack.getText()));
            patient.setTransverse(Integer.parseInt(textFieldCross.getText()));
            patient.setContour(choiceBoxContours.getValue());
            patient.setState(choiceBoxState.getValue());
            patient.setUterusPosition(choiceBoxPosition.getValue());
            patient.setMiometrics(choiceBoxMiometrics.getValue());
            patient.setMiometricsAdd(textFieldMiometrics.getText());
            patient.setEcho(choiceBoxEcho.getValue());
            patient.setEchoAdd(textFieldEcho.getText());
            patient.setCavity(choiceBoxCavity.getValue());
            patient.setCavityAdd(textFieldCavity.getText());
            patient.setContent(choiceBoxContents.getValue());
            patient.setContentAdd(textFieldContent.getText());
            patient.setDoctor(labelDoctor.getText());
            patient.setConclusion(choiceBoxConclusion.getValue());
            patient.setConclusionAdd(textFieldConclusion.getText());
            patient.setOperationByOperation(null);
            if (radioOperation.isSelected()) {

                operation.setIdPatient(Integer.parseInt(textFieldNumber.getText()));
                operation.setStitches(choiceBoxStitches.getValue());
                operation.setStitchesAdd(textFieldStitches.getText());
                operation.setHematom(choiceBoxHematom.getValue());
                operation.setHematomAdd(textFieldHematom.getText());
                operation.setVeins(choiceBoxVeins.getValue());
                operation.setVeinsAdd(textFieldVeins.getText());
                operation.setFluid(choiceBoxFluid.getValue());
                operation.setFluidAdd(textFieldFluid.getText());
                operation.setAlien(choiceBoxAlien.getValue());
                patient.setOperationByOperation(operation);
            }
        }
        return patient;
    }

    /**
     * Рус:
     * <p>
     * Создает новый объект класса {@link PatientEntity} при помощи метода {@link #createPatientFromFields()}
     * и отправляет его в базу данных
     * <p>
     * Eng:
     * <p>
     * Crates the new object of {@link PatientEntity} class with help of {@link #createPatientFromFields()}
     * and save it in the database
     */
    @FXML
    private void savePatient(){
        PatientEntity patient = this.createPatientFromFields();
        this.currentPatient = patient;
        if(patient != null) {
            OperationEntity operation = patient.getOperationByOperation();
            try {
                if (buttonSave.getText().equals("Сохранить")) {
                    if (operation != null) {
                        FactoryDAO.getInstance().getOperationDAO().addOperation(operation);
                    }
                    FactoryDAO.getInstance().getPatientDAO().addPatient(patient);
                } else if (buttonSave.getText().equals("Обновить")) {
                    if (radioOperation.isSelected()) {
                        if (FactoryDAO.getInstance().getOperationDAO().getOperation(Integer.parseInt(textFieldNumber.getText())) != null) {
                            FactoryDAO.getInstance().getOperationDAO().updateOperation(operation);
                        } else {
                            FactoryDAO.getInstance().getOperationDAO().addOperation(operation);
                        }
                    }
                    FactoryDAO.getInstance().getPatientDAO().updatePatient(patient);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            fillTableView(null);
        }
    }


    /**
     * Рус:
     * <p>
     * Валидация полей
     * <p>
     * Eng:
     * <p>
     * Fields validation
     * @return result of fields' checking
     */
    private boolean isAllFieldsCorrect(){
        if(textFieldNumber.getText().matches("\\w")){
            ErrorStage.display("Поле 'Номер' должно содержать только цифры!");
         return false;
        }
        StringTokenizer fullname = new StringTokenizer(textFieldFullname.getText());
        fullname.countTokens();
        return true;
    }

    /**
     * Рус:
     * <p>
     * Подготавливает логику программы и графический интерфейс к вводу нвого пользователя
     * <p>
     * Eng:
     * <p>
     * Prepares logic of program and GUI for the new patient
     */
    @FXML
    private void createNewPatient(){
        try {
            if(textFieldNumber.getText().length()>0) {
                if (ConfirmStage.display("Новая пициентка", "Вы уверенны?\nВсе поля будут очищенны!")) {
                    cleanFields();
                    this.currentPatient = null;
                    this.isLoadedFromBase = false;
                }
            }
            else {
                cleanFields();
                this.currentPatient = null;
                this.isLoadedFromBase = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Рус:
     * <p>
     * Сеттер текущего доктора.
     * <p>
     * Eng:
     * <p>
     * Setter of current doctor
     * @param doctor the name of the working doctor
     */
    public void setDoctor(String doctor){
        this.labelDoctor.setText(doctor);
    }


    /**
     * Рус:
     * <p>
     * Заполняет {@link #tableView} списком объектов класса {@link PatientEntity};
     * <p>
     * Eng:
     * <p>
     * Fills {@link #tableView} with list of {@link PatientEntity} objects.
     * @param patientsList a list of patients.
     */
    private synchronized void fillTableView(List <PatientEntity> patientsList){
        Thread threadConnectingToDB = new Thread(() -> {
            try {
                List<PatientEntity> patients = patientsList;
                if(patients == null) {
                    PatientDAO patientDAO = FactoryDAO.getInstance().getPatientDAO();
                    if (patientDAO.getAllPatients() instanceof List) {
                        patients = (List) patientDAO.getAllPatients();
                    } else {
                        patients = new ArrayList(patientDAO.getAllPatients());
                    }
                }
                tableView.setItems(FXCollections.observableList(patients));
            } catch (Exception e) {
                try {
                    ErrorStage.display("Произошла ошибка при подключении к базе данных");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        });
        threadConnectingToDB.start();
        threadConnectingToDB.interrupt();
    }

    /**
     * Рус:
     * <p>
     * Настраивает {@link #tableView}:
     * <ul>
     *     <li>Устанавливает наименование колонок;</li>
     *     <li>Переводит дату под русский формат дд-мм-гггг.</li>
     * </ul>
     * <p>
     * Eng:
     * <p>
     * Configurate {@link #tableView}:
     * <ul>
     *     <li>Sets up the names of the columns;</li>
     *     <li>Sets up russian format of date dd-mm-yyyy.</li>
     * </ul>
     */

    private void configureTableView(){
        columnID.setCellValueFactory(new PropertyValueFactory<PatientEntity, Integer>("id"));
        columnDate.setCellFactory(column -> {
            TableCell<PatientEntity, Date> cell = new TableCell<PatientEntity, Date>() {
                private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : format.format(item));
                }
            };
            return cell;
        });
        columnDate.setCellValueFactory(new PropertyValueFactory<PatientEntity, Date>("dateDoc"));
        columnSecondname.setCellValueFactory(new PropertyValueFactory<PatientEntity, String>("secondname"));
        columnFirstname.setCellValueFactory(new PropertyValueFactory<PatientEntity, String>("firstname"));
        columnThirdname.setCellValueFactory(new PropertyValueFactory<PatientEntity, String>("thirdname"));

    }

    /**
     * Рус:
     * <p>
     * Отправляет информацию о выбранном пациенте на печать.
     * <p>
     * Eng:
     * <p>
     * Sends information about the selected patient to the printer.
     */

    @FXML
    void sendToPrinter(){
        if(this.currentPatient != null) {
            new PrinterPage().print(this.currentPatient);
        } else {
            ErrorStage.display("Сначала сохраните пациентку,\nзатем повторно нажмите печать");
        }
    }

    /**
     * Рус:
     * <p>
     * Настраивает компоненты программы и графического интерфейса пользователя.
     * Вызывается единожды из класса {@link Main}
     * <p>
     * Eng:
     * <p>
     * Configures components of the program and GUI.
     * Called once by {@link Main} class
     */

    public void loadComponents(){
        this.fillChoiceBoxes();
        this.cleanFields();
        this.textFieldSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            search();
        });
        this.configureTableView();
        this.fillTableView(null);
    }

    /**
     * Рус:
     * <p>
     * Наполняет поля выбора содержимым.
     * <p>
     * Eng:
     * <p>
     * Initializes ChoiseBoxes' fields with specified values.
     */
    private void fillChoiceBoxes(){
        choiceBoxAnamnes.getItems().addAll("Первородящая", "Повторнородящая"," ");
        choiceBoxPosition.getItems().addAll("Правильное","Смещена вправо","Смещена влево");
        choiceBoxState.getItems().addAll("Норма","Субинволюция");
        choiceBoxContours.getItems().addAll("Ровные","Неровные");
        choiceBoxMiometrics.getItems().addAll("Однородный","Неоднородный");
        choiceBoxEcho.getItems().addAll("Однородное","Неоднородное");
        choiceBoxCavity.getItems().addAll("Сомкнута","Расширена");
        choiceBoxContents.getItems().addAll("Отсутсвтует","Сгустки крови", "Остатки плацентарной ткани", "Обрывки оболочек", "Жидкая кровь");
        choiceBoxConclusion.getItems().addAll("Послеродовый период", "гематометра", "сгустки крови", "субинволюция матки");
        choiceBoxStitches.getItems().addAll("без инфильтрации", "инфильтрация");
        choiceBoxVeins.getItems().addAll("не изменены", "не визуализируются", "изменены");
        choiceBoxHematom.getItems().addAll("не выявлена", "выявлена");
        choiceBoxFluid.getItems().addAll("не выявлена", "выявлена");
        choiceBoxAlien.getItems().addAll("не выявлено", "выявлено");
    }

    /**
     * Рус:
     * <p>
     * Меняет текущие значения полей на занчения по умолчанию.
     * <p>
     * Eng:
     * <p>
     * Replace the current values with the default values.
     */
    private void cleanFields(){
        choiceBoxAnamnes.getSelectionModel().selectLast();
        choiceBoxPosition.getSelectionModel().selectFirst();
        choiceBoxState.getSelectionModel().selectFirst();
        choiceBoxContours.getSelectionModel().selectFirst();
        choiceBoxMiometrics.getSelectionModel().selectFirst();
        choiceBoxEcho.getSelectionModel().selectFirst();
        choiceBoxCavity.getSelectionModel().selectFirst();
        choiceBoxContents.getSelectionModel().selectFirst();
        choiceBoxConclusion.getSelectionModel().selectFirst();
        choiceBoxStitches.getSelectionModel().selectFirst();
        choiceBoxHematom.getSelectionModel().selectFirst();
        choiceBoxFluid.getSelectionModel().selectFirst();
        choiceBoxAlien.getSelectionModel().selectFirst();
        choiceBoxVeins.getSelectionModel().selectFirst();

        textFieldContent.setText("");
        textFieldNumber.setText("");
        textFieldFullname.setText("");
        textFieldAge.setText("");
        textFieldContent.setText("");
        textFieldMass.setText("");
        textFieldLenght.setText("");
        textFieldFrontBack.setText("");
        textFieldCross.setText("");
        textFieldMiometrics.setText("");
        textFieldEcho.setText("");
        textFieldCavity.setText("");
        textFieldConclusion.setText("");
        textFieldStitches.setText("");
        textFieldHematom.setText("");
        textFieldFluid.setText("");
        textFieldVeins.setText("");

        datePickerBirth.setValue(null);
        datePickerDocument.setValue(LocalDate.now());
        setBirthPeriod();
        buttonSave.setText("Сохранить");
    }

    /**
     * Рус:
     * <p>
     * Меняет логику программы для работы с послеродовым пациентом.
     * <p>
     * Eng:
     * <p>
     * Changes the logic of the program to work with a postpartum patient.
     */
    @FXML
    void setBirthPeriod(){
        radioOperation.setSelected(false);
        labelDateBirthOrOperation.setText("Дата родов");
        radioBirth.setSelected(true);
        accordionOperation.getPanes().get(0).setExpanded(false);
        accordionOperation.setVisible(false);
    }

    /**
     * Рус:
     * <p>
     * Меняет логику программы для работы с пациентом после операции.
     * <p>
     * Eng:
     * <p>
     * Changes the logic of the program to work with a operated patient.
     */
    @FXML
    void setOperationPeriod(){
        radioOperation.setSelected(true);
        labelDateBirthOrOperation.setText("Дата операции");
        radioBirth.setSelected(false);
        accordionOperation.setVisible(true);
        accordionOperation.getPanes().get(0).setExpanded(true);
    }

}
