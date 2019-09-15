package com.mail.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Builder
public class MailEvent {

    private MailType type;
    private Set<String> participants;
    private Map<String, String> metadata;
}
