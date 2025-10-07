package com.example.DaggerheartCreator.dto;

public class CharacterCreationRequest {
    private String name;
    private Long ancestryId;
    private Long communityId;
    private Long characterClassId;
    private Long subclassId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAncestryId() {
        return ancestryId;
    }

    public void setAncestryId(Long ancestryId) {
        this.ancestryId = ancestryId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getCharacterClassId() {
        return characterClassId;
    }

    public void setCharacterClassId(Long characterClassId) {
        this.characterClassId = characterClassId;
    }

    public Long getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(Long subclassId) {
        this.subclassId = subclassId;
    }
}
