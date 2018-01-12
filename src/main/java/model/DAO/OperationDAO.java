package model.DAO;

import model.patient.OperationEntity;

/**
 * Рус:
 * <p>
 * Интерфейс получения доступа к таблице 'operation', находящийся в базе данных.
 * <p>
 * Eng:
 * <p>
 * Data access object to 'operation' table
 */
public interface OperationDAO {

    /**
     * Рус:
     * <p>
     * Возвращает запись о пациенте из базы данных.
     * <p>
     * Eng:
     * <p>
     * Returns information about patient from the database.
     * @param id
     * @return {@link OperationEntity}
     * @throws Exception SQLException
     */
    OperationEntity getOperation(int id) throws Exception;

    /**
     * Рус:
     * <p>
     * Добавляет запись о хирургическом вмешательстве в базу данных.
     * <p>
     * Eng:
     * <p>
     * Add record about operation into the database.
     * @param operation
     * @throws Exception SQLException
     */
    void addOperation(OperationEntity operation) throws Exception;

    /**
     * Рус:
     * <p>
     * Обновляет запись о хирургическом вмешательстве в базе данных.
     * <p>
     * Eng:
     * <p>
     * Updates record about operation into the database.
     * @param operation
     * @throws Exception SQLException
     */
    void updateOperation(OperationEntity operation) throws Exception;

    /**
     * Рус:
     * <p>
     * Удаляет запись о хирургическом вмешательстве в базе данных.
     * <p>
     * Eng:
     * <p>
     * Deletes record about operation into the database.
     * @param operation
     * @throws Exception SQLException
     */
    void deleteOperation(OperationEntity operation) throws Exception;
}
