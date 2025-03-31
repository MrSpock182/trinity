package br.com.etec.messaging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProducer {
    @JsonProperty
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
