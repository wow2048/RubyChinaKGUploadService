package com.example.RubyChinaUploadService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue
    private long id;

    @Property
    private String title;

    @Property
    private String content;

    @Property
    private String time;

    @Property
    private String type;

    @Property
    private String sentiment;

    @Property("excellent")
    private boolean isExcellent;
}