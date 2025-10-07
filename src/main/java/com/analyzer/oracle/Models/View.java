package com.analyzer.oracle.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class View {
    
     public View(String view, String owner) {
        this.viewName = view;
        this.tableOwner = owner;
    }

    private String viewName;

    private String tableOwner;
}
