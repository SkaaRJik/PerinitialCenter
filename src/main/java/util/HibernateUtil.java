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
 * Вызывается для работы с базой данных.
 * <p>
 * Eng:
 * <p>
 * Class for working with {@link SessionFactory}
 * Called to working with data base.
 */
public class HibernateUtil{
    /**
     * Рус:
     * <p>
     * Сессия для работы с базой данных.
     * <p>
     * Eng:
     * <p>
     * Session works with database
     */
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

    /**
     * Рус:
     * <p>
     * Геттер {@link #sessionFactory}
     * <p>
     * Eng:
     * Getter of {@link #sessionFactory}
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Рус:
     * <p>
     * Закрывает сессию, если она есть.
     * <p>
     * Eng:
     * <p>
     * Close existing session.
     */
    public static void closeSession() {
        if(sessionFactory!=null)
            HibernateUtil.getSessionFactory().close();
    }
}
