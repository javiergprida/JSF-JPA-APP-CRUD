package com.jgp.securewepapp.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "users")
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "users.all", query = "SELECT us FROM users us ORDER BY us.id"),
    @NamedQuery(name = "users.byUsername", query = "SELECT us FROM users us WHERE us.username = :username ")
})
public class Users implements Serializable {

    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fullname", nullable = false)
    private String user;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "usergroup", nullable = false)
    private String group;

    public Users() {
    }

    public Users(String user, String username, String password, String group) {
        this.user = user;
        this.username = username;
        this.password = password;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Users other = (Users) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return true;
    }

}
