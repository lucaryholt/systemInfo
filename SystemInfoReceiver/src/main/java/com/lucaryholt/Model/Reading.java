package com.lucaryholt.Model;

import javax.swing.*;

public class Reading {

    private String name;
    private String text;
    private JLabel jLabel = new JLabel();
    private String unit;

    public Reading(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public Reading(String name, String text, JLabel jLabel) {
        this.name = name;
        this.text = text;
        this.jLabel = jLabel;
    }

    public Reading() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        if(name.equals("")){
            return text;
        }
        return name + ": \t" + text + " " + unit;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setText(double d){
        this.text = d + "";
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }
}
