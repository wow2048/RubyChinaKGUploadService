package com.example.RubyChinaUploadService.dao;

import com.example.RubyChinaUploadService.entity.Blog;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends Neo4jRepository<Blog, Long> {

}
