package henrotaym.env.dto.request;

import henrotaym.env.enums.DiseaseName;

import jakarta.validation.constraints.NotBlank;

public class DiseaseRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Type is required")
    private DiseaseName type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiseaseName getType() {
        return type;
    }

    public void setType(DiseaseName type) {
        this.type = type;
    }
}
