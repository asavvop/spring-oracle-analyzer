package com.analyzer.oracle.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableReference {
    private String referencedOwner;
    private String name;
    private String type;
    private String referencedName;
    private String referencedType;

    public TableReference(String referencedOwner, String name, String type, String referencedName, String referencedType) {
        this.referencedOwner = referencedOwner;
        this.name = name;
        this.type = type;
        this.referencedName = referencedName;
        this.referencedType = referencedType;
    }
}
