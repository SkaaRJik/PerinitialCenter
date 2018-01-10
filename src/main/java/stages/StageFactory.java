package stages;

/**
 * Фабрика модальных окон. Сомневаюсь, нужна ли она вообще.
 */
public class StageFactory {
    static private StageFactory instance = null;
    static private DoctorStage doctorStage = null;
    static private ErrorStage errorStage = null;
    static private ConfirmStage confirmStage = null;

    public static StageFactory getInstance() {
        if(instance == null){
            instance = new StageFactory();
        }
        return instance;
    }

    public DoctorStage getDoctorStage() {
        if(doctorStage == null){
            doctorStage = new DoctorStage();
        }
        return doctorStage;
    }

    public static ErrorStage getErrorStage() {
        if(errorStage == null){
            errorStage = new ErrorStage();
        }
        return errorStage;
    }

    public static ConfirmStage getConfirmStage() {
        if(confirmStage == null){
            confirmStage = new ConfirmStage();
        }
        return confirmStage;
    }
}
