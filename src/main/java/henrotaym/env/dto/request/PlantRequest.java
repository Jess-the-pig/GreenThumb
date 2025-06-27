package henrotaym.env.dto.request;

import java.sql.Date;

import henrotaym.env.enums.StatusName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class PlantRequest {

    @NotBlank(message = "Species is required")
    private String species;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Buying date is required")
    @PastOrPresent(message = "Buying date cannot be in the future")
    private Date buyingDate;

    @NotNull(message = "Status is required")
    private StatusName status;

    // Getters
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
