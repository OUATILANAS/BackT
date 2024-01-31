package com.example.demo.Services;
import com.example.demo.Repo.PersonInterface;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.annotation.PostConstruct;
import com.example.demo.Models.Person ;
@Service
public class PersonService {
    @Value("persons.csv")
    private String csvFilePath;
    @Autowired
    private PersonInterface PersonRepositery;
    private List<Person> listePersons= new ArrayList<>();
    @PostConstruct
    public void init() {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {

                Person oneperson = new Person(line[0],line[1], Integer.parseInt(line[2]));

                listePersons.add(oneperson);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Person> getAllPersons() {
        return listePersons;
    }

    public Person addPerson(Person person) {


        listePersons.add(person);

        return person;
    }

    public Person addRandomPerson() {
        Random random = new Random();
        String nomAleatoire = "Nom" + random.nextInt(100);
        String prenomAleatoire = "Prenom" + random.nextInt(100);
        int ageAleatoire = random.nextInt(100);
        Person RandomPerson = new Person(nomAleatoire, prenomAleatoire, ageAleatoire);
        return PersonRepositery.save(RandomPerson);

    }
}
