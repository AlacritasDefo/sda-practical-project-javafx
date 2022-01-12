package pl.sda.api.swapi.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonDomain {
    private String name;
    private int height;
    private int mass;
}