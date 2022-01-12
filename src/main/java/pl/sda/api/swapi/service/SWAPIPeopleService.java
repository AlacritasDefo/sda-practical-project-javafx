package pl.sda.api.swapi.service;

import pl.sda.api.swapi.config.Resource;
import pl.sda.api.swapi.domain.PersonDomain;
import pl.sda.api.swapi.mapper.PersonMapper;
import pl.sda.api.swapi.model.Person;
import pl.sda.api.swapi.repository.SWAPIGenericRepository;
import pl.sda.api.swapi.repository.SWAPIRepository;

import java.io.IOException;
import java.util.Optional;

public class SWAPIPeopleService {
    private SWAPIRepository<Person> people = new SWAPIGenericRepository<>(Resource.PEOPLE);

//    @Override
//    public Optional<Person> findById(int id){
//        try {
//            final Optional<Person> optionalPerson = people.findById(id);
//            if (optionalPerson.isPresent()){
//                Person person = optionalPerson.get();
//                return Optional.of(PersonMapper.mapTo(person));
//            } else {
//                return Optional.empty();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
