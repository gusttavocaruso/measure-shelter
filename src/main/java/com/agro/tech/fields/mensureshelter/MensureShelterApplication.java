package com.agro.tech.fields.mensureshelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MensureShelterApplication {

  public static void main(String[] args) {
    SpringApplication.run(MensureShelterApplication.class, args);
  }

}
