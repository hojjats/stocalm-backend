package com.stocalm.stocalm.Repository;

import com.stocalm.stocalm.Models.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SensorRepository extends MongoRepository<Sensor, String> {
}
