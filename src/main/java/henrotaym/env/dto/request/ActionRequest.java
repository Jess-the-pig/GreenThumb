package henrotaym.env.dto.request;

import henrotaym.env.entities.Plant;

import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

public class ActionRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Date is required")
    private Date due_at;

    @NotBlank(message = "Plant is required")
    private Plant plant;

    public String getName() {
        return name;
    }

    public Date getDue_at() {
        return due_at;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDue_at(Date due_at) {
        this.due_at = due_at;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
