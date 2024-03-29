package pl.sda.api.swapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Vehicle {
    private String name;
    private String model;
    private String vehicle_class;
    private String manufacturer;
    private String length;
    private String cost_in_credits;
    private String crew;
    private String passengers;
    private String max_atmosphering_speed;
    private String cargo_capacity;
    private String consumables;
    private List<String> films;
    private List<String> pilots;
    private String url;
    private String created;
    private String edited;
}