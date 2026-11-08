package org.example.studentmanagement;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;

@Entity
@Table(name = "student")
public class Student {
    @Id // set primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto generate ID value
    private int id;
    @Size(min = 3, max = 50, message = "Name must be at least more than 3 characters")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @Size(min = 3, max = 50, message = "Address must be at least more than 3 characters")
    private String address;

    // Default Constructor
    public Student() {}

    // Parameter Constructor
    public Student(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // ID
    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}

    // Name
    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;}

    // Email
    public String getEmail() {
        return email;}
    public void setEmail(String email) {
        this.email = email;}

    // Address
    public String getAddress() {
        return address;}
    public void setAddress(String address) {
        this.address = address;
    }
}
