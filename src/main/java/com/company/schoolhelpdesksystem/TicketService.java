package com.company.schoolhelpdesksystem;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for Ticket operations
 */
public class TicketService {

    private MongoCollection<Document> ticketCollection;

    public TicketService() {
        MongoDatabase database = DatabaseConnection.getDatabase();
        ticketCollection = database.getCollection("tickets");
    }

    // Save a new ticket
    public void saveTicket(Ticket ticket) {
        Document doc = new Document("userId", ticket.getUserId())
                .append("department", ticket.getDepartment())
                .append("issue", ticket.getIssue())
                .append("status", ticket.getStatus());
        ticketCollection.insertOne(doc);
        ticket.setId(doc.getObjectId("_id"));
    }

    // Get all tickets
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        for (Document doc : ticketCollection.find()) {
            Ticket ticket = new Ticket();
            ticket.setId(doc.getObjectId("_id"));
            ticket.setUserId(doc.getString("userId"));
            ticket.setDepartment(doc.getString("department"));
            ticket.setIssue(doc.getString("issue"));
            ticket.setStatus(doc.getString("status"));
            tickets.add(ticket);
        }
        return tickets;
    }

    // Get tickets by user ID
    public List<Ticket> getTicketsByUser(String userId) {
        List<Ticket> tickets = new ArrayList<>();
        for (Document doc : ticketCollection.find(Filters.eq("userId", userId))) {
            Ticket ticket = new Ticket();
            ticket.setId(doc.getObjectId("_id"));
            ticket.setUserId(doc.getString("userId"));
            ticket.setDepartment(doc.getString("department"));
            ticket.setIssue(doc.getString("issue"));
            ticket.setStatus(doc.getString("status"));
            tickets.add(ticket);
        }
        return tickets;
    }

    // Update ticket status
    public void updateTicketStatus(ObjectId ticketId, String newStatus) {
        ticketCollection.updateOne(
                Filters.eq("_id", ticketId),
                new Document("$set", new Document("status", newStatus))
        );
    }
}