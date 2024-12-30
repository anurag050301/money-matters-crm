package org.moneymatters.crm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class ErrorDetails {
    private Date timeStamp;
    private String message;

    public ErrorDetails( Date timeStamp, String message) {
        this.timeStamp = timeStamp;
        this.message = message;
    }
}
