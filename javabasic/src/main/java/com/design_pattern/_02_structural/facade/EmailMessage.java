package com.design_pattern._02_structural.facade;

import lombok.Data;

@Data
public class EmailMessage {
    private String to;
    private String from;
    private String subject;
    private String text;
}
