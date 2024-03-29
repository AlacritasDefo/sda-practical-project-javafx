package pl.sda.api.swapi.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface SWAPIRepository<T> {
    Optional<T> findById(int id) throws IOException, InterruptedException;
    List<T> findAll() throws IOException, InterruptedException;
    Optional<T> findByUrl(String url) throws IOException, InterruptedException;
}