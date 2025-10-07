package com.analyzer.oracle.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trigger {

    public Trigger(String tableName, String ownerName, String triggerName, String triggerType, String triggeringEvent,
            String triggerBody) {
        this.tableName = tableName;
        this.ownerName = ownerName;
        this.triggerName = triggerName;
        this.triggerType = triggerType;
        this.triggeringEvent = triggeringEvent;
        this.triggerBody = triggerBody;
    }

    private String tableName;
    private String ownerName;
    private String triggerName;
    private String triggerType;
    private String triggeringEvent;
    private String triggerBody;

}
