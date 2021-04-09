package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageModel {
    @JsonProperty
    private String message;

    @JsonProperty
    private String sender;

    @JsonProperty
    private String client;

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
