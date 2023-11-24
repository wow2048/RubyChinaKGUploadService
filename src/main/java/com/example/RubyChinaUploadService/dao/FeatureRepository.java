package com.example.RubyChinaUploadService.dao;

import com.example.RubyChinaUploadService.entity.Feature;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends Neo4jRepository<Feature, Long> {
    Feature findByName(String name);
}

