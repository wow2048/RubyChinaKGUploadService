package com.example.RubyChinaUploadService.dao;

import com.example.RubyChinaUploadService.entity.Ruby;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubyRepository extends Neo4jRepository<Ruby, Long> {
    Ruby findByName(String name);
}