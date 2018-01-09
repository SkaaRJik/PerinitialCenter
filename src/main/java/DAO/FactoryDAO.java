package DAO;

import DAO.DAOImpl.OperationDAOImpl;
import DAO.DAOImpl.PatientDAOImpl;

/**
 * Рус:
 * <p>
 * FactoryDAO используется для получения экземпляра {@link OperationDAO} или {@link PatientDAO}
 * <p>
 * Eng:
 * <p>
 * FactoryDAO is used to get instance of {@link OperationDAO} or {@link PatientDAO}
 */
public class FactoryDAO {
    private static OperationDAO operationDAO = null;
    private static PatientDAO patientDAO = null;
    private static FactoryDAO instance = null;

    /**
     * Рус:
     * <p>
     * Возвращает экземпляр {@link FactoryDAO}. Создает его, если он отсутствует.
     * Через этот экземпляр получают экземпляр {@link OperationDAO} или {@link PatientDAO}
     * <p>
     * Eng:
     * <p>
     * Returns instance of {@link FactoryDAO}. Create it if not exists.
     * This instance allows to get {@link OperationDAO} or {@link PatientDAO}
     * @return instance of {@link FactoryDAO}
     */
    public static synchronized FactoryDAO getInstance() {
        if(instance == null){
            instance = new FactoryDAO();
        }
        return instance;
    }

    /**
     * Рус:
     * <p>
     * Возвращает экземпляр {@link OperationDAO}. Создает его, если он отсутствует.
     * <p>
     * Пример использования:
     * <ul>
     * <pre>
     * ...
     * FactoryDAO.getInstance().getPatientDAO().addOperation(operation);
     * ...
     * </pre>
     * </ul>
     * <p>
     * Eng:
     * <p>
     * Returns instance of {@link OperationDAO}. Create it if not exists
     * <p>
     * Typical usage is:
     * <ul>
     * <pre>
     * ...
     * FactoryDAO.getInstance().getPatientDAO().addOperation(operation);
     * ...
     * </pre>
     * </ul>
     * @return instance of {@link OperationDAO}
     */
    public OperationDAO getOperationDAO(){
        if(operationDAO == null){
            operationDAO = new OperationDAOImpl();
        }
        return  operationDAO;
    }

    /**
     * Рус:
     * <p>
     * Возвращает экземпляр {@link PatientDAO}. Создает его, если он отсутствует.
     * <p>
     * Пример использования:
     * <ul>
     * <pre>
     * ...
     * FactoryDAO.getInstance().getPatientDAO().addPatient(patient);
     * ...
     * </pre>
     * </ul>
     * <p>
     * Eng:
     * <p>
     * Returns instance of {@link PatientDAO}. Create it if not exists
     * <p>
     * Typical usage is:
     * <ul>
     * <pre>
     * ...
     * FactoryDAO.getInstance().getPatientDAO().addPatient(patient);
     * ...
     * </pre>
     * </ul>
     * @return instance of {@link PatientDAO}
     */
    public PatientDAO getPatientDAO(){
        if(patientDAO == null){
            patientDAO = new PatientDAOImpl();
        }
        return patientDAO;
    }

}
