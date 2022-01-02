
package com.jgp.securewepapp.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "qualities")
@NamedQuery(name = "quality.byUsers", query = "select qa from qualities qa where qa.users.id = :id")
public class Quality implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
   private Integer id;

@Column(name = "description", nullable = false)
private String description;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
private Users user;

    public Quality() {
    }

    public Quality(String description, Users user) {
        this.description = description;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Users getUser() {
        return user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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

        final Quality other = (Quality) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return true;
    }


    
}
