package org.orig.WebLab3333.Database;

import org.orig.WebLab3333.MainPage.HistoryItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class HistoryItemDAO {
    private final SessionFactory factory;
    public HistoryItemDAO() {
        factory = Utils.getSessionFactory();
    }


    public void save(HistoryItem item) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
    }


}
