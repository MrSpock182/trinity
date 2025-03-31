package br.com.etec.messaging.dto;

public class UserProducer {
    private String name;

    public UserProducer() {
    }

    public UserProducer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
