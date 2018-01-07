package DAO;

import patient.PatientEntity;

import java.util.Collection;

/**
 * Data access object for
 *
 */
public interface PatientDAO {
    Collection getAllPatients() throws Exception;
    Collection getAllPatients(int id) throws Exception;
    Collection getAllPatients(String secondname, String firstname, String thirdname) throws Exception;
    PatientEntity getPatient(int id) throws Exception;
    void addPatient(PatientEntity patient) throws Exception;
    void updatePatient(PatientEntity patient) throws Exception;
    void deletePatient(PatientEntity patient) throws Exception;

}
