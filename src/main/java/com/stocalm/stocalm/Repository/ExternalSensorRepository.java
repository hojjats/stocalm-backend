package com.stocalm.stocalm.Repository;

import com.stocalm.stocalm.Models.ExternalSensor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExternalSensorRepository extends MongoRepository<ExternalSensor, String> {
}
