package com.matthem.driverlandscape;

import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface DriverRepository extends Repository<Neo4jDriver, UUID> {

    Neo4jDriver save(Neo4jDriver var1);
}
