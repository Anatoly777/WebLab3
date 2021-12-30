package org.orig.WebLab3333.Database;

import org.orig.WebLab3333.MainPage.HistoryItem;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Utils {
    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(HistoryItem.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                factory = configuration.buildSessionFactory(builder.build());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return factory;
    }
}
