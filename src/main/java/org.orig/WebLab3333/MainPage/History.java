package org.orig.WebLab3333.MainPage;

import org.orig.WebLab3333.Database.HistoryItemDAO;

import java.io.Serializable;
import java.util.LinkedList;

public class History implements Serializable {
        public LinkedList<HistoryItem> history;
        HistoryItemDAO dao;
        public History(){
            this.history = new LinkedList<>();
            this.dao = new HistoryItemDAO();
        }
        public void addItem(HistoryItem item){
            this.dao.save(item);

            this.history.addFirst(item);
        }
        public LinkedList<HistoryItem> getHistory(){
            return this.history;
        }
}
