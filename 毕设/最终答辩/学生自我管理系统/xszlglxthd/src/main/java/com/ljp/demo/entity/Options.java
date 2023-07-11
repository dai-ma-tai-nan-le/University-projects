package com.ljp.demo.entity;


import java.util.List;
//级联选择器
public class Options {
    private String value;
    private String label;

    public Options(String value,String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
