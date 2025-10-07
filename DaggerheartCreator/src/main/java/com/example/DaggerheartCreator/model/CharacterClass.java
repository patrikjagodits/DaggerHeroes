package com.example.DaggerheartCreator.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class CharacterClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; //e.g. Bard, Druid
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "characterClass")
    private List<Subclass> subclasses;

    @ManyToMany
    @JoinTable(
            name = "class_domain",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "domain_id"))
    private Set<Domain> domains;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Subclass> getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(List<Subclass> subclasses) {
        this.subclasses = subclasses;
    }

    public Set<Domain> getDomains() {
        return domains;
    }

    public void setDomains(Set<Domain> domains) {
        this.domains = domains;
    }
}
