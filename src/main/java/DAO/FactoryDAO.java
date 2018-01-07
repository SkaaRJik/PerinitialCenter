package DAO;

import DAO.DAOImpl.OperationDAOImpl;
import DAO.DAOImpl.PatientDAOImpl;

/**
 * Class
 */
public class FactoryDAO {
    private static OperationDAO operationDAO = null;
    private static PatientDAO patientDAO = null;
    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if(instance == null){
            instance = new FactoryDAO();
        }
        return instance;
    }

    public OperationDAO getOperationDAO(){
        if(operationDAO == null){
            operationDAO = new OperationDAOImpl();
        }
        return  operationDAO;
    }

    public PatientDAO getPatientDAO(){
        if(patientDAO == null){
            patientDAO = new PatientDAOImpl();
        }
        return patientDAO;
    }

}
