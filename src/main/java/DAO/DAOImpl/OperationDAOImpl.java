package DAO.DAOImpl;

import DAO.OperationDAO;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import patient.OperationEntity;
import util.HibernateUtil;

/**
 * Created by SkaaRJ on 02.11.2017.
 */
public class OperationDAOImpl implements OperationDAO {

    private static final Logger LOGGER = Logger.getLogger(OperationDAOImpl.class.getSimpleName());

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
