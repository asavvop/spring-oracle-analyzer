package com.analyzer.oracle.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table {
    
    public Table(String table, String owner) {
        this.tableName = table;
        this.tableOwner = owner;
    }

    private String tableName;

    private String tableOwner;
}
