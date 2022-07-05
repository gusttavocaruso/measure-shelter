package com.agro.tech.fields.mensureshelter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.agro.tech.fields.mensureshelter.model.Ilha;

public interface IlhaRepository extends MongoRepository<Ilha, String> {
}
