package com.example.OnlineBookStore.DTO;

public class AuthorDTO {
    private String name;
    private String bio;

    public AuthorDTO(){

    }
    public AuthorDTO(String bio, String name) {
        this.bio = bio;
        this.name = name;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
