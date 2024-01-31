package com.example.demo.Repo;

import com.example.demo.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonInterface extends JpaRepository<Person, Long> {
}
