package com.example.DaggerheartCreator.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "domain")
    private List<DomainCards> domainCardsList;

    // Getterek és Setterek
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}