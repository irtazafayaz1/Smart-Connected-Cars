package com.example.wasalahore.Model;

public class ReviewDataClass {

    private String Company;
    private String Model;
    private String lisence;

    public String getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(String avg_rating) {
        this.avg_rating = avg_rating;
    }

    private String avg_rating;
    private String body_shape, tyres, shawks, sound_system, room_space, seating_comfort, ac, steering, brakes, gear, wind_screen, head_lights, backlights, doors, horn, battery, design, generator,
            compressor, cooling_system, plugs, seatbelt, gear_box, fuel_average, pick;

    public ReviewDataClass(String company, String model, String lisence, String body_shape, String tyres, String shawks, String sound_system, String room_space, String seating_comfort, String ac, String steering, String brakes, String gear, String wind_screen, String head_lights, String backlights, String doors, String horn, String battery, String design, String generator, String compressor, String cooling_system, String plugs, String seatbelt, String gear_box, String fuel_average, String pick,String avg_rating) {
        Company = company;
        Model = model;
        this.lisence = lisence;
        this.body_shape = body_shape;
        this.tyres = tyres;
        this.shawks = shawks;
        this.sound_system = sound_system;
        this.room_space = room_space;
        this.seating_comfort = seating_comfort;
        this.ac = ac;
        this.steering = steering;
        this.brakes = brakes;
        this.gear = gear;
        this.wind_screen = wind_screen;
        this.head_lights = head_lights;
        this.backlights = backlights;
        this.doors = doors;
        this.horn = horn;
        this.battery = battery;
        this.design = design;
        this.generator = generator;
        this.compressor = compressor;
        this.cooling_system = cooling_system;
        this.plugs = plugs;
        this.seatbelt = seatbelt;
        this.gear_box = gear_box;
        this.fuel_average = fuel_average;
        this.pick = pick;
        this.avg_rating=avg_rating;
    }

    public ReviewDataClass() {
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getLisence() {
        return lisence;
    }

    public void setLisence(String lisence) {
        this.lisence = lisence;
    }

    public String getBody_shape() {
        return body_shape;
    }

    public void setBody_shape(String body_shape) {
        this.body_shape = body_shape;
    }

    public String getTyres() {
        return tyres;
    }

    public void setTyres(String tyres) {
        this.tyres = tyres;
    }

    public String getShawks() {
        return shawks;
    }

    public void setShawks(String shawks) {
        this.shawks = shawks;
    }

    public String getSound_system() {
        return sound_system;
    }

    public void setSound_system(String sound_system) {
        this.sound_system = sound_system;
    }

    public String getRoom_space() {
        return room_space;
    }

    public void setRoom_space(String room_space) {
        this.room_space = room_space;
    }

    public String getSeating_comfort() {
        return seating_comfort;
    }

    public void setSeating_comfort(String seating_comfort) {
        this.seating_comfort = seating_comfort;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getSteering() {
        return steering;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getWind_screen() {
        return wind_screen;
    }

    public void setWind_screen(String wind_screen) {
        this.wind_screen = wind_screen;
    }

    public String getHead_lights() {
        return head_lights;
    }

    public void setHead_lights(String head_lights) {
        this.head_lights = head_lights;
    }

    public String getBacklights() {
        return backlights;
    }

    public void setBacklights(String backlights) {
        this.backlights = backlights;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getHorn() {
        return horn;
    }

    public void setHorn(String horn) {
        this.horn = horn;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public String getCompressor() {
        return compressor;
    }

    public void setCompressor(String compressor) {
        this.compressor = compressor;
    }

    public String getCooling_system() {
        return cooling_system;
    }

    public void setCooling_system(String cooling_system) {
        this.cooling_system = cooling_system;
    }

    public String getPlugs() {
        return plugs;
    }

    public void setPlugs(String plugs) {
        this.plugs = plugs;
    }

    public String getSeatbelt() {
        return seatbelt;
    }

    public void setSeatbelt(String seatbelt) {
        this.seatbelt = seatbelt;
    }

    public String getGear_box() {
        return gear_box;
    }

    public void setGear_box(String gear_box) {
        this.gear_box = gear_box;
    }

    public String getFuel_average() {
        return fuel_average;
    }

    public void setFuel_average(String fuel_average) {
        this.fuel_average = fuel_average;
    }

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }
}
