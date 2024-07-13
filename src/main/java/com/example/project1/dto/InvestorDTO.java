package com.example.project1.dto;

public class InvestorDTO {
    private String name;
    private String username;
    private String hashedPassword;
    private String email;
    private String contactInfo;

    public InvestorDTO() {}

    public InvestorDTO(String name, String username, String hashedPassword, String email, String contactInfo) {
        this.name = name;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.email = email;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
// Getters and setters
}

