package org.orig.WebLab3333.MainPage;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


public class MainPageController {
    private DataFormController dataFormController;
    private History history;
    private String lastHitState;
    private final String sessionId;

    public MainPageController(){
        FacesContext context = FacesContext.getCurrentInstance();
        history = context.getApplication().evaluateExpressionGet(context, "#{history}", History.class);
        dataFormController = context.getApplication().evaluateExpressionGet(context, "#{dataForm}", DataFormController.class);
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        this.sessionId = session.getId();
    }

    private boolean calculateShot(double x, double y, double r){
        if (x >= 0 && y >= 0 && y <= r - x) return true;
        if (x >= 0 && y <= 0 && x <= r/2 && y >= -r) return true;
        return x <= 0 && y >= 0 && x * x + y * y <= r * r / 4;
    }

    public void shoot(double x, double y, double r){
        boolean isHit = this.calculateShot(x, y, r);
        this.history.addItem(new HistoryItem(sessionId, x, y, r, isHit));
        this.lastHitState = String.valueOf(isHit);
    }
    public void submit(){
        double x = this.dataFormController.getX();
        double y = this.dataFormController.getY();
        double r = this.dataFormController.getR();

        this.shoot(x, y, r);


    }

    public String getLastHitState() {
        return lastHitState;
    }

    public void setLastHitState(String lastHitState) {
        this.lastHitState = lastHitState;
    }

    public DataFormController getDataFormController() {
        return dataFormController;
    }

    public void setDataFormController(DataFormController dataFormController) {
        this.dataFormController = dataFormController;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
