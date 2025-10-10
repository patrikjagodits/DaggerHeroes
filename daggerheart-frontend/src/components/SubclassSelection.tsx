import React, { useState, useEffect } from 'react';
import axios from 'axios';
import type { Subclass } from '../types';
import { useCharacterBuilder } from '../context/CharacterContext';

// This component receives functions to go to the next OR previous step
interface SubclassSelectionProps {
    onNext: () => void;
    onBack: () => void;
}

export function SubclassSelection({ onNext, onBack }: SubclassSelectionProps) {
    const [subclasses, setSubclasses] = useState<Subclass[]>([]);
    const [isLoading, setIsLoading] = useState<boolean>(false);
    const { characterData, setCharacterData } = useCharacterBuilder(); // Get global state

    // This effect runs whenever the selected characterClass changes
    useEffect(() => {
        // Only fetch subclasses if a class is actually selected
        if (characterData.characterClass) {
            setIsLoading(true);
            const classId = characterData.characterClass.id;
            
            // Fetch subclasses for the specific classId
            axios.get<Subclass[]>(`/api/gamedata/subclasses/${classId}`)
                .then(response => {
                    setSubclasses(response.data);
                    setIsLoading(false);
                })
                .catch(error => {
                    console.error("Failed to fetch subclasses", error);
                    setIsLoading(false);
                });
        }
    }, [characterData.characterClass]); // Dependency array ensures this runs when the class changes

    const handleSelectSubclass = (subclassId: string) => {
        const selectedSubclass = subclasses.find(s => s.id === parseInt(subclassId));
        if (selectedSubclass) {
            // Update the global state
            setCharacterData(prevData => ({ ...prevData, subclass: selectedSubclass }));
        }
    };
    
    // If for some reason the user is on this step without a class selected, guide them back.
    if (!characterData.characterClass) {
        return <div>Please go back and select a Class first.</div>
    }

    return (
        <div>
            <h2>2. Choose your Subclass for {characterData.characterClass.name}</h2>
            {isLoading ? <p>Loading subclasses...</p> : (
                <select 
                    onChange={(e) => handleSelectSubclass(e.target.value)}
                    value={characterData.subclass?.id || ""}
                >
                    <option value="">-- Select a Subclass --</option>
                    {subclasses.map(s => (
                        <option key={s.id} value={s.id}>{s.name}</option>
                    ))}
                </select>
            )}
            <p>{characterData.subclass?.description}</p>
            
            <div>
                <button onClick={onBack}>Back</button>
                <button onClick={onNext} disabled={!characterData.subclass}>Next</button>
            </div>
        </div>
    );
}