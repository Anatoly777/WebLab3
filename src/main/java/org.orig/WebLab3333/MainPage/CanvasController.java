package org.orig.WebLab3333.MainPage;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class CanvasController implements Serializable {
    private Double x = 0D;
    private Double y = 0D;
    private Double r;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public void mouseClick(){
        FacesContext context = FacesContext.getCurrentInstance();
        Double r = (Double)((UIInput)context.getViewRoot().findComponent(":canvas_form:canvas_r")).getValue();
        MainPageController mainPageController = context.getApplication().evaluateExpressionGet(context, "#{mainPage}", MainPageController.class);
        System.out.println(x);
        System.out.println(y);
        System.out.println(r);
        mainPageController.shoot(x, y, r);
    }
}
