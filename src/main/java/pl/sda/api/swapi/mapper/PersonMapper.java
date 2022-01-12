package pl.sda.api.swapi.mapper;

import pl.sda.api.swapi.domain.PersonDomain;
import pl.sda.api.swapi.model.Person;

public class PersonMapper {
    public static PersonDomain mapTo(Person model) {
        return PersonDomain.builder()
                .name(model.getName())
                .height(Integer.parseInt(model.getHeight()))
                .mass(Integer.parseInt(model.getMass()))
                .build();
    }
}