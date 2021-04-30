package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MessageModel")
public class MessageModel {

    @Column(name = "message")
    @NotNull
    @Size(min = 2)
    @JsonProperty
    private String message;

    @Column(name = "sender")
    @NotNull
    @Size(min = 2)
    @JsonProperty
    private String sender;

    @Column(name = "client")
    @NotNull
    @Size(min = 2)
    @JsonProperty
    private String client;

    @Id
    @Column(name = "id")
    @NotNull
    @Size(min = 1)
    @JsonProperty
    private int id;

    public MessageModel() {
    }

    public MessageModel(String message, String sender, String client, int id) {
        this.message = message;
        this.sender = sender;
        this.client = client;
        this.id = id;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MessageModel " +
                "message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                ", client='" + client + '\'' +
                ", id=" + id;
    }
}
