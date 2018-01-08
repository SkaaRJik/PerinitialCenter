package util;

import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import stages.ErrorStage;

/**
 * Рус:
 * <p>
 * Класс для работы с {@link SessionFactory}.
 * Инициализурется единожды
 * <p>
 * Eng:
 * <p>
 * Class for working with {@link SessionFactory}
 */
public class HibernateUtil{
    private static final SessionFactory sessionFactory;
    static{
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            Logger logger = Logger.getLogger(HibernateUtil.class);
            ex.printStackTrace();
            logger.error("Initial SessionFactory creation failed.");
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
    public static void closeSession() {
        if(sessionFactory!=null)
            HibernateUtil.getSessionFactory().close();
    }
}
