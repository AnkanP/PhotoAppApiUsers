package com.example.photoappapiusers.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
//If the table doesnt exist JPA will create the table
public class UserEntity implements Serializable {


    private static final long serialVersionUID = -6826700931183903550L;
    //database id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 50)
    private String firstName;
    @Column(nullable = false,length = 50)
    private String lastName;

    // We dont need to store password in user databse
    //private String password;
    @Column(nullable = false,length =100, unique = true)
    private String email;
    @Column(nullable = true)
    private String userId;
    @Column(nullable = true)
    private String encryptedPassword;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
