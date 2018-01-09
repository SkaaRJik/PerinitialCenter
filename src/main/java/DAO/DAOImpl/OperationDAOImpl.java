package DAO.DAOImpl;

import DAO.OperationDAO;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import patient.OperationEntity;
import util.HibernateUtil;

/**
 * Рус:
 * <p>
 * Реализация интерфейса {@link OperationDAO}
 * <p>
 * Eng:
 * <p>
 * Implementation of {@link OperationDAO}
 */
public class OperationDAOImpl implements OperationDAO {

    private static final Logger LOGGER = Logger.getLogger(OperationDAOImpl.class.getSimpleName());

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
    public OperationEntity getOperation(int id) throws Exception {
        Session session = null;
        OperationEntity operationEntity = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            operationEntity = (OperationEntity) session.load(OperationEntity.class, id);
        } catch (Exception e){
            LOGGER.info("OperationDAOImpl.getOperation(int id)");
            LOGGER.error(e.getMessage(),e);
        } finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }

        return operationEntity;
    }

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
    public void addOperation(OperationEntity operation) throws Exception {

        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(operation);
            session.getTransaction().commit();
        } catch (Exception e){
            LOGGER.info("OperationDAOImpl.addOperation(OperationEntity operation)");
            LOGGER.info(operation.toString());
            LOGGER.error(e.getMessage(),e);
        }
        finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }

    }

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
    public void updateOperation(OperationEntity operation) throws Exception {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(operation);
            session.getTransaction().commit();
        } catch (Exception e){
            LOGGER.info("OperationDAOImpl.updateOperation(OperationEntity operation)");
            LOGGER.info(operation.toString());
            LOGGER.error(e.getMessage(),e);
        } finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
    }

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
    public void deleteOperation(OperationEntity operation) throws Exception {
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(operation);
            session.getTransaction().commit();
        } catch (Exception e){
            LOGGER.info("OperationDAOImpl.deleteOperation(OperationEntity operation)");
            LOGGER.info(operation.toString());
            LOGGER.error(e.getMessage(),e);
        } finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
    }
}
