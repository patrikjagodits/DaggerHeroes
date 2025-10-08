package com.example.DaggerheartCreator.controller;

import com.example.DaggerheartCreator.model.Ancestry;
import com.example.DaggerheartCreator.model.CharacterClass;
import com.example.DaggerheartCreator.model.Community;
import com.example.DaggerheartCreator.model.Subclass;
import com.example.DaggerheartCreator.repository.AncestryRepository;
import com.example.DaggerheartCreator.repository.CharacterClassRepository;
import com.example.DaggerheartCreator.repository.CommunityRepository;
import com.example.DaggerheartCreator.repository.SubclassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gamedata")
public class GameDataController {

    private final CharacterClassRepository characterClassRepository;
    private final SubclassRepository subclassRepository;
    private final AncestryRepository ancestryRepository;
    private final CommunityRepository communityRepository;

    @Autowired
    public GameDataController(CharacterClassRepository characterClassRepository, SubclassRepository subclassRepository, AncestryRepository ancestryRepository, CommunityRepository communityRepository) {
        this.characterClassRepository = characterClassRepository;
        this.subclassRepository = subclassRepository;
        this.ancestryRepository = ancestryRepository;
        this.communityRepository = communityRepository;
    }

    @GetMapping("/classes")
    public List<CharacterClass> getAllClasses(){
        return characterClassRepository.findAll();
    }

    @GetMapping("/subclasses/{classId}")
    public List<Subclass> getSubclassesForClass(@PathVariable Long classId) {
        return subclassRepository.findByPlayerClassId(classId);
    }

    @GetMapping("/ancestries")
    public List<Ancestry> getAllAncestries() {
        return ancestryRepository.findAll();
    }

    @GetMapping("/communities")
    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }
}
