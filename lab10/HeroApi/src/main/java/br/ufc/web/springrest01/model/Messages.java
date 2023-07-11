package br.ufc.web.springrest01.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Messages {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private UserAccount sender;
    @ManyToOne
    private UserAccount recipient;
    private String content;
    private LocalDateTime timestamp;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public UserAccount getSender() {
        return sender;
    }
    public void setSender(UserAccount sender) {
        this.sender = sender;
    }
    public UserAccount getRecipient() {
        return recipient;
    }
    public void setRecipient(UserAccount recipient) {
        this.recipient = recipient;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp() {
        this.timestamp = LocalDateTime.now();
    }
    
    

}
