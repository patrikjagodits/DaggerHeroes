package com.example.DaggerheartCreator.controller;

import com.example.DaggerheartCreator.model.Character;
import com.example.DaggerheartCreator.repository.CharacterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    // Get all characters
    @GetMapping
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    // Create a new character
    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterRepository.save(character);
    }

}
