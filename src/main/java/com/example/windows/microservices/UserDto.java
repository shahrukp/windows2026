package com.example.windows.microservices;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
@JsonProperty
    private String name;
    @JsonProperty
    private String email;
    @JsonProperty
    private long id;

    public UserDto(String name, String email, long id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public UserDto(){

    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
