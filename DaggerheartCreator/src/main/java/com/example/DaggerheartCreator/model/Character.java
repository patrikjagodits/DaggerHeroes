package com.example.DaggerheartCreator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "ancestry_id")
    private Ancestry ancestry;

    @ManyToOne
    @JoinColumn(name = "domain_id")
    private Domain domain;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    private int agility;
    private int strength;
    private int finesse;
    private int instinct;
    private int presence;
    private int knowledge;

    private int maxHp;
    private int currentHp;
    private int hope;
    private int maxStress;
    private int currentStress;
    private int evasion;
    private int armor;

    private int damage_threshold_low;
    private int damage_threshold_high;

    public Character() {
    }

    public Character(Long id, String name, Ancestry ancestry, Domain domain, Community community, int agility, int strength, int finesse, int instinct, int presence, int knowledge, int evasion, int armor, int damage_threshold_low, int damage_threshold_high, int maxHp, int currentHp, int hope, int maxStress, int currentStress) {
        this.id = id;
        this.name = name;
        this.ancestry = ancestry;
        this.domain = domain;
        this.community = community;
        this.agility = agility;
        this.strength = strength;
        this.finesse = finesse;
        this.instinct = instinct;
        this.presence = presence;
        this.knowledge = knowledge;
        this.evasion = evasion;
        this.armor = armor;
        this.damage_threshold_low = damage_threshold_low;
        this.damage_threshold_high = damage_threshold_high;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.hope = hope;
        this.maxStress = maxStress;
        this.currentStress = currentStress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ancestry getAncestry() {
        return ancestry;
    }

    public void setAncestry(Ancestry ancestry) {
        this.ancestry = ancestry;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getFinesse() {
        return finesse;
    }

    public void setFinesse(int finesse) {
        this.finesse = finesse;
    }

    public int getInstinct() {
        return instinct;
    }

    public void setInstinct(int instinct) {
        this.instinct = instinct;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDamage_threshold_low() {
        return damage_threshold_low;
    }

    public void setDamage_threshold_low(int damage_threshold_low) {
        this.damage_threshold_low = damage_threshold_low;
    }

    public int getDamage_threshold_high() {
        return damage_threshold_high;
    }

    public void setDamage_threshold_high(int damage_threshold_high) {
        this.damage_threshold_high = damage_threshold_high;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getHope() {
        return hope;
    }

    public void setHope(int hope) {
        this.hope = hope;
    }

    public int getMaxStress() {
        return maxStress;
    }

    public void setMaxStress(int maxStress) {
        this.maxStress = maxStress;
    }

    public int getCurrentStress() {
        return currentStress;
    }

    public void setCurrentStress(int currentStress) {
        this.currentStress = currentStress;
    }
}
