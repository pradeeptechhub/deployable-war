package com.patel.pradeep.deployablewar.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MailModel {
    private String from;
    private String to;
    private String subject;
    private String content;
    private Map<String, Object> model = new HashMap<>();
}
