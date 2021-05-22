package org.example;


public class Vehicle {
    private String id;
    private String brand;
    private String type;
    private int vintage;
    private String origin;

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    public Vehicle(String id, String brand, String type, int vintage, String origin){
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.vintage = vintage;
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", vintage=" + vintage + '\'' +
                ", origin=" + origin +
                '}';
    }
}
