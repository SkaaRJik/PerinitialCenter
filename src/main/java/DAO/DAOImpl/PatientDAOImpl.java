package DAO.DAOImpl;

import DAO.PatientDAO;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import stages.ErrorStage;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.query.Query;
import patient.PatientEntity;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by SkaaRJ on 02.11.2017.
 */
public class PatientDAOImpl implements PatientDAO {

    private static final Logger LOGGER = Logger.getLogger(PatientDAOImpl.class.getSimpleName());

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
