package org.orig.WebLab3333.MainPage;

import java.util.HashMap;
import java.util.Map;

public class DataFormController {
    private double x;
    private double y;
    private final HashMap<Integer, Boolean> checkbox_state_mapping;
    private final HashMap<Integer, Integer> checkbox_value_mapping;
    private double r;

    public DataFormController() {
        this.x = 0;
        this.y = 0;
        this.checkbox_state_mapping = new HashMap<>();
        this.checkbox_value_mapping = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            this.checkbox_value_mapping.put(i, -4 + i);
            this.checkbox_state_mapping.put(i, false);

        }
        this.r = 1;

    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Boolean getY0() {
        return checkbox_state_mapping.get(0);
    }

    public Boolean getY1() {
        return checkbox_state_mapping.get(1);
    }

    public Boolean getY2() {
        return checkbox_state_mapping.get(2);
    }

    public Boolean getY3() {
        return checkbox_state_mapping.get(3);
    }

    public Boolean getY4() {
        return checkbox_state_mapping.get(4);
    }

    public Boolean getY5() {
        return checkbox_state_mapping.get(5);
    }

    public Boolean getY6() {
        return checkbox_state_mapping.get(6);
    }

    public Boolean getY7() {
        return checkbox_state_mapping.get(7);
    }

    public Boolean getY8() {
        return checkbox_state_mapping.get(8);
    }

    public void setY0(Boolean y) {
        checkbox_state_mapping.replace(0, y);
    }

    public void setY1(Boolean y) {
        checkbox_state_mapping.replace(1, y);
    }

    public void setY2(Boolean y) {
        checkbox_state_mapping.replace(2, y);
    }

    public void setY3(Boolean y) {
        checkbox_state_mapping.replace(3, y);
    }

    public void setY4(Boolean y) {
        checkbox_state_mapping.replace(4, y);
    }

    public void setY5(Boolean y) {
        checkbox_state_mapping.replace(5, y);
    }

    public void setY6(Boolean y) {
        checkbox_state_mapping.replace(6, y);
    }

    public void setY7(Boolean y) {
        checkbox_state_mapping.replace(7, y);
    }

    public void setY8(Boolean y) {
        checkbox_state_mapping.replace(8, y);
    }

    public void revY(Integer id) {
        for (int i = 0; i < 9; i++) {
            if (i != id)
                this.checkbox_state_mapping.replace(i, false);

        }


    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getYValue() {
        double value = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < 9; i++){
            if (this.checkbox_state_mapping.get(i)){
                value = this.checkbox_value_mapping.get(i);
            }
        }

        return value;
    }
}
