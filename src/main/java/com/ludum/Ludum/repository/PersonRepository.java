package com.ludum.Ludum.repository;

import com.ludum.Ludum.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
