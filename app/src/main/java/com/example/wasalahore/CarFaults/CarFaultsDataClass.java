package com.example.wasalahore.CarFaults;

import java.util.List;

public class CarFaultsDataClass {

    String id;
    String title;
    String technicalDescription;
    String description;
    String causes;
    String solutions;

    public CarFaultsDataClass(String id, String title, String technicalDescription, String description, String causes, String solutions) {
        this.id = id;
        this.title = title;
        this.technicalDescription = technicalDescription;
        this.description = description;
        this.causes = causes;
        this.solutions = solutions;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTechnicalDescription() {
        return technicalDescription;
    }

    public void setTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

    public String getSolutions() {
        return solutions;
    }

    public void setSolutions(String solutions) {
        this.solutions = solutions;
    }
}
