package com.agro.tech.fields.mensureshelter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.agro.tech.fields.mensureshelter.model.Foto;

public interface FotoRepository extends MongoRepository<Foto, String> {

}
