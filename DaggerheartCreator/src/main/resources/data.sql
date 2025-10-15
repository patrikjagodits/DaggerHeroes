-- This is an example, you should add all classes, domains, etc.
-- Note the table and column names must match your @Entity and @Column definitions.
-- For PlayerClass we renamed it to CharacterClass, so the table name is likely character_class
INSERT INTO character_class (name, description) VALUES ('Warrior', 'A brave fighter skilled with many weapons.');
INSERT INTO character_class (name, description) VALUES ('Rogue', 'A cunning specialist who uses stealth and tricks.');
INSERT INTO character_class (name, description) VALUES ('Wizard', 'A powerful master of arcane arts.');

-- Add subclasses, making sure the player_class_id matches the IDs created above (usually 1, 2, 3...)
INSERT INTO subclass (name, description, character_class_id) VALUES ('Gladiator', 'A warrior who fights for spectacle.', 1);
INSERT INTO subclass (name, description, character_class_id) VALUES ('Thief', 'A rogue who excels at infiltration.', 2);

-- Add ancestries
INSERT INTO ancestry (name, description) VALUES ('Human', 'Adaptable and resilient.');
INSERT INTO ancestry (name, description) VALUES ('Elf', 'Graceful and attuned to nature.');

-- Add communities
INSERT INTO community (name, description) VALUES ('Bustling City', 'Grew up in a large, diverse metropolis.');
INSERT INTO community (name, description) VALUES ('Quiet Village', 'From a small, close-knit settlement.');