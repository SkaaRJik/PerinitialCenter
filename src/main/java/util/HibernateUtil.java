package util;

import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import stages.ErrorStage;

/**
 * Created by SkaaRJ on 27.10.2017.
 */
public class HibernateUtil{
    private static final SessionFactory sessionFactory;
    static{
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            //ex.printStackTrace();
            //System.err.println("Initial SessionFactory creation failed." + ex);
            try {
                ErrorStage.display(ex.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
