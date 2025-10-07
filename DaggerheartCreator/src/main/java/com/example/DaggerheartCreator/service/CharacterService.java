package com.example.DaggerheartCreator.service;

import com.example.DaggerheartCreator.dto.CharacterCreationRequest;
import com.example.DaggerheartCreator.model.Character;

public interface CharacterService {
    Character createCharacter(CharacterCreationRequest request);
}
