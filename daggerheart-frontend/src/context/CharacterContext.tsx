import React, { createContext, useState, useContext, type ReactNode } from "react";
import type { CharacterClass, Subclass, Ancestry, Community } from "../types";

type AbilityScores = {
  agility: number | null;
  strenght: number | null;
  finesse: number | null;
  instinct: number | null;
  presence: number | null;
  knowledge: number | null;
};

// 1. Define the shape of the data
interface CharacterBuilderState {
  characterClass: CharacterClass | null;
  subclass: Subclass | null;
  ancestry: Ancestry | null;
  community: Community | null;
  abilityScores: AbilityScores;
  // ... I'll add more fields here later
}

// 2. Define what the context will provide: the state and a function to update it
interface CharacterContextType {
  characterData: CharacterBuilderState;
  setCharacterData: React.Dispatch<React.SetStateAction<CharacterBuilderState>>;
}

// 3. Create the actual context
const CharacterContext = createContext<CharacterContextType>(
  {} as CharacterContextType
);

// 4. Create the Provider component that will wrap our app
export function CharacterProvider({ children }: { children: ReactNode }) {
  const [characterData, setCharacterData] = useState<CharacterBuilderState>({
    characterClass: null,
    subclass: null,
    ancestry: null,
    community: null,
    abilityScores: {
      agility: null,
      strenght: null,
      finesse: null,
      instinct: null,
      presence: null,
      knowledge: null,
    },
  });

  return (
    <CharacterContext.Provider value={{ characterData, setCharacterData }}>
      {children}
    </CharacterContext.Provider>
  );
}

// 5. Create a custom hook for easy access to the context
export function useCharacterBuilder() {
  return useContext(CharacterContext);
}
