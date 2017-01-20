package net.vergien.boot.plugin.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.vergien.boot.plugin.people.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
