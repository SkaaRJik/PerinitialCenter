package model.DAO;

import model.patient.PatientEntity;

import java.util.Collection;

/**
 * Рус:
 * <p>
 * Интерфейс получения доступа к таблице 'patient', находящийся в базе данных.
 * <p>
 * Eng:
 * <p>
 * Data access object to 'patient' table
 */
public interface PatientDAO {

    /**
     * Рус:
     * <p>
     * Получает список всех пациентов, хранящихся в базе данных
     * <p>
     * Eng:
     * <p>
     * Gets the list of all patients, which are stored in the database
     * @return {@link Collection} of {@link PatientEntity}
     * @throws Exception SQLException
     */
    Collection getAllPatients() throws Exception;

    /**
     * Рус:
     * <p>
     * Поиск пациентов со схожим id
     * <p>
     * Eng:
     * <p>
     * Searches patients with similar id
     * @param id identifical number of patient
     * @return {@link Collection} of {@link PatientEntity}
     * @throws Exception SQLException
     */
    Collection getAllPatients(int id) throws Exception;

    /**
     * Рус:
     * <p>
     * Поиск пациента по фамилии, имени, отчеству
     * <p>
     * Eng:
     * <p>
     * Searches patients by full name
     * @param secondname surname
     * @param firstname name
     * @param thirdname patronymic
     * @return {@link Collection} of {@link PatientEntity}
     * @throws Exception SQLException
     */
    Collection getAllPatients(String secondname, String firstname, String thirdname) throws Exception;

    /**
     * Рус:
     * <p>
     * Поиск пациента по id
     * <p>
     * Eng:
     * <p>
     * Searches patient by id
     * @param id identifical number of patient
     * @return {@link PatientEntity}
     * @throws Exception SQL Exception
     */
    PatientEntity getPatient(int id) throws Exception;

    /**
     * Рус:
     * <p>
     * Добавляет пациента в базу данных.
     * <p>
     * Eng:
     * <p>
     * Add patient into the database.
     * @param patient
     * @throws Exception SQL Exception
     */
    void addPatient(PatientEntity patient) throws Exception;

    /**
     * Рус:
     * <p>
     * Измененяет данные пациента в базе данных
     * <p>
     * Eng:
     * <p>
     * Updates patient's information
     * @param patient updated patient
     * @throws Exception SQLException
     */
    void updatePatient(PatientEntity patient) throws Exception;

    /**
     * Рус:
     * <p>
     * Удаление пациента из базы данных
     * <p>
     * Eng:
     * <p>
     * Delete the pacient from the database
     * @param patient - patient should be deleted
     * @throws Exception SQL Exception SQLException
     */
    void deletePatient(PatientEntity patient) throws Exception;

}
