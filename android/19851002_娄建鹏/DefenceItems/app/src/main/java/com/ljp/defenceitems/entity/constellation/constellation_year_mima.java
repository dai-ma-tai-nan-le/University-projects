package com.ljp.defenceitems.entity.constellation;

import java.util.List;

public class constellation_year_mima {
    private String info;
    private List<String> text;
    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
    public List<String> getText() {
        return text;
    }

    @Override
    public String toString() {
        return "     概述：" + info + '\n' +
                "     说明：" + text;
    }
}
