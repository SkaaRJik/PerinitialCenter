package model.DAO.DAOImpl;

import model.DAO.PatientDAO;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import model.patient.PatientEntity;
import model.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Рус:
 * <p>
 * Реализация интерфейса {@link PatientDAO}
 * <p>
 * Eng:
 * <p>
 * Implementation of {@link PatientDAO}
 */
public class PatientDAOImpl implements PatientDAO {

    private static final Logger LOGGER = Logger.getLogger(PatientDAOImpl.class.getSimpleName());


    /**
     * Рус:
     * <p>
     * Получает список всех пациентов, хранящихся в базе данных
     * <p>
     * Eng:
     * <p>
     * Gets the list of all patients, which are stored in the database
     * @return {@link List} of {@link PatientEntity}
     * @throws Exception SQLException
     */
    public Collection getAllPatients() throws Exception {

        Session session = null;
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            patients = session.createCriteria(PatientEntity.class).list();
        } catch (Exception e){
            LOGGER.info("PatientDAOImpl.getAllPatients()");
            LOGGER.error(e.getMessage(),e);
        } finally {
            if (session!=null && session.isOpen()){
                session.close();
            }
        }
        return patients;
    }

    /**
     * Рус:
     * <p>
     * Поиск пациентов со схожим id
     * <p>
     * Eng:
     * <p>
     * Searches patients with similar id
     * @param id identifical number of patient
     * @return {@link List} of {@link PatientEntity}
     * @throws Exception SQLException
     */
    public Collection getAllPatients(int id) throws Exception {

        Session session = null;
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(PatientEntity.class);
            criteria.add(Restrictions.sqlRestriction(" id LIKE '%"+id+"%' "));
            patients = criteria.list();
            session.getTransaction().commit();

        } catch (Exception e){
            LOGGER.info("PatientDAOImpl.getAllPatients(int id)");
            LOGGER.error(e.getMessage(),e);
        } finally {
            if (session!=null && session.isOpen()){
                session.close();
            }
        }
        return patients;
    }

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
     * @return {@link List} of {@link PatientEntity}
     * @throws Exception SQLException
     */
    public Collection getAllPatients(String secondname, String firstname, String thirdname) throws Exception {

        Session session = null;
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        PatientEntity patientEntity = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (firstname.length() == 0 && thirdname.length() == 0) {
                Query query = session.createQuery("FROM PatientEntity " +
                        "WHERE secondname like :second");
                query.setParameter("second", secondname + '%');
                patients = query.list();
            }
            else if (firstname.length() > 0 && thirdname.length() == 0){
                Query query = session.createQuery("FROM PatientEntity " +
                        "WHERE secondname like :second AND firstname like :first");
                query.setParameter("second", secondname + '%');
                query.setParameter("first", firstname + '%');
                patients = query.list();
            }
            else {
                Query query = session.createQuery("FROM PatientEntity " +
                        "WHERE secondname like :second AND firstname like :first AND thirdname like :third");
                query.setParameter("second", secondname + '%');
                query.setParameter("first", firstname + '%');
                query.setParameter("third", thirdname + '%');
                patients = query.list();
            }
            session.getTransaction().commit();

        } catch (Exception e){
            LOGGER.info("PatientDAOImpl.getAllPatients(String secondname, String firstname, String thirdname)");
            LOGGER.error(e.getMessage(),e);
        } finally {
            if (session!=null && session.isOpen()){
                session.close();
            }
        }
        return patients;
    }

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
    public PatientEntity getPatient(int id) throws Exception {

        Session session = null;
        PatientEntity patientEntity = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            patientEntity = (PatientEntity) session.get(PatientEntity.class, id);
        } catch (Exception e){
            LOGGER.info("PatientDAOImpl.getPatient(int id)");
            LOGGER.error(e.getMessage(),e);
        } finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }

        return patientEntity;
    }

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
    public void addPatient(PatientEntity patient) throws Exception {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.info("PatientDAOImpl.addPatient(PatientEntity patient)");
            LOGGER.info(patient.toString());
            LOGGER.error(e.getMessage(),e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

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
    public void updatePatient(PatientEntity patient) throws Exception {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(patient);
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.info("PatientDAOImpl.updatePatient(PatientEntity patient)");
            LOGGER.info(patient.toString());
            LOGGER.error(e.getMessage(),e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

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
    public void deletePatient(PatientEntity patient) throws Exception {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(patient);
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.info("PatientDAOImpl.deletePatient(PatientEntity patient)");
            LOGGER.info(patient.toString());
            LOGGER.error(e.getMessage(),e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
