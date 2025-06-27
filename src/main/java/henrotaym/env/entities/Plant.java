package henrotaym.env.entities;

import henrotaym.env.enums.StatusName;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String species;
    private String name;
    private Date buyingDate;
    private StatusName status;

    // Getters
    public BigInteger getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public StatusName getStatus() {
        return status;
    }

    // Setters
    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    public void setStatus(StatusName status) {
        this.status = status;
    }
}
