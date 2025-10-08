package com.example.DaggerheartCreator.service;

import com.example.DaggerheartCreator.dto.CharacterCreationRequest;
import com.example.DaggerheartCreator.model.*;
import com.example.DaggerheartCreator.model.Character;
import com.example.DaggerheartCreator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService{

    private final AncestryRepository ancestryRepository;
    private final CharacterClassRepository characterClassRepository;
    private final CharacterRepository characterRepository;
    private final CommunityRepository communityRepository;
    private final DomainRepository domainRepository;
    private final SubclassRepository subclassRepository;

    @Autowired
    public CharacterServiceImpl(AncestryRepository ancestryRepository, CharacterClassRepository characterClassRepository, CharacterRepository characterRepository, CommunityRepository communityRepository, DomainRepository domainRepository,
                                SubclassRepository subclassRepository) {
        this.ancestryRepository = ancestryRepository;
        this.characterClassRepository = characterClassRepository;
        this.characterRepository = characterRepository;
        this.communityRepository = communityRepository;
        this.domainRepository = domainRepository;
        this.subclassRepository = subclassRepository;
    }

    @Override
    public Character createCharacter(CharacterCreationRequest request){
        // 1. Retrieve the selected entities from the database based on the IDs received in the DTO.
        // The .orElseThrow() ensures that if an invalid ID is provided, the application throws an error.
        Ancestry ancestry = ancestryRepository.findById(request.getAncestryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Ancestry ID"));
        Community community = communityRepository.findById(request.getCommunityId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Community ID"));
        CharacterClass characterClass = characterClassRepository.findById(request.getCharacterClassId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Class ID"));
        Subclass subclass = subclassRepository.findById(request.getSubclassId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Subclass ID"));

        // 2. Create a new, empty character object.
        Character newCharacter = new Character();
        newCharacter.setName(request.getName());
        newCharacter.setAncestry(ancestry);
        newCharacter.setCommunity(community);
        newCharacter.setCharacterClass(characterClass);
        newCharacter.setSubclass(subclass);

        // 3. BUSINESS LOGIC: Set initial values according to the rules.
        // This part will need to be developed in detail based on the Daggerheart rulebook.
        // For now, it's just an example value.
        newCharacter.setLevel(1);
        newCharacter.setExperience(2);

        // Let’s assume every character starts with 5 HP and 5 Stress.
        newCharacter.setMaxHp(5);
        newCharacter.setCurrentHp(0);
        newCharacter.setMaxStress(5);
        newCharacter.setCurrentStress(0);

        // The class may provide bonuses.
        if (characterClass.getName().equals("Guardian")) {
            newCharacter.setMaxHp(newCharacter.getMaxHp() + 2); // A Guardian kap +2 HP-t
        }

        // 4. Save the populated, new character to the database using the repository.
        return characterRepository.save(newCharacter);
    }
}
