import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useCharacterBuilder } from '../context/CharacterContext';
import type { CharacterClass } from '../types';


// This component receives functions to navigate between steps
interface ClassSelectionProps {
    onNext: () => void;
}

export function ClassSelection({ onNext }: ClassSelectionProps) {
    const [classes, setClasses] = useState<CharacterClass[]>([]);
    const { characterData, setCharacterData } = useCharacterBuilder(); // Get access to global state

    useEffect(() => {
        // Fetch classes from the backend
        axios.get<CharacterClass[]>('/api/gamedata/classes')
            .then(response => setClasses(response.data))
            .catch(error => console.error("Failed to fetch classes", error));
    }, []);

    const handleSelectClass = (classId: string) => {
        const selectedClass = classes.find(c => c.id === parseInt(classId));
        if (selectedClass) {
            // Update the global state with the selected class
            setCharacterData(prevData => ({ ...prevData, characterClass: selectedClass }));
        }
    };

    return (
        <div>
            <h2>1. Choose your Class</h2>
            <select 
                onChange={(e) => handleSelectClass(e.target.value)}
                value={characterData.characterClass?.id || ""}
            >
                <option value="">-- Select a Class --</option>
                {classes.map(c => (
                    <option key={c.id} value={c.id}>{c.name}</option>
                ))}
            </select>
            <p>{characterData.characterClass?.description}</p>

            <button onClick={onNext} disabled={!characterData.characterClass}>Next</button>
        </div>
    );
}