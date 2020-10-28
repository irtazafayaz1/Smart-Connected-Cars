package com.example.wasalahore.RecyclerView;

public class CarDataClass {

    private String companyname;
    private String modelname;
    private String modelnumber;

    public CarDataClass(String companyname, String modelname, String modelnumber) {
        this.companyname = companyname;
        this.modelname = modelname;
        this.modelnumber = modelnumber;
    }

    public CarDataClass() {
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getModelnumber() {
        return modelnumber;
    }

    public void setModelnumber(String modelnumber) {
        this.modelnumber = modelnumber;
    }
}
