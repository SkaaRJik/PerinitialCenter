package DAO;

import patient.OperationEntity;

/**
 * Created by SkaaRJ on 02.11.2017.
 */
public interface OperationDAO {
    OperationEntity getOperation(int id) throws Exception;
    void addOperation(OperationEntity operation) throws Exception;
    void updateOperation(OperationEntity operation) throws Exception;
    void deleteOperation(OperationEntity operation) throws Exception;
}
