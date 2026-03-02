package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

// Handles ticket creation and updates by returning fresh instances
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // Validation occurs inside build()
        return new IncidentTicket.Builder(id, reporterEmail, title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .tags(List.of("NEW"))
                .build();
    }

    // Creates a new ticket with CRITICAL priority; original remains unchanged
    public IncidentTicket escalateToCritical(IncidentTicket t) {
        List<String> updatedTags = new ArrayList<>(t.getTags());
        updatedTags.add("ESCALATED");

        return t.toBuilder()
                .priority("CRITICAL")
                .tags(updatedTags)
                .build();
    }

    // Assign an email and return a new ticket copy
    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}
