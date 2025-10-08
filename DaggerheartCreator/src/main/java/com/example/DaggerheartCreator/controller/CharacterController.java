package com.example.DaggerheartCreator.controller;

import com.example.DaggerheartCreator.dto.CharacterCreationRequest;
import com.example.DaggerheartCreator.model.Character;
import com.example.DaggerheartCreator.repository.CharacterRepository;
import com.example.DaggerheartCreator.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody CharacterCreationRequest request){
        Character createdCharacter = characterService.createCharacter(request);

        return new ResponseEntity<>(createdCharacter, HttpStatus.CREATED);
    }

}
