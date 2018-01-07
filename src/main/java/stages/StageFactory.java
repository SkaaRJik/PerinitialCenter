package stages;

/**
 * Created by SkaaRJ on 04.11.2017.
 */
public class StageFactory {
    static private StageFactory instance = null;
    static private DoctorStage doctorStage = null;

    public static StageFactory getInstance() {
        if(instance == null){
            instance = new StageFactory();
        }
        return instance;
    }

    public static DoctorStage getDoctorStage() {
        if(doctorStage == null){
            doctorStage = new DoctorStage();
        }
        return doctorStage;
    }
}
