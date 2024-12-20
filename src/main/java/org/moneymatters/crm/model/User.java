package org.moneymatters.crm.model;

public class User {
    private String username;
    private String name;
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //Constructor
    public User(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }
    public User() {
    }

    //To String method
    @Override
    public String toString() {
        return "User = {" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
